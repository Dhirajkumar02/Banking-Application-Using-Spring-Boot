package com.jsp.springboot.banking_application.service;

import java.util.List;

import com.jsp.springboot.banking_application.dto.AccountDto;

public interface AccountService {

	/**
	 * Method to create a new account.
	 * @param account The account information to create.
	 * @return AccountDto The details of the created account.
	 */
	AccountDto createAccount(AccountDto account);

	/**
	 * Method to retrieve account details by account ID.
	 * @param id The ID of the account to fetch.
	 * @return AccountDto The details of the retrieved account.
	 */
	AccountDto getAccountById(Long id);

	/**
	 * Method to deposit a specified amount into an account.
	 * @param id The account ID where the deposit should occur.
	 * @param amount The amount to deposit.
	 * @return AccountDto The updated details of the account.
	 */
	AccountDto deposit(Long id, double amount);

	/**
	 * Method to withdraw a specified amount from an account.
	 * @param id The account ID from which the withdrawal will occur.
	 * @param amount The amount to withdraw.
	 * @return AccountDto The updated details of the account after withdrawal.
	 */
	AccountDto withdraw(Long id, double amount);

	/**
	 * Method to retrieve the details of all accounts.
	 * @return List<AccountDto> A list of AccountDto objects representing all accounts.
	 */
	List<AccountDto> getAllAccounts();

	/**
	 * Method to delete an account by its ID.
	 * @param id The account ID of the account to delete.
	 * @return AccountDto The details of the deleted account.
	 */
	AccountDto deleteAccountById(Long id); 

}
