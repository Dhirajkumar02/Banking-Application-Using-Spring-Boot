package com.jsp.springboot.banking_application.utility;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.jsp.springboot.banking_application.exception.AccountNotFoundByIdException;
import com.jsp.springboot.banking_application.exception.AccountsNotFoundException;
import com.jsp.springboot.banking_application.exception.InsufficientBalanceException;
import com.jsp.springboot.banking_application.exception.InvalidAmountException;

/**
 * Global exception handler for the banking application.
 * 
 * This class provides a centralized way to handle exceptions across all controllers,
 * ensuring consistent error responses.
 */
@RestControllerAdvice // Enables global exception handling for all REST controllers
public class ApplicationExceptionHandler {

    /**
     * Handles AccountNotFoundByIdException.
     * This exception occurs when a specific account ID does not exist in the database.
     *
     * @param ex The exception instance thrown.
     * @return ResponseEntity containing an error structure with HTTP 404 status.
     */
    @ExceptionHandler(AccountNotFoundByIdException.class)
    public ResponseEntity<ErrorStructure> handleAccountNotFoundById(AccountNotFoundByIdException ex) {
        ErrorStructure errorResponse = ErrorStructure.create(
                HttpStatus.NOT_FOUND.value(),  // HTTP status code (404)
                ex.getMessage(),               // Custom error message from exception
                "Account with the requested ID is not available in the Database!" 
        );

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    /**
     * Handles AccountsNotFoundException.
     * This exception occurs when no accounts exist in the system.
     *
     * @param ex The exception instance thrown.
     * @return ResponseEntity containing an error structure with HTTP 404 status.
     */
    @ExceptionHandler(AccountsNotFoundException.class)
    public ResponseEntity<ErrorStructure> handleAccountsNotFound(AccountsNotFoundException ex) {
        ErrorStructure errorResponse = ErrorStructure.create(
                HttpStatus.NOT_FOUND.value(), // HTTP status code (404)
                ex.getMessage(),              // Custom error message
                "No accounts are present in the database!" 
        );

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    /**
     * Handles InsufficientBalanceException.
     * This exception is thrown when a withdrawal is attempted with insufficient balance.
     *
     * @param ex The exception instance thrown.
     * @return ResponseEntity containing a response structure with HTTP 400 status.
     */
    @ExceptionHandler(InsufficientBalanceException.class)
    public ResponseEntity<ResponseStructure<String>> handleInsufficientBalanceException(InsufficientBalanceException ex) {
        ResponseStructure<String> errorResponse = ResponseStructure.create(
                HttpStatus.BAD_REQUEST.value(), // HTTP status code (400)
                ex.getMessage(),  // "Insufficient balance in your account"
                null // Data should be null as it's an error response
        );

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    /**
     * Handles InvalidAmountException.
     * This exception occurs when a user enters an invalid deposit/withdrawal amount.
     *
     * @param ex The exception instance thrown.
     * @return ResponseEntity containing a response structure with HTTP 400 status.
     */
    @ExceptionHandler(InvalidAmountException.class)
    public ResponseEntity<ResponseStructure<String>> handleInvalidAmountException(InvalidAmountException ex) {
        ResponseStructure<String> errorResponse = ResponseStructure.create(
                HttpStatus.BAD_REQUEST.value(), // HTTP status code (400)
                ex.getMessage(),  // Use the exception's custom error message
                null
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    /**
     * Handles any other generic exceptions that are not specifically caught.
     * This prevents the application from exposing internal errors.
     *
     * @param ex The exception instance thrown.
     * @return ResponseEntity containing a response structure with HTTP 500 status.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseStructure<String>> handleGeneralException(Exception ex) {
        ResponseStructure<String> errorResponse = ResponseStructure.create(
                HttpStatus.INTERNAL_SERVER_ERROR.value(), // HTTP status code (500)
                "An unexpected error occurred. Please try again.", // Generic error message
                null
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
