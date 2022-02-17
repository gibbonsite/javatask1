package com.poleschuk.javatask1.main;


import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.poleschuk.javatask1.entity.CustomArray;
import com.poleschuk.javatask1.main.Configurator;
import com.poleschuk.javatask1.repository.Repository;
import com.poleschuk.javatask1.repository.impl.IdSpecification;
import com.poleschuk.javatask1.repository.impl.RepositoryImpl;
import com.poleschuk.javatask1.service.impl.CustomArrayServiceImpl;
import com.poleschuk.javatask1.warehouse.Warehouse;

public class RepositoryTest {

	private static final List<CustomArray> TEST_ARRAYS = List.of(
			new CustomArray(List.of(21, 35, 18, 91, -4, 49, -2)),
			new CustomArray(List.of(-11, 18, 32, -90, 16)),
			new CustomArray(List.of(-20, 4, 19, -60, 8, 17)),
			new CustomArray(List.of(0, 1, -9, 30, 99, 1, -7)));

	private static final double AVERAGE_VALUE_CHANGED = 17.857142857142858;
	private static final int MIN_VALUE_CHANGED = -11;
	
    @Test
    public void testRepositorySpecification() {
		Repository repository = RepositoryImpl.getInstance();
		for (CustomArray array : TEST_ARRAYS) {
			repository.add(array);
		}
		IdSpecification idSpecification = new IdSpecification(1);
		List<CustomArray> queriedArrays = repository.query(idSpecification);
		Assert.assertEquals(queriedArrays.size(), 1);
		CustomArray firstArray = queriedArrays.get(0);
		Assert.assertEquals(firstArray.getId(), 1);
    }

    @Test
    public void testObserverAverage() {
    	List<CustomArray> arrays = new ArrayList<>();
    	for (CustomArray array : TEST_ARRAYS) {
    		arrays.add(array.getCopy());
    	}
    	
		Repository repository = RepositoryImpl.getInstance();
		Warehouse warehouse = Warehouse.getInstance();
		Configurator configurator = new Configurator(warehouse, repository);
		for (CustomArray array : arrays) {
			configurator.addCustomArray(array);
		}
		CustomArray fourthArray = arrays.get(3);
		fourthArray.set(2, fourthArray.get(2) + 10);
		CustomArrayServiceImpl arrayService = CustomArrayServiceImpl.getInstance();
		OptionalDouble averageValue = arrayService.getAvgValue(fourthArray);
		Assert.assertEquals(averageValue.getAsDouble(), AVERAGE_VALUE_CHANGED, 0.0001);
    }
    
    @Test
    public void testObserverMinimum() {
    	List<CustomArray> arrays = new ArrayList<>();
    	for (CustomArray array : TEST_ARRAYS) {
    		arrays.add(array.getCopy());
    	}
    	
    	
		Repository repository = RepositoryImpl.getInstance();
		Warehouse warehouse = Warehouse.getInstance();
		Configurator configurator = new Configurator(warehouse, repository);
		for (CustomArray array : arrays) {
			configurator.addCustomArray(array);
		}
		CustomArray fourthArray = arrays.get(1);
		fourthArray.set(3, fourthArray.get(3) + 90);
		CustomArrayServiceImpl arrayService = CustomArrayServiceImpl.getInstance();

		OptionalInt minValue = arrayService.getMinValue(fourthArray);
		Assert.assertEquals(minValue.getAsInt(), MIN_VALUE_CHANGED);
    }

    @Test
    public void testRepositoryRemove() {
		Repository repository = RepositoryImpl.getInstance();
		for (CustomArray array : TEST_ARRAYS) {
			repository.add(array);
		}
		
		repository.remove(0);
		IdSpecification idSpecification = new IdSpecification(0);
		List<CustomArray> queriedArrays = repository.query(idSpecification);
		Assert.assertEquals(queriedArrays.size(), 0);
    }

}
