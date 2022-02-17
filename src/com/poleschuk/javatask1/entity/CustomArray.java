package com.poleschuk.javatask1.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import com.poleschuk.javatask1.observer.CustomArrayObservable;

public class CustomArray extends AbstractCustomArray {
	private int id;
	private int array[];
		
	public CustomArray(int capacity) {
		array = new int[capacity];
	}
	
	public CustomArray(List<Integer> integers) {
		this.array = new int[integers.size()];
		for (int i = 0; i < integers.size(); i++) {
			this.array[i] = integers.get(i);
		}
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int length() {
		return array.length;
	}
	
	public int get(int index) {
		return array[index];
	}
	
	public void set(int index, int value) {
		array[index] = value;
	    notifyObservers();
	}
	
	public CustomArray getCopy() {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < array.length; i++) {
			list.add(array[i]);
		}
		return new CustomArray(list);
	}
		
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("id=");
		builder.append(id);
		for (int i = 0; i < array.length; i++) {
			builder.append(" " + array[i]);
		}
		return builder.toString();
	}

	public int[] getNumbers() {
		return array;
	}
}
