package de.asheesh.tests;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.junit.Assert;
import org.junit.Test;
import de.asheesh.element.TransactionEvent;
import de.asheesh.element.utils.EventUtils;
import de.asheesh.exceptions.CacheNotFoundException;
import de.asheesh.exceptions.TransactionException;
import io.swagger.model.Stat;
import io.swagger.model.Transaction;

public class EventUtilsTests {

	@Test
	public void getStatsWhenMapIsNull(){
		//Empty Stats returned
		Assert.assertEquals(new Stat(), EventUtils.getStats(null));
	}
	
	@Test
	public void getStatsWhenMapIsNotNull(){
		//Non Empty Stats returned
		Map<Long,List<TransactionEvent>> map = new ConcurrentHashMap<>();
		List<TransactionEvent> list = new ArrayList<TransactionEvent>();
		list.add(new TransactionEvent(Long.MIN_VALUE));
		map.put(System.currentTimeMillis(),list);
		Assert.assertNotEquals(new Stat(), EventUtils.getStats(map));
	}
	
	@Test(expected=TransactionException.class)
	public void addTransactionWhenAmountIsNull() throws TransactionException{
		Transaction body = new Transaction();
		body.setAmount(null);
		body.setTimestamp(System.currentTimeMillis());
		Map<Long,List<TransactionEvent>> map = new ConcurrentHashMap<>();
		EventUtils.addTransaction(map,body);
	}
	
	@Test(expected=TransactionException.class)
	public void addTransactionWhenTimeStampIsNull() throws TransactionException{
		Transaction body = new Transaction();
		body.setAmount(Double.MAX_VALUE);
		body.setTimestamp(null);
		Map<Long,List<TransactionEvent>> map = new ConcurrentHashMap<>();
		EventUtils.addTransaction(map,body);
	}
	
	@Test(expected=CacheNotFoundException.class)
	public void addTransactionWhenMapIsNull() throws TransactionException{
		Transaction body = new Transaction();
		body.setAmount(Double.MAX_VALUE);
		body.setTimestamp(System.currentTimeMillis());
		EventUtils.addTransaction(null, body);
	}
	
	@Test
	public void addValidTransaction() throws TransactionException{
		Transaction body = new Transaction();
		body.setAmount(Double.MAX_VALUE);
		body.setTimestamp(System.currentTimeMillis());
		Map<Long,List<TransactionEvent>> map = new ConcurrentHashMap<>();
		EventUtils.addTransaction(map,body);
	}
}
