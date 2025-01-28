package com.jsp.springboot.banking_application.mapper;

import com.jsp.springboot.banking_application.dto.AccountDto;
import com.jsp.springboot.banking_application.entity.Account;

public class AccountMapper {

    // Map AccountDto to Account entity
    // This method converts an AccountDto to an Account entity. 
    // It is typically used when saving or updating an account in the database.
    public static Account mapToAccount(AccountDto accountDto) {
        // Creating an Account object with data from the AccountDto
        Account account = new Account (
                accountDto.getId(),                // Get the ID from AccountDto
                accountDto.getAccountHolderName(),  // Get the Account holder's name from AccountDto
                accountDto.getBalance()            // Get the balance from AccountDto
        );
        return account; // Return the populated Account entity
    }

    // Map Account entity to AccountDto
    // This method converts an Account entity to an AccountDto.
    // It is typically used when we need to send account details to the client, e.g., in API responses.
    public static AccountDto mapToAccountDto(Account account) {
        // Creating an AccountDto object with data from the Account entity
        AccountDto accountDto = new AccountDto(
                account.getId(),                // Get the ID from Account entity
                account.getAccountHolderName(),  // Get the Account holder's name from Account entity
                account.getBalance()            // Get the balance from Account entity
        );
        return accountDto;  // Return the populated AccountDto
    }
}
