package com.jsp.springboot.banking_application.dto;

public class AccountDto {
    // Class fields representing the Account's data to be transferred
	private Long id;  // Account's unique identifier
	private String accountHolderName;  // Name of the account holder
	private double balance;  // Account balance

    // No-argument constructor (used for serialization, deserialization, etc.)
	public AccountDto() {
	}
	
    // Constructor that initializes the AccountDto with the given values
	public AccountDto(Long id, String accountHolderName, double balance) {
		this.id = id;  // Sets the account ID
		this.accountHolderName = accountHolderName;  // Sets the account holder's name
		this.balance = balance;  // Sets the account's balance
	}

    // Getter method for the account ID
	public Long getId() {
		return id;  // Returns the account ID
	}

    // Setter method for the account ID
	public void setId(Long id) {
		this.id = id;  // Sets the account ID
	}

    // Getter method for the account holder's name
	public String getAccountHolderName() {
		return accountHolderName;  // Returns the account holder's name
	}

    // Setter method for the account holder's name
	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;  // Sets the account holder's name
	}

    // Getter method for the account's balance
	public double getBalance() {
		return balance;  // Returns the current balance of the account
	}

    // Setter method for the account's balance
	public void setBalance(double balance) {
		this.balance = balance;  // Sets the new balance for the account
	}
}
