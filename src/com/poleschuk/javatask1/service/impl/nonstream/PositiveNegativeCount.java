package com.poleschuk.javatask1.service.impl.nonstream;

import com.poleschuk.javatask1.entity.CustomArray;

public class PositiveNegativeCount {

	private CustomArray array;
	
	public PositiveNegativeCount(CustomArray array) {
		this.array = array;
	}
	
	public void get(int[] result) {
		result[0] = 0;
		result[1] = 0;
		
		for (int i = 0; i < array.length(); i++) {
			if (array.get(i) > 0) {
				result[0]++;
			}

			if (array.get(i) < 0) {
				result[1]++;
			}
		}
	}
	
}
