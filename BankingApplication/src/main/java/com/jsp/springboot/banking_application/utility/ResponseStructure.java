package com.jsp.springboot.banking_application.utility;

/**
 * A generic response structure that standardizes API responses.
 * This class helps in maintaining a consistent format for API responses
 * throughout the banking application.
 *
 * @param <T> The type of data that this response will hold.
 */
public class ResponseStructure<T> {

    private int status;      // HTTP Status Code (e.g., 200 for success, 400 for bad request, 404 for not found)
    private String message;  // A message describing the status or result of the request
    private T data;          // The actual response data (can be any object, such as Account details, Transaction info, etc.)

    /**
     * Gets the HTTP status code.
     * @return The HTTP status code.
     */
    public int getStatus() {
        return status;
    }

    /**
     * Sets the HTTP status code.
     * @param status The HTTP status code to be set.
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * Gets the response message.
     * @return The message describing the status or result.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the response message.
     * @param message A message describing the status or result.
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Gets the actual response data.
     * @return The data associated with the response.
     */
    public T getData() {
        return data;
    }

    /**
     * Sets the response data.
     * @param data The data to be included in the response.
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * A static method to create and initialize a ResponseStructure instance.
     * This ensures a consistent way of constructing response objects across the application.
     *
     * @param status The HTTP status code for the response.
     * @param message A message describing the response.
     * @param data The data to be included in the response.
     * @param <T> The type of data the response structure will hold.
     * @return A populated instance of ResponseStructure.
     */
    public static <T> ResponseStructure<T> create(int status, String message, T data) {
        ResponseStructure<T> structure = new ResponseStructure<>();
        structure.setStatus(status);
        structure.setMessage(message);
        structure.setData(data);
        return structure;
    }
}
