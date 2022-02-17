package com.poleschuk.javatask1.service;

import com.poleschuk.javatask1.entity.CustomArray;

public abstract class CustomArrayCondition {
	protected CustomArray array;
	
	protected CustomArrayCondition(CustomArray array) {
		this.array = array;
	}
	
	public boolean evaluate(int index) {
		return true;
	}
}
