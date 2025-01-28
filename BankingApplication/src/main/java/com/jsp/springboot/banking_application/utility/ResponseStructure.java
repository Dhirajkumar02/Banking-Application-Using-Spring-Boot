package com.jsp.springboot.banking_application.utility;

public class ResponseStructure<T> {

    // Define the fields for status, message, and generic data
    private int status;        // HTTP status code for the response (e.g., 200, 400, 404)
    private String message;    // Message providing context or status of the operation
    private T data;            // Data field, can hold any type (using generics)

    // Getter method to access the status field
    public int getStatus() {
        return status;
    }

    // Getter method to access the message field
    public String getMessage() {
        return message;
    }

    // Getter method to access the data field
    public T getData() {
        return data;
    }

    // Setter method to update the status field
    public void setStatus(int status) {
        this.status = status;
    }

    // Setter method to update the message field
    public void setMessage(String message) {
        this.message = message;
    }

    // Setter method to update the data field
    public void setData(T data) {
        this.data = data;
    }

    // Static method to create and initialize a ResponseStructure instance
    public static <T> ResponseStructure<T> create(int status, String message, T data) {
        // Create a new instance of ResponseStructure
        ResponseStructure<T> structure = new ResponseStructure<>();
        // Set data, message, and status using provided values
        structure.setData(data);
        structure.setMessage(message);
        structure.setStatus(status);
        // Return the constructed instance
        return structure;
    }
}
