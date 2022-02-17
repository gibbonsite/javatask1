package com.poleschuk.javatask1.main;

import com.poleschuk.javatask1.entity.CustomArray;
import com.poleschuk.javatask1.observer.impl.CustomArrayObserverImpl;
import com.poleschuk.javatask1.repository.Repository;
import com.poleschuk.javatask1.warehouse.Warehouse;

public class Configurator {
	
	private Warehouse warehouse;
	private Repository repository;
	
	public Configurator(Warehouse warehouse, Repository repository) {
		this.warehouse = warehouse;
		this.repository = repository;
	}
	
	public void addCustomArray(CustomArray array) {
		repository.add(array);
		warehouse.clearValue(array.getId());
		array.attachObserver(new CustomArrayObserverImpl());
		array.notifyObservers();
	}
}
