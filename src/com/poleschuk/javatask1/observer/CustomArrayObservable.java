package com.poleschuk.javatask1.observer;

public interface CustomArrayObservable {

	void attachObserver(CustomArrayObserver observer);

	void detachObserver(CustomArrayObserver observer);

	void notifyObservers();

}