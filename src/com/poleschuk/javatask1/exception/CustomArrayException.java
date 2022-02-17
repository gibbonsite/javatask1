package com.poleschuk.javatask1.exception;

public class CustomArrayException extends Exception {
	public CustomArrayException() {
	}
	
	public CustomArrayException(String message) {
		super(message);
	}

	public CustomArrayException(Throwable throwable) {
		super(throwable);
	}

	public CustomArrayException(String message, Throwable throwable) {
		super(message, throwable);
	}
}
