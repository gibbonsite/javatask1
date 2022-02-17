package com.poleschuk.javatask1.algorithm;

import com.poleschuk.javatask1.entity.CustomArray;

public class QuickSort {
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
 
        int i = low, j = high;
        while (i <= j) {
            while (array.get(i) < pivot) {
                i++;
            }
 
            while (array.get(j) > pivot) {
                j--;
            }
 
            if (i <= j) {
                int temp = array.get(i);
                array.set(i, array.get(j));
                array.set(j, temp);
                i++;
                j--;
            }
        }
 
        if (low < j) {
            runQuickSort(array, low, j);
        }
 
        if (high > i) {
        	runQuickSort(array, i, high);
        }
    }
}
