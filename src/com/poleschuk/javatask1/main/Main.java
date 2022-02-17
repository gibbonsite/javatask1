package com.poleschuk.javatask1.main;

import java.io.IOException;

import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;

import com.poleschuk.javatask1.algorithm.BubbleSort;
import com.poleschuk.javatask1.algorithm.MergeSort;
import com.poleschuk.javatask1.algorithm.QuickSort;
import com.poleschuk.javatask1.algorithm.stream.StreamBubbleSort;
import com.poleschuk.javatask1.algorithm.stream.StreamMergeSort;
import com.poleschuk.javatask1.algorithm.stream.StreamQuickSort;
import com.poleschuk.javatask1.entity.CustomArray;
import com.poleschuk.javatask1.reader.CustomArrayReader;
import com.poleschuk.javatask1.repository.Repository;
import com.poleschuk.javatask1.repository.impl.IdSpecification;
import com.poleschuk.javatask1.repository.impl.RepositoryImpl;
import com.poleschuk.javatask1.service.impl.CustomArrayServiceImpl;
import com.poleschuk.javatask1.service.impl.MinusOneReplacer;
import com.poleschuk.javatask1.service.impl.OddNumbersCondition;
import com.poleschuk.javatask1.service.impl.nonstream.AverageValue;
import com.poleschuk.javatask1.service.impl.nonstream.MinMaxValue;
import com.poleschuk.javatask1.service.impl.nonstream.PositiveNegativeCount;
import com.poleschuk.javatask1.service.impl.nonstream.ReplaceValuesByCondition;
import com.poleschuk.javatask1.service.impl.nonstream.SumValue;
import com.poleschuk.javatask1.warehouse.Warehouse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Main {

    public static final String fileName = "./data/source.txt";
    
    static final Logger logger = LogManager.getLogger();
    
	public static void main(String args[]) throws IOException {
		taskPart1();
		taskPart2();
		taskPart3();
		taskRepository();
	}

	public static void taskPart1() {
		try {
			List<CustomArray> result = CustomArrayReader.readArrays(fileName);
			for (CustomArray simpleArray : result) {
		        if (simpleArray.length() == 0) {
	    			logger.info("Input array is empty.");
	    		}
	
		        
	    		SumValue performSummation = new SumValue(simpleArray);
	    		logger.info("Sum value is " + performSummation.get());
	
	    		AverageValue performAveraging = new AverageValue(simpleArray);
	        	Optional<Double> averageValue = performAveraging.get();
	        	if (averageValue.isPresent()) {
	        		logger.info("Average value is " + averageValue.get());
	        	} else {
	        		logger.info("Average value for empty array is undefined.");
	        	}
	
	        	MinMaxValue calculateMinMax = new MinMaxValue(simpleArray);
	        	Optional<Integer>[] calculateMinMaxResult = new Optional[2];
        		calculateMinMax.get(calculateMinMaxResult);
	        	if (calculateMinMaxResult[0].isPresent()) {
	        		logger.info(String.format("Min/max values are %d, %d.", 
	        				calculateMinMaxResult[0].get(),	calculateMinMaxResult[1].get()));
	        	} else {
	        		logger.info("Min/max values for empty array are undefined.");
	        	}
	
	        	PositiveNegativeCount positiveNegativeCount = 
	        			new PositiveNegativeCount(simpleArray);
	        	int positiveNegativeResult[] = new int[2];
	        	positiveNegativeCount.get(positiveNegativeResult);
	    		logger.info(String.format("There are %d, %d positive/negative values in the array.",
	    				positiveNegativeResult[0], positiveNegativeResult[1]));
	
	        	OddNumbersCondition condition = new OddNumbersCondition(simpleArray);
	        	MinusOneReplacer replacer =	new MinusOneReplacer(simpleArray);
	        	ReplaceValuesByCondition replaceValuesByCondition = 
	        			new ReplaceValuesByCondition(simpleArray, replacer, condition);
	        	replaceValuesByCondition.perform();
	    		logger.info("Replaced array is " + simpleArray);
			}
			
		} catch (IOException exception) {
    		logger.error("Input file is not found: " + fileName);
		}
	}

	public static void taskPart2() {	
		try {
			List<CustomArray> result = CustomArrayReader.readArrays(fileName);
			for (CustomArray simpleArray : result) {
		        if (simpleArray.length() == 0) {
	    			logger.info("Input array is empty.");
	    		}
    	        
    	        CustomArray bubbleSortArray = simpleArray.getCopy();
    	        BubbleSort bubbleSort = new BubbleSort();
    	        bubbleSort.sort(bubbleSortArray);
    	        
    	        CustomArray mergeSortArray = simpleArray.getCopy();
    	        MergeSort mergeSort = new MergeSort();
    	        mergeSort.sort(mergeSortArray);

    	        CustomArray quickSortArray = simpleArray.getCopy();
    	        QuickSort quickSort = new QuickSort();
    	        quickSort.sort(quickSortArray);
	        }
		} catch (IOException exception) {
    		logger.error("Input file is not found: " + fileName);
		}
	}
		
	public static void taskPart3() {	
		try {
			List<CustomArray> result = CustomArrayReader.readArrays(fileName);
			for (CustomArray simpleArray : result) {
		        if (simpleArray.length() == 0) {
	    			logger.info("Input array is empty.");
	    		}

		        CustomArrayServiceImpl arrayService = CustomArrayServiceImpl.getInstance();

		        int sumValue = arrayService.getSumValue(simpleArray);
        		logger.info("Sum value is " + sumValue);

		        OptionalDouble averageValue = arrayService.getAvgValue(simpleArray);
	        	if (averageValue.isPresent()) {
	        		logger.info("Average value is " + averageValue.getAsDouble());
	        	} else {
	        		logger.info("Average value for empty array is undefined.");
	        	}

	        	OptionalInt minValue = arrayService.getMinValue(simpleArray);
	        	OptionalInt maxValue = arrayService.getMaxValue(simpleArray);
	        	if (minValue.isPresent() && maxValue.isPresent()) {
	        		logger.info(String.format("Min/max values are %d, %d.", 
	        				minValue.getAsInt(), maxValue.getAsInt()));
	        	} else {
	        		logger.info("Min/max values for empty array are undefined.");
	        	}

	        	int positiveCount = arrayService.getPositiveCount(simpleArray);
	        	int negativeCount = arrayService.getPositiveCount(simpleArray);
        		logger.info(String.format("There are %d, %d positive/negative values in the array.",
        				positiveCount, negativeCount));

	        	CustomArray copiedArray = simpleArray.getCopy();
	        	OddNumbersCondition condition = new OddNumbersCondition(simpleArray);
	        	MinusOneReplacer replacer = new MinusOneReplacer(simpleArray);
	        	arrayService.replaceByCondition(copiedArray, replacer, condition);
        		logger.info("Replaced array is " + copiedArray);
        		
    	        CustomArray bubbleSortArray = simpleArray.getCopy();
    	        StreamBubbleSort bubbleSort = new StreamBubbleSort();
    	        bubbleSort.sort(bubbleSortArray);

    	        CustomArray mergeSortArray = simpleArray.getCopy();
    	        StreamMergeSort mergeSort = new StreamMergeSort();
    	        mergeSort.sort(mergeSortArray);

    	        CustomArray quickSortArray = simpleArray.getCopy();
    	        StreamQuickSort quickSort = new StreamQuickSort();
    	        quickSort.sort(quickSortArray);	    	        
	        }
		} catch (IOException exception) {
    		logger.error("Input file is not found: " + fileName);
		}
	}

	public static void taskRepository() {
		try {
			List<CustomArray> arrays = CustomArrayReader.readArrays(fileName);
						
			Warehouse warehouse = Warehouse.getInstance();
			Repository repository = RepositoryImpl.getInstance();
			Configurator configurator = new Configurator(warehouse, repository);
			for (CustomArray array : arrays) {
		        if (array.length() == 0) {
	    			logger.info("Input array is empty.");
	    		}
		        configurator.addCustomArray(array);
			}
			repository.sort((o1, o2) -> o1.getId() - o2.getId());
			
			IdSpecification idSpecification = new IdSpecification(2);
			List<CustomArray> queriedArrays = repository.query(idSpecification);
			logger.info(String.format("Query by specification returned %s arrays.", queriedArrays.size()));
			
			CustomArray firstArray = arrays.get(0);
			firstArray.set(1, firstArray.get(1) + 10);
			
			CustomArray fourthArray = arrays.get(3);
			fourthArray.set(2, fourthArray.get(2) - 17);

			CustomArray thirdArray = arrays.get(2);
			thirdArray.set(0, thirdArray.get(0) + 29);

		} catch (IOException exception) {
    		logger.error("Input file is not found: " + fileName);
		}
	}

}
