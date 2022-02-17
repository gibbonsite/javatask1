package com.poleschuk.javatask1.repository;

import java.util.Comparator;
import java.util.List;

import com.poleschuk.javatask1.entity.CustomArray;

public interface Repository {

	void add(CustomArray array);

	void remove(CustomArray array);

	void remove(int id);

	List<CustomArray> query(Specification specification);

	void sort(Comparator<CustomArray> comparator);

}