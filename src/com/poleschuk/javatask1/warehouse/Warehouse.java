package com.poleschuk.javatask1.warehouse;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.poleschuk.javatask1.exception.CustomArrayException;

public class Warehouse {
	private static final Logger logger = LogManager.getLogger();
	private static Warehouse instance;
	
	private Map<Integer, CustomArrayStatistics> statistics = new HashMap<>();
	
	public static Warehouse getInstance() {
		if (instance == null) {
			instance = new Warehouse();
		}
		return instance;
			
	}
	
	public void putById(Integer id, CustomArrayStatistics arrayStatistics) {
		statistics.put(id, arrayStatistics);
	}
	
	
	public CustomArrayStatistics getById(Integer id) throws CustomArrayException {
		if (statistics.containsKey(id)) {
			return statistics.get(id);
		} else {
			logger.error("No statistics with id " + id);
			throw new CustomArrayException("No statistics with id " + id);
		}		
	}
	
	public void clearValue(Integer id) {
		statistics.put(id, new CustomArrayStatistics());
	}


}
