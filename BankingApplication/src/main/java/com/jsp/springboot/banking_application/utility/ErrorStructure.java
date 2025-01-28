package com.jsp.springboot.banking_application.utility;

public class ErrorStructure {

	// Declare fields for status, message, and root cause of the error
	private int errorStatus;  // HTTP status code representing the error
	private String errorMessage;  // Message to provide more details about the error
	private String rootCause;  // Explanation of the root cause of the error

	// Getter method to access the error status
	public int getStatus() {
		return errorStatus;
	}

	// Getter method to access the error message
	public String getMessage() {
		return errorMessage;
	}

	// Getter method to access the root cause of the error
	public String getRootCause() {
		return rootCause;
	}

	public void setStatus(int errorStatus) {
		this.errorStatus = errorStatus;
	}
	public void setMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public void setRootCause(String rootCause) {
		this.rootCause = rootCause;
	}

	public static  ErrorStructure create(int errorStatus, String errorMessage, String rootCause) {
		ErrorStructure error = new ErrorStructure();
		error.setStatus(errorStatus);
		error.setMessage(errorMessage);
		error.setRootCause(rootCause);

		return error;

	}

}
