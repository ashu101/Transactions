package de.asheesh.runnable;

import java.util.List;
import java.util.Map;

import de.asheesh.constants.StringConstants;
import de.asheesh.element.TransactionEvent;

/**
 * Class to implement Transactional Cache Clearing.
 * 
 * @author Asheesh
 *
 */
public class Cleaner implements Runnable{
	private Map<Long,List<TransactionEvent>> cache ;
	
	public Cleaner(Map<Long,List<TransactionEvent>> map){
		cache= map;
	}
	
	@Override
	public void run() {
		long ts= System.currentTimeMillis();
		for(Long temp :cache.keySet())
		{
			if(temp < ts-Integer.valueOf(StringConstants.WINDOW)){
				cache.remove(temp);
			}
		}
	}

}
