package com.jsp.springboot.banking_application.exception;

// Custom exception class for handling cases when an account is not found by its ID.
public class AccountNotFoundByIdException extends RuntimeException {

    private final String message; // Message that provides details about the exception

    // Constructor that accepts a message which describes the cause of the exception
    public AccountNotFoundByIdException(String message) {
        this.message = message;  // Initializes the exception message
    }
    
    // Getter method to retrieve the exception message
    public String getMessage() {
        return message;  // Returns the exception message
    }
}
