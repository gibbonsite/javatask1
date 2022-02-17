package com.poleschuk.javatask1.service.impl.nonstream;

import java.util.Optional;

import com.poleschuk.javatask1.entity.CustomArray;

public class MinMaxValue {

	private CustomArray array;
	
	public MinMaxValue(CustomArray array) {
		this.array = array;
	}
	
	public void get(Optional<Integer>[] result) {
		if (array.length() == 0) {
			result[0] = Optional.empty();
			result[1] = Optional.empty();
			return;
		}
		
		result[0] = Optional.of(Integer.MAX_VALUE);
		result[1] = Optional.of(Integer.MIN_VALUE);
		
		for (int i = 0; i < array.length(); i++) {
			if (array.get(i) < result[0].get()) {
				result[0] = Optional.of(array.get(i));
			}

			if (array.get(i) > result[1].get()) {
				result[1] = Optional.of(array.get(i));
			}
		}
	}
	
}
