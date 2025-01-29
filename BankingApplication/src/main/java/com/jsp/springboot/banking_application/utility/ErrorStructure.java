package com.jsp.springboot.banking_application.utility;

import java.time.LocalDateTime;

/**
 * A standardized structure for API error responses.
 * This class helps maintain a consistent error format across the banking application.
 */
public class ErrorStructure {

    private int statusCode;      // HTTP Status Code (e.g., 400 for bad request, 404 for not found)
    private String message;      // A descriptive message about the error
    private String rootCause;    // The cause of the error (e.g., "Invalid account ID")
    private LocalDateTime timestamp; // The exact time the error occurred

    /**
     * Gets the HTTP status code.
     * @return The HTTP status code associated with this error.
     */
    public int getStatusCode() {
        return statusCode;
    }

    /**
     * Sets the HTTP status code.
     * @param statusCode The HTTP status code to be set.
     */
    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    /**
     * Gets the error message.
     * @return A user-friendly message describing the error.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the error message.
     * @param message The error message to be displayed.
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Gets the root cause of the error.
     * @return A description of what caused the error.
     */
    public String getRootCause() {
        return rootCause;
    }

    /**
     * Sets the root cause of the error.
     * @param rootCause The root cause of the error.
     */
    public void setRootCause(String rootCause) {
        this.rootCause = rootCause;
    }

    /**
     * Gets the timestamp when the error occurred.
     * @return The timestamp of the error occurrence.
     */
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    /**
     * Sets the timestamp when the error occurred.
     * @param timestamp The time when the error was generated.
     */
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * A static method to create an instance of ErrorStructure.
     * This ensures consistency when handling error responses.
     *
     * @param statusCode The HTTP status code for the error.
     * @param message A user-friendly error message.
     * @param rootCause A brief explanation of the cause of the error.
     * @return A populated ErrorStructure object with the current timestamp.
     */
    public static ErrorStructure create(int statusCode, String message, String rootCause) {
        ErrorStructure error = new ErrorStructure();
        error.setStatusCode(statusCode);
        error.setMessage(message);
        error.setRootCause(rootCause);
        error.setTimestamp(LocalDateTime.now()); // Automatically sets the timestamp
        return error;
    }
}
