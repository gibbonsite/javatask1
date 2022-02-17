package com.poleschuk.javatask1.observer.impl;

import java.util.OptionalDouble;
import java.util.OptionalInt;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.poleschuk.javatask1.entity.CustomArray;
import com.poleschuk.javatask1.exception.CustomArrayException;
import com.poleschuk.javatask1.observer.CustomArrayEvent;
import com.poleschuk.javatask1.observer.CustomArrayObserver;
import com.poleschuk.javatask1.service.impl.CustomArrayServiceImpl;
import com.poleschuk.javatask1.warehouse.CustomArrayStatistics;
import com.poleschuk.javatask1.warehouse.Warehouse;

public class CustomArrayObserverImpl implements CustomArrayObserver {

	private static Logger logger = LogManager.getLogger();
	
	@Override
	public void updateMinValue(CustomArrayEvent event) {
		try {
			CustomArray source = event.getSource();
			Warehouse warehouse = Warehouse.getInstance();
			CustomArrayStatistics statistics  = warehouse.getById(source.getId());
			CustomArrayServiceImpl arrayService = CustomArrayServiceImpl.getInstance();
			OptionalInt minValue = arrayService.getMinValue(source);
			if (minValue.isPresent()) {
				statistics.setMinValue(minValue);
			}
		} catch (CustomArrayException e) {
			logger.error(e.getMessage());
		}
	}

	@Override
	public void updateMaxValue(CustomArrayEvent event) {
		try {
			CustomArray source = event.getSource();
			Warehouse warehouse = Warehouse.getInstance();
			CustomArrayStatistics statistics  = warehouse.getById(source.getId());
			CustomArrayServiceImpl arrayService = CustomArrayServiceImpl.getInstance();
			OptionalInt maxValue = arrayService.getMaxValue(source);
			if (maxValue.isPresent()) {
				statistics.setMaxValue(maxValue);
			}
		} catch (CustomArrayException e) {
			logger.error(e.getMessage());
		}
	}

	@Override
	public void updateAvgValue(CustomArrayEvent event) {
		try {
			CustomArray source = event.getSource();
			Warehouse warehouse = Warehouse.getInstance();
			CustomArrayStatistics statistics  = warehouse.getById(source.getId());
			CustomArrayServiceImpl arrayService = CustomArrayServiceImpl.getInstance();
			OptionalDouble avgValue = arrayService.getAvgValue(source);
			if (avgValue.isPresent()) {
				statistics.setAverageValue(avgValue);
			}
		} catch (CustomArrayException e) {
			logger.error(e.getMessage());
		}
	}

	@Override
	public void updateSumValue(CustomArrayEvent event) {
		try {
			CustomArray source = event.getSource();
			Warehouse warehouse = Warehouse.getInstance();
			CustomArrayStatistics statistics  = warehouse.getById(source.getId());
			CustomArrayServiceImpl arrayService = CustomArrayServiceImpl.getInstance();
			int sumValue = arrayService.getSumValue(source);
			statistics.setSumValue(sumValue);
		} catch (CustomArrayException e) {
			logger.error(e.getMessage());
		}
	}

	@Override
	public void replaceStatistic(CustomArrayEvent event) {
		CustomArray source = event.getSource();
		Warehouse warehouse = Warehouse.getInstance();
		warehouse.clearValue(source.getId());
	}

}
