package com.poleschuk.javatask1.service.impl.nonstream;

import com.poleschuk.javatask1.entity.CustomArray;

public class SumValue {
	
	private CustomArray array;
	
	public SumValue(CustomArray array) {
		this.array = array;
	}
	
	public int get() {
		int result = 0;
		for (int i = 0; i < array.length(); i++) {
			result += array.get(i);
		}
		return result;
	}
}
