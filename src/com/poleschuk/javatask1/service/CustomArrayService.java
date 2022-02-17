package com.poleschuk.javatask1.service;

import java.util.OptionalDouble;
import java.util.OptionalInt;

import com.poleschuk.javatask1.entity.CustomArray;

public interface CustomArrayService {

	OptionalInt getMinValue(CustomArray source);

	OptionalInt getMaxValue(CustomArray source);

	OptionalDouble getAvgValue(CustomArray source);

	int getSumValue(CustomArray source);

	public int getPositiveCount(CustomArray source);

	public int getNegativeCount(CustomArray source);

	public void replaceByCondition(CustomArray source, CustomArrayReplacer replacer, 
			CustomArrayCondition condition);
}