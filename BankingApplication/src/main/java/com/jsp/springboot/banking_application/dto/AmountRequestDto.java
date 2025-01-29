package com.jsp.springboot.banking_application.dto;

public class AmountRequestDto {
    private Double amount; // Representing the deposit/withdrawal amount

    // Getter Method
    public Double getAmount() { 
        return amount; 
    }

    // Setter Method
    public void setAmount(Double amount) { 
        this.amount = amount; 
    }
}
