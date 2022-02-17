package com.poleschuk.javatask1.algorithm;

import com.poleschuk.javatask1.entity.CustomArray;

public class MergeSort {
	public static void merge(CustomArray array, CustomArray l, CustomArray r, int left, int right) {
	    int i = 0, j = 0, k = 0;
	    while (i < left && j < right) {
	        if (l.get(i) <= r.get(j)) {
	            array.set(k, l.get(i));
	            k++;
	            i++;
	        }
	        else {
	            array.set(k, r.get(j));
	            k++;
	            j++;
	        }
	    }
	    while (i < left) {	            
	    	array.set(k, l.get(i));
	    	k++;
	    	i++;
	    }
	    while (j < right) {
	    	array.set(k, r.get(j));
	    	k++;
	    	j++;
	    }
	}
	
	public void sort(CustomArray array) {
		int n = array.length();
	    if (n < 2) {
	        return;
	    }
	    
	    int mid = n / 2;
	    CustomArray l = new CustomArray(mid);
	    CustomArray r = new CustomArray(n - mid);

	    for (int i = 0; i < mid; i++) {
	        l.set(i, array.get(i));
	    }
	    for (int i = mid; i < n; i++) {
	        r.set(i - mid, array.get(i));
	    }
	    sort(l);
	    sort(r);
	    
	    merge(array, l, r, mid, n - mid);
	}
}
