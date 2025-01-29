package com.jsp.springboot.banking_application.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.jsp.springboot.banking_application.dto.AccountDto;
import com.jsp.springboot.banking_application.entity.Account;
import com.jsp.springboot.banking_application.exception.AccountNotFoundByIdException;
import com.jsp.springboot.banking_application.exception.InsufficientBalanceException;
import com.jsp.springboot.banking_application.exception.InvalidAmountException;
import com.jsp.springboot.banking_application.mapper.AccountMapper;
import com.jsp.springboot.banking_application.repository.AccountRepository;
import com.jsp.springboot.banking_application.service.AccountService;

import jakarta.transaction.Transactional;

@Service // Marks this class as a Spring Service, a business service layer that handles the logic.
public class AccountServiceImpl implements AccountService{

	private final AccountRepository accountRepository; // Injects the AccountRepository to interact with the database

	// Constructor-based Dependency Injection to provide the AccountRepository
	public AccountServiceImpl(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	/**
	 * Method to create a new account.
	 * Converts the DTO to Entity, saves the entity in the database, 
	 * and returns the created account in DTO format.
	 */
	@Override
	public AccountDto createAccount(AccountDto accountDto) {
		// Convert AccountDto to Account entity using AccountMapper
		Account account = AccountMapper.mapToAccount(accountDto);

		// Save the account to the database
		Account savedAccount = accountRepository.save(account);

		// Convert the saved Account entity back to AccountDto for the response
		return AccountMapper.mapToAccountDto(savedAccount);
	}

	/**
	 * Method to get the account details by ID.
	 * Throws exception if account doesn't exist.
	 */
	@Override
	public AccountDto getAccountById(Long id) {
		// Retrieve account by ID, if not found throws an exception
		Account account = accountRepository.findById(id)
				.orElseThrow(() -> new AccountNotFoundByIdException("Account with ID " + id + " does not exist."));

		// Return AccountDto after mapping the account entity
		return AccountMapper.mapToAccountDto(account);
	}

	/**
	 * Method to deposit an amount into an account.
	 * Adds the specified amount to the existing balance and updates the account in the database.
	 */
	@Override
	public AccountDto deposit(Long id, double amount) {
		// Retrieve the account by ID
		Account account = accountRepository.findById(id)
				.orElseThrow(() -> new AccountNotFoundByIdException("Account with ID " + id + " does not exist."));

		// Add the deposit amount to the current balance
		double totalBalance = account.getBalance() + amount;
		account.setBalance(totalBalance);

		// Save the updated account and return the updated AccountDto
		Account savedAccount = accountRepository.save(account);
		return AccountMapper.mapToAccountDto(savedAccount);
	}

	/**
	 * Method to withdraw an amount from an account.
	 * Verifies if sufficient balance exists before withdrawing. If not, throws an exception.
	 */
	@Override
	public AccountDto withdraw(Long id, double amount) {
	    // Retrieve the account by ID
	    Account account = accountRepository.findById(id)
	            .orElseThrow(() -> new AccountNotFoundByIdException("Account does not exist"));

	    // Check if the withdrawal amount is <= 0
	    if (amount <= 0) {
	        throw new InvalidAmountException("Withdrawal amount must be greater than zero");
	    }

	    // Check if the account has a sufficient balance
	    if (account.getBalance() < amount) {
	        throw new InsufficientBalanceException("Insufficient balance in your account");
	    }

	    // Deduct the amount from balance
	    account.setBalance(account.getBalance() - amount);
	    Account savedAccount = accountRepository.save(account);

	    return AccountMapper.mapToAccountDto(savedAccount);
	}



	/**
	 * Method to retrieve a list of all accounts.
	 * Uses streams to map all Account entities to AccountDto objects.
	 */
	@Override
	public List<AccountDto> getAllAccounts() {
		// Retrieve all accounts, convert them from Account entity to AccountDto
		return accountRepository.findAll().stream()
				.map((account) -> AccountMapper.mapToAccountDto(account))  // Stream and map the entities to DTOs
				.collect(Collectors.toList());  // Collect as a list and return it
	}

	/**
	 * Method to delete an account by ID.
	 * The method is transactional, ensuring both deletion and any related actions happen in one transaction.
	 */
	@Override
	@Transactional // Ensures the method runs in a single transaction
	public AccountDto deleteAccountById(Long id) {
		// Retrieve the account to be deleted by ID
		Account account = accountRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Account not found for the given Id: "+id));

		// Delete the account from the repository
		accountRepository.delete(account);

		// Return the deleted account details in DTO format (before deletion, for reference)
		return AccountMapper.mapToAccountDto(account);
	}
}
