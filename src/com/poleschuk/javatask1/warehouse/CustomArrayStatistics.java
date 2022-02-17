package com.poleschuk.javatask1.warehouse;

import java.util.OptionalDouble;
import java.util.OptionalInt;

public class CustomArrayStatistics {
	private OptionalDouble averageValue = OptionalDouble.empty();

	private int sum;
	
	private OptionalInt minValue = OptionalInt.empty();
	
	private OptionalInt maxValue = OptionalInt.empty();

	public OptionalDouble getAverageValue() {
		return averageValue;
	}

	public void setAverageValue(OptionalDouble averageValue) {
		this.averageValue = averageValue;
	}

	public int getSumValue() {
		return sum;
	}

	public void setSumValue(int sum) {
		this.sum = sum;
	}

	public OptionalInt getMinValue() {
		return minValue;
	}

	public void setMinValue(OptionalInt minValue) {
		this.minValue = minValue;
	}

	public OptionalInt getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(OptionalInt maxValue) {
		this.maxValue = maxValue;
	}
	
	
}
