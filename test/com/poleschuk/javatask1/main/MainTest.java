package com.poleschuk.javatask1.main;



import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.poleschuk.javatask1.algorithm.BubbleSort;
import com.poleschuk.javatask1.algorithm.MergeSort;
import com.poleschuk.javatask1.algorithm.QuickSort;
import com.poleschuk.javatask1.algorithm.stream.StreamBubbleSort;
import com.poleschuk.javatask1.algorithm.stream.StreamMergeSort;
import com.poleschuk.javatask1.entity.CustomArray;
import com.poleschuk.javatask1.service.impl.CustomArrayServiceImpl;
import com.poleschuk.javatask1.service.impl.MinusOneReplacer;
import com.poleschuk.javatask1.service.impl.OddNumbersCondition;
import com.poleschuk.javatask1.service.impl.nonstream.AverageValue;
import com.poleschuk.javatask1.service.impl.nonstream.MinMaxValue;
import com.poleschuk.javatask1.service.impl.nonstream.PositiveNegativeCount;
import com.poleschuk.javatask1.service.impl.nonstream.ReplaceValuesByCondition;
import com.poleschuk.javatask1.service.impl.nonstream.SumValue;

public class MainTest {

	private static final CustomArray TEST_ARRAY = 
			new CustomArray(List.of(21, 35, 18, 91, -4, 49, -2));
	private static final CustomArray SORTED_ARRAY = 
			new CustomArray(List.of(-4, -2, 18, 21, 35, 49, 91));
	private static final CustomArray REPLACED_ARRAY = 
			new CustomArray(List.of(-1, -1, 18, -1, -4, -1, -2));
	private static final double AVERAGE_VALUE = 29.714285714285715;
	private static final int SUM_VALUE = 208;
	private static final int MINIMUM_VALUE = -4;
	private static final int MAXIMUM_VALUE = 91;
	private static final int POSITIVE_COUNT = 5;
	private static final int NEGATIVE_COUNT = 2;
	
	private CustomArray testArray;
		
    @Test
    public void testAverageValue() {
    	testArray = TEST_ARRAY.getCopy();
    	AverageValue averaging = new AverageValue(testArray);
    	Optional<Double> averageValue = averaging.get();
    	Assert.assertEquals(averageValue.get(), AVERAGE_VALUE, 0.0001);
    }

    @Test
    public void testSumValue() {
    	testArray = TEST_ARRAY.getCopy();
    	SumValue sumCalculator = new SumValue(testArray);
    	Assert.assertEquals(sumCalculator.get(), SUM_VALUE);
    }
    
    @Test
    public void testCalculateMinMax() {
    	testArray = TEST_ARRAY.getCopy();
		MinMaxValue calculateMinMax = new MinMaxValue(testArray);
    	Optional<Integer>[] calculateMinMaxResult = new Optional[2];
		calculateMinMax.get(calculateMinMaxResult);
		Optional<Integer> minValue = calculateMinMaxResult[0];
		Optional<Integer> maxValue = calculateMinMaxResult[1];
		Integer minimumValue = minValue.get();
		Integer maximumValue = maxValue.get();
		Assert.assertEquals(minimumValue.intValue(), MINIMUM_VALUE);
		Assert.assertEquals(maximumValue.intValue(), MAXIMUM_VALUE);
    }

    @Test
    public void testPositiveNegative() {
    	testArray = TEST_ARRAY.getCopy();
    	PositiveNegativeCount positiveNegativeCalculator =
    			new PositiveNegativeCount(testArray);
    	int[] positiveNegativeResult = new int[2];
    	positiveNegativeCalculator.get(positiveNegativeResult);
    	Assert.assertEquals(positiveNegativeResult[0], POSITIVE_COUNT);
    	Assert.assertEquals(positiveNegativeResult[1], NEGATIVE_COUNT);
    }

    @Test
    public void testStreamAverageValue() {
    	testArray = TEST_ARRAY.getCopy();
    	CustomArrayServiceImpl arrayService = CustomArrayServiceImpl.getInstance();
    	OptionalDouble result = arrayService.getAvgValue(testArray);
    	Assert.assertEquals(result.getAsDouble(), AVERAGE_VALUE, 0.0001);
    }

