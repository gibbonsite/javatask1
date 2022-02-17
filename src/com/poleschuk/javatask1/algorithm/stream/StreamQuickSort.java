package com.poleschuk.javatask1.algorithm.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import com.poleschuk.javatask1.entity.CustomArray;
import com.poleschuk.javatask1.service.impl.CustomArrayServiceImpl;

public class StreamQuickSort {
    public void sort(CustomArray array) {
        runQuickSort(array, 0, array.length() - 1);
    }
    
    private void runQuickSort(CustomArray array, int low, int high) {
	    if (array.length() == 0) {
	        return;
	    }
	    
	    if (low >= high) {
	        return;
	    }
	
	    int middle = low + (high - low) / 2;
	    int pivot = array.get(middle);
	
	    List<Integer> reversedList = new ArrayList<Integer>();
	    for (int i = array.length() - 1; i >= 0; i--) {
	        reversedList.add(array.get(i));
	    }

	    int i = low, j = high;
	    CustomArrayServiceImpl arrayService = CustomArrayServiceImpl.getInstance();
	    while (i <= j) {
	    	IntStream stream = arrayService.convertToIntStream(array);
	    	i += stream.takeWhile(number -> number < pivot).count();
	    	Stream<Integer> reversedStream = reversedList.stream();
	    	j -= reversedStream.takeWhile(number -> number > pivot).count();

	        if (i <= j) {
	            int temp = array.get(i);
	            array.set(i, array.get(j));
	            array.set(j, temp);
	            i++;
	            j--;
	        }
	    }
    }
    
}
