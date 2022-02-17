package com.poleschuk.javatask1.repository.impl;

import com.poleschuk.javatask1.entity.CustomArray;
import com.poleschuk.javatask1.repository.Specification;

public class IdSpecification implements Specification {

	private int id;
	
	public IdSpecification(int id) {
		this.id = id;
	}
	
	public boolean specify(CustomArray array) {
		return array.getId() == id;
	}
}
