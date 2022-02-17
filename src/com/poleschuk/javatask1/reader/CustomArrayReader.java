package com.poleschuk.javatask1.reader;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.poleschuk.javatask1.entity.CustomArray;
import com.poleschuk.javatask1.parser.CustomArrayParser;
import com.poleschuk.javatask1.validator.CustomArrayValidator;
import com.poleschuk.javatask1.validator.impl.CustomArrayValidatorImpl;

public class CustomArrayReader {
    static final Logger rootLogger = LogManager.getRootLogger();
    static final Logger validationLogger = LogManager.getLogger(CustomArrayValidatorImpl.class);

	public static List<CustomArray> readArrays(String fileName) throws IOException {
		List<CustomArray> result = new ArrayList<CustomArray>();
        Path path = Paths.get(fileName);
		try (Scanner scanner = new Scanner(path)) {
	        scanner.useDelimiter(System.getProperty("line.separator"));
	        while(scanner.hasNext()) {
	            CustomArrayValidator validation = CustomArrayValidatorImpl.getInstance();
            	String inputString = scanner.next();
            	if (!validation.validate(inputString)) {
	    			validationLogger.error("Input string is not validated:" + inputString);
	    			continue;
            	}
    			validationLogger.info("Input string is successfully validated.");
    			
    	        result.add(CustomArrayParser.parseArray(inputString));
	        }
		}
		return result;
	}
}
