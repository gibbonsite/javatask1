package com.poleschuk.javatask1.validator.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.poleschuk.javatask1.validator.CustomArrayValidator;

public class CustomArrayValidatorImpl implements CustomArrayValidator {
	private static final String CORRECT_ARRAY_PATTERN = "^(\\s*-?\\s*\\d+)+$";
	
	public static CustomArrayValidator getInstance() {
        return SingletonHolder.instance;
    } 
	
	private CustomArrayValidatorImpl() {} 
	private static final class SingletonHolder {
		static final CustomArrayValidator instance = new CustomArrayValidatorImpl();
	}
	
	@Override
	public boolean validate(String source) {
		Pattern pattern = Pattern.compile(CORRECT_ARRAY_PATTERN);
		Matcher matcher = pattern.matcher(source);
		return matcher.matches();
	}
}
