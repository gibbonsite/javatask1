package com.poleschuk.javatask1.algorithm.stream;

import java.util.stream.IntStream;

import com.poleschuk.javatask1.entity.CustomArray;

public class StreamBubbleSort {
	public void sort(CustomArray array) {
        if (array.length() == 0) {
            return;
        }
        
	    int n = array.length();
	    IntStream outerRange = IntStream.range(0, n - 1);
	    IntStream innerRange = outerRange.flatMap(i -> IntStream.range(1, n - i));
	    innerRange.forEach(j -> {
	        if (array.get(j - 1) > array.get(j)) {
	            int temp = array.get(j);
	            array.set(j, array.get(j - 1));
	            array.set(j - 1, temp);
	        }
	    });
	}
}