    @Test
    public void testStreamSumValue() {
    	testArray = TEST_ARRAY.getCopy();
    	CustomArrayServiceImpl arrayService = CustomArrayServiceImpl.getInstance();
    	int result = arrayService.getSumValue(testArray);
    	Assert.assertEquals(result, SUM_VALUE);
    }

    @Test
    public void testStreamCalculateMinMax() {
    	testArray = TEST_ARRAY.getCopy();
    	CustomArrayServiceImpl arrayService = CustomArrayServiceImpl.getInstance();
    	OptionalInt minValue = arrayService.getMinValue(testArray);
    	OptionalInt maxValue = arrayService.getMaxValue(testArray);
		Assert.assertEquals(minValue.getAsInt(), MINIMUM_VALUE);
		Assert.assertEquals(maxValue.getAsInt(), MAXIMUM_VALUE);
    }

    @Test
    public void testStreamPositiveNegative() {
    	testArray = TEST_ARRAY.getCopy();
    	CustomArrayServiceImpl arrayService = CustomArrayServiceImpl.getInstance();
    	int positiveCount = arrayService.getPositiveCount(testArray);
    	int negativeCount = arrayService.getNegativeCount(testArray);
    	Assert.assertEquals(positiveCount, POSITIVE_COUNT);
    	Assert.assertEquals(negativeCount, NEGATIVE_COUNT);
    }
    	
    @Test
    public void testBubbleSort() {
    	testArray = TEST_ARRAY.getCopy();
	    BubbleSort bubbleSort = new BubbleSort();
	    bubbleSort.sort(testArray);
	    for (int i = 0; i < testArray.length(); i++) 
	    {
	    	Assert.assertEquals(testArray.get(i), SORTED_ARRAY.get(i));
	    }
    }

    @Test
    public void testStreamBubbleSort() {
    	testArray = TEST_ARRAY.getCopy();
	    StreamBubbleSort bubbleSort = new StreamBubbleSort();
	    bubbleSort.sort(testArray);
	    for (int i = 0; i < testArray.length(); i++) 
	    {
	    	Assert.assertEquals(testArray.get(i), SORTED_ARRAY.get(i));
	    }
    }

    @Test
    public void testMergeSort() {
    	testArray = TEST_ARRAY.getCopy();
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(testArray);
	    for (int i = 0; i < testArray.length(); i++) 
	    {
	    	Assert.assertEquals(testArray.get(i), SORTED_ARRAY.get(i));
	    }
    }

    @Test
    public void testStreamMergeSort() {
    	testArray = TEST_ARRAY.getCopy();
        StreamMergeSort mergeSort = new StreamMergeSort();
        mergeSort.sort(testArray);
	    for (int i = 0; i < testArray.length(); i++) 
	    {
	    	Assert.assertEquals(testArray.get(i), SORTED_ARRAY.get(i));
	    }
    }

    @Test
    public void testQuickSort() {
    	testArray = TEST_ARRAY.getCopy();
        QuickSort quickSort = new QuickSort();
        quickSort.sort(testArray);
	    for (int i = 0; i < testArray.length(); i++) 
	    {
	    	Assert.assertEquals(testArray.get(i), SORTED_ARRAY.get(i));
	    }
    }

    @Test
    public void testReplacement() {
    	testArray = TEST_ARRAY.getCopy();
		OddNumbersCondition condition = new OddNumbersCondition(testArray);
		MinusOneReplacer replacer =	new MinusOneReplacer(testArray);
		ReplaceValuesByCondition replaceValuesByCondition = 
				new ReplaceValuesByCondition(testArray,	replacer, condition);
		replaceValuesByCondition.perform();
   	    for (int i = 0; i < testArray.length(); i++) 
   	    {
   	    	Assert.assertEquals(testArray.get(i), REPLACED_ARRAY.get(i));
   	    }
    }

 
    @Test
    public void testStreamReplacement() {
    	testArray = TEST_ARRAY.getCopy();
		OddNumbersCondition condition = new OddNumbersCondition(testArray);
		MinusOneReplacer replacer =	new MinusOneReplacer(testArray);
    	CustomArrayServiceImpl arrayService = CustomArrayServiceImpl.getInstance();
		arrayService.replaceByCondition(testArray, replacer, condition);
   	    for (int i = 0; i < testArray.length(); i++) 
   	    {
   	    	Assert.assertEquals(testArray.get(i), REPLACED_ARRAY.get(i));
   	    }
    }
}
