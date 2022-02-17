package com.poleschuk.javatask1.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.poleschuk.javatask1.entity.CustomArray;

public class CustomArrayParser {
		
	public static CustomArray parseArray(String source) {
	    Scanner scanner = new Scanner(source);
	    List<Integer> parsedIntegers = new ArrayList<Integer>();
		try {
			int integerSign = 1;
	        while (scanner.hasNext()) {
	        	String nextToken = scanner.next();
	        	if (nextToken.equals("-")) {
	        		integerSign = -1;
	        	} else {
        		    parsedIntegers.add(integerSign * Integer.parseInt(nextToken));
        		    integerSign = 1;
	        	}
	        }
	        return new CustomArray(parsedIntegers);
		} finally {
			scanner.close();
		}
	}
}
