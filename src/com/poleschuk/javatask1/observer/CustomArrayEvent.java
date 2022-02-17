package com.poleschuk.javatask1.observer;

import java.util.EventObject;

import com.poleschuk.javatask1.entity.AbstractCustomArray;
import com.poleschuk.javatask1.entity.CustomArray;

public class CustomArrayEvent extends EventObject {
	
	public CustomArrayEvent(AbstractCustomArray source) {
		super(source);
	}
	
	@Override
	public CustomArray getSource() {
		return (CustomArray) super.getSource();
	}
	
}
