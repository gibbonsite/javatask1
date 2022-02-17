package com.poleschuk.javatask1.service;

import com.poleschuk.javatask1.entity.CustomArray;

public abstract class CustomArrayReplacer {
	protected CustomArray array;
	
	public CustomArrayReplacer(CustomArray array) {
		this.array = array;
	}
	
	public void replace(int index) {
	}
}