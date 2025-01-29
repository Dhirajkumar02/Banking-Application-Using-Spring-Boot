package com.jsp.springboot.banking_application.exception;

public class InvalidAmountException extends RuntimeException {
	
    public InvalidAmountException(String message) {
        super(message);
    }
}
