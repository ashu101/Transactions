package de.asheesh.element.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

import de.asheesh.constants.StringConstants;
import de.asheesh.element.TransactionEvent;
import de.asheesh.exceptions.CacheNotFoundException;
import de.asheesh.exceptions.TransactionException;
import io.swagger.model.Stat;
import io.swagger.model.Transaction;

/**
 * Utility class providing basic Event functions.
 * 
 * @author Asheesh
 *
 */
public class EventUtils {
	/**
	 * Generate Statistics for the Event Map like max,min,sum,avg,cnt in the
	 * last 60 seconds.
	 * 
	 * @param map
	 * @return {@link Stat}
	 */
	public static Stat getStats(Map<Long, List<TransactionEvent>> map) {
		Stat s = new Stat();
		if (map == null)
			return s;
		long cnt = 0, ts = System.currentTimeMillis();
		;
		double sum = 0.0d, min = 0.0d, max = 0.0d;

		for (Long temp : map.keySet()) {
			if (temp > ts - Integer.valueOf(StringConstants.WINDOW)) {
				for (TransactionEvent e : map.get(temp)) {
					cnt++;
					sum += e.getAmount();
					min = Math.min(min, e.getAmount());
					max = Math.max(max, e.getAmount());
				}
			}
		}

		s.setAvg(sum == 0.0d ? 0.0d : sum / cnt);
		s.setCount(cnt);
		s.setMin(min);
		s.setMax(max);
		s.setSum(sum);
		return s;
	}

	/**
	 * 
	 * Add transaction to cache(Event Map)
	 * 
	 * @param map
	 * @param body
	 * @throws CacheNotFoundException
	 */
	public static void addTransaction(Map<Long, List<TransactionEvent>> map, Transaction body)
			throws TransactionException {
		if (map == null)
			throw new CacheNotFoundException(StringConstants.CACHE_EMPTY);
		try {
			double amt = body.getAmount();
			long ts = body.getTimestamp();
			if (map.get(ts) == null){ List<TransactionEvent> list = new CopyOnWriteArrayList<>();
				list.add(new TransactionEvent(amt));
				map.put(ts, Collections.synchronizedList(list));
			}
			else
				map.get(ts).add(new TransactionEvent(amt));
		} catch (Exception e) {
			throw new TransactionException(e);
		}
	}

}
