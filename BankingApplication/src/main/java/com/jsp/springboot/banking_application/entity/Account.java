package com.jsp.springboot.banking_application.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity  // Marks the class as a JPA entity to be mapped to a database table
@Table(name = "accounts")  // Specifies the table name in the database to which this entity will be mapped
public class Account {

    @Id  // Marks the 'id' field as the primary key of the table
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Specifies the generation strategy for the primary key (identity column for auto-increment in MySQL, etc.)
    private Long id;

    @Column(name = "account_holder_name", nullable = false, length = 100)  // Maps the 'accountHolderName' field to a column in the table
    private String accountHolderName;

    @Column(name = "balance", nullable = false)  // Maps the 'balance' field to a column in the table, ensuring the balance is always non-null
    private Double balance;

    // No-argument constructor, required for JPA
    public Account() {
    }

    // Constructor to initialize Account with specified parameters
    public Account(Long id, String accountHolderName, Double balance) {
        this.id = id;  // Sets account's id
        this.accountHolderName = accountHolderName;  // Sets account holder's name
        this.balance = balance;  // Sets account balance
    }

    // Getter method for account id
    public Long getId() {
        return id;  // Returns the account id
    }

    // Setter method for account id
    public void setId(Long id) {
        this.id = id;  // Sets the account id
    }

    // Getter method for account holder name
    public String getAccountHolderName() {
        return accountHolderName;  // Returns the account holder's name
    }

    // Setter method for account holder name
    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;  // Sets the account holder's name
    }

    // Getter method for account balance
    public Double getBalance() {
        return balance;  // Returns the current account balance
    }

    // Setter method for account balance
    public void setBalance(Double balance) {
        this.balance = balance;  // Sets the new balance
    }

    // Overriding the 'toString' method for displaying account details
    @Override
    public String toString() {
        return "Account [id=" + id + ", accountHolderName=" + accountHolderName + ", balance=" + balance + "]";  
        // Returns a string representation of the Account object
    }
}
