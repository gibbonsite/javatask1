package com.poleschuk.javatask1.observer;

public interface CustomArrayObserver {

	void replaceStatistic(CustomArrayEvent event);
	
	void updateMinValue(CustomArrayEvent event);
	
	void updateMaxValue(CustomArrayEvent event);

	void updateSumValue(CustomArrayEvent event);
	
	void updateAvgValue(CustomArrayEvent event);
	
}
