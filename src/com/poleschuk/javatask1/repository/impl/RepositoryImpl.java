package com.poleschuk.javatask1.repository.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.poleschuk.javatask1.entity.CustomArray;
import com.poleschuk.javatask1.repository.Repository;
import com.poleschuk.javatask1.repository.Specification;

public class RepositoryImpl implements Repository {
	private static RepositoryImpl instance;
	private int newId = 0;
	private List<CustomArray> arrays = new ArrayList<>();
	
	public static RepositoryImpl getInstance() {
		if (instance == null) {
			instance = new RepositoryImpl();
		}
		return instance;
	}
	
	@Override
	public void add(CustomArray array) {
		array.setId(newId);
		newId++;
		arrays.add(array);
	}
	
	@Override
	public void remove(CustomArray array) {
		remove(array.getId());
	}
	
	@Override
	public void remove(int id) {
		for (CustomArray array : arrays) {
			if (id == array.getId()) {
				arrays.remove(array);		
				return;
			}
		}
	}
	
	@Override
	public List<CustomArray> query(Specification specification) {
		return arrays.stream().filter(o -> specification.specify(o)).collect(Collectors.toList());
	}
	
	@Override
	public void sort(Comparator<CustomArray> comparator) {
		arrays.sort(comparator);
	}
}
