package com.poleschuk.javatask1.algorithm.stream;

import java.util.stream.IntStream;

import com.poleschuk.javatask1.algorithm.MergeSort;
import com.poleschuk.javatask1.entity.CustomArray;

public class StreamMergeSort {

	public void sort(CustomArray array) {
		int n = array.length();
	    if (n < 2) {
	        return;
	    }
	    
	    int mid = n / 2;
	    CustomArray l = new CustomArray(mid);
	    CustomArray r = new CustomArray(n - mid);

	    IntStream.range(0, mid)
	    .forEach(i -> {
	        l.set(i, array.get(i));
	    });
	    IntStream.range(mid, n)
	    .forEach(i -> {
	        r.set(i - mid, array.get(i));
	    });
	    sort(l);
	    sort(r);
	    
	    MergeSort.merge(array, l, r, mid, n - mid);
	}    
}