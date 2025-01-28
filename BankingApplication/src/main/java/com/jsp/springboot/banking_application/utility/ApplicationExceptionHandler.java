package com.jsp.springboot.banking_application.utility;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jsp.springboot.banking_application.exception.AccountNotFoundByIdException;
import com.jsp.springboot.banking_application.exception.AccountsNotFoundException;

@RestControllerAdvice // This annotation ensures that the class handles exceptions globally across all controllers.
public class ApplicationExceptionHandler {

    /**
     * Handles the exception thrown when an account is not found by the given ID.
     * 
     * @param ex The exception that was thrown.
     * @return ErrorStructure The response to send back to the client.
     */
    @ExceptionHandler // This annotation indicates the method will handle a specific type of exception.
    public ErrorStructure handleAccountNotFoundById(AccountNotFoundByIdException ex) {
        // This method creates and returns a structured error response for AccountNotFoundByIdException.
        return ErrorStructure.create(
            HttpStatus.NOT_FOUND.value(), // HTTP Status code for 'Not Found'
            ex.getMessage(), // Error message from exception
            "Account with the requested Id is not available in the Database!!" // Custom error message
        );
    }

    /**
     * Handles the exception thrown when accounts are not found in the system.
     * 
     * @param ex The exception that was thrown.
     * @return ErrorStructure The response to send back to the client.
     */
    @ExceptionHandler // This annotation indicates the method will handle a specific type of exception.
    public ErrorStructure handleAccountNotFound(AccountsNotFoundException ex) {
        // This method creates and returns a structured error response for AccountsNotFoundException.
        return ErrorStructure.create(
            HttpStatus.NOT_FOUND.value(), // HTTP Status code for 'Not Found'
            ex.getMessage(), // Error message from exception
            "Accounts is not Present in the Database!!" // Custom error message
        );
    }
}
