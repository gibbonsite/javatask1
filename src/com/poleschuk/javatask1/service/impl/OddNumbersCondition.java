package com.poleschuk.javatask1.service.impl;

import com.poleschuk.javatask1.entity.CustomArray;
import com.poleschuk.javatask1.service.CustomArrayCondition;

public class OddNumbersCondition extends CustomArrayCondition {

	public OddNumbersCondition(CustomArray array) {
		super(array);
	}
	
	@Override
	public boolean evaluate(int index) {
		return this.array.get(index) % 2 == 1;
	}
}
