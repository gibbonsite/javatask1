package com.poleschuk.javatask1.entity;

import java.util.ArrayList;
import java.util.List;

import com.poleschuk.javatask1.observer.CustomArrayEvent;
import com.poleschuk.javatask1.observer.CustomArrayObservable;
import com.poleschuk.javatask1.observer.CustomArrayObserver;

public class AbstractCustomArray implements CustomArrayObservable {

	private List<CustomArrayObserver> observers = new ArrayList<>();

	public AbstractCustomArray() {
	}


	@Override
	public void attachObserver(CustomArrayObserver observer) {
		if (observer != null) {
			observers.add(observer);
		}
	}

	@Override
	public void detachObserver(CustomArrayObserver observer) {
		if (observer != null) {
			observers.remove(observer);
		}
	}

	@Override
	public void notifyObservers() {
		CustomArrayEvent event = new CustomArrayEvent(this);
		for (CustomArrayObserver observer : observers) {
			observer.replaceStatistic(event);
			observer.updateMinValue(event);
			observer.updateMaxValue(event);
			observer.updateSumValue(event);
			observer.updateAvgValue(event);
		}
	}

}