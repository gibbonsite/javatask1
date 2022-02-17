package com.poleschuk.javatask1.service.impl;

import com.poleschuk.javatask1.entity.CustomArray;
import com.poleschuk.javatask1.service.CustomArrayReplacer;

public class MinusOneReplacer extends CustomArrayReplacer {
	
	public MinusOneReplacer(CustomArray array) {
		super(array);
	}
	
	@Override
	public void replace(int index) {
		array.set(index, -1);
	}
}
