package com.poleschuk.javatask1.service.impl.nonstream;

import java.util.Optional;

import com.poleschuk.javatask1.entity.CustomArray;

public class AverageValue {

	private CustomArray array;
	
	public AverageValue(CustomArray array) {
		this.array = array;
	}
	
	public Optional<Double> get() {
		if (array.length() == 0) {
			return Optional.empty();
		}
		
		double sum = 0;
		for (int i = 0; i < array.length(); i++) {
			sum += array.get(i);
		}
		return Optional.of(sum / array.length());
	}
}
