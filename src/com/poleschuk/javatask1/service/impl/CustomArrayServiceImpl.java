package com.poleschuk.javatask1.service.impl;

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;

import com.poleschuk.javatask1.entity.CustomArray;
import com.poleschuk.javatask1.service.CustomArrayCondition;
import com.poleschuk.javatask1.service.CustomArrayReplacer;
import com.poleschuk.javatask1.service.CustomArrayService;

public class CustomArrayServiceImpl implements CustomArrayService {

	private static CustomArrayServiceImpl instance;
	
	public static CustomArrayServiceImpl getInstance() {
		if (instance == null) {
			instance = new CustomArrayServiceImpl();
		}
		return instance;
	}

	public IntStream convertToIntStream(CustomArray source) {
		int[] numbers = source.getNumbers();
		return Arrays.stream(numbers);
	}

	@Override
	public OptionalInt getMinValue(CustomArray source) {
		IntStream stream = convertToIntStream(source);
		return stream.min();
	}

	@Override
	public OptionalInt getMaxValue(CustomArray source) {
		IntStream stream = convertToIntStream(source);
		return stream.max();
	}
	
	@Override
	public OptionalDouble getAvgValue(CustomArray source) {
		IntStream stream = convertToIntStream(source);
		return stream.average();
	}

	@Override
	public int getSumValue(CustomArray source) {
		IntStream stream = convertToIntStream(source);
		return stream.sum();
	}

	@Override
	public int getPositiveCount(CustomArray source) {
		IntStream stream = convertToIntStream(source);
		IntStream filteredForPositives = stream.filter(number -> number > 0);
		return (int) filteredForPositives.count();
			}

	@Override
	public int getNegativeCount(CustomArray source) {
		IntStream stream = convertToIntStream(source);
		IntStream filteredForPositives = stream.filter(number -> number < 0);
		return (int) filteredForPositives.count();
	}

	@Override
	public void replaceByCondition(CustomArray source, CustomArrayReplacer replacer,
			CustomArrayCondition condition) {

	    IntStream stream = IntStream.range(0, source.length());
	    IntStream intermediateStream = stream.map(i -> {
	    		if (condition.evaluate(i)) { replacer.replace(i); } return 0; });
	    intermediateStream.forEach(v -> {});
	}

}
