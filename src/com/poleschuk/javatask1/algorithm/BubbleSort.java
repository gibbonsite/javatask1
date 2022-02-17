package com.poleschuk.javatask1.algorithm;

import com.poleschuk.javatask1.entity.CustomArray;

public class BubbleSort {
	public void sort(CustomArray array) {
	    if (array.length() == 0) {
	        return;
	    }
	    
	    int n = array.length();
	    for (int i = 0; i < n; i++) {
		    for (int j = 1; j < n - i; j++) {
		        if (array.get(j - 1) > array.get(j)) {
		            int temp = array.get(j);
		            array.set(j, array.get(j - 1));
		            array.set(j - 1, temp);
		        }
		    }
	    }
	}
}
