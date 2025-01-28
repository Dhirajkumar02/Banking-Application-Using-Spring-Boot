package com.jsp.springboot.banking_application.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.jsp.springboot.banking_application.dto.AccountDto;
import com.jsp.springboot.banking_application.service.AccountService;
import com.jsp.springboot.banking_application.utility.ResponseStructure;


@RestController // Marks the class as a RESTful controller in Spring Boot
@RequestMapping("/accounts") // Maps the API's base URI path
public class AccountController {

	private final AccountService accountService; // Declares AccountService to handle account operations

	// Constructor-based Dependency Injection: injecting the AccountService
	public AccountController(AccountService accountService) {
		this.accountService = accountService;
	}

	// Add Account API - POST request to create a new account
	@PostMapping 
	public ResponseEntity<ResponseStructure<AccountDto>> addAccount(@RequestBody AccountDto accountDto) {
		// Create new account using accountService
		AccountDto createdAccount = accountService.createAccount(accountDto);

		// Returning response with HTTP status 'Created' and a successful message
		return ResponseEntity.status(HttpStatus.CREATED) 
				.body(ResponseStructure.create(HttpStatus.CREATED.value(), "Account created successfully!", createdAccount));
	}

	// Get Account by ID API - GET request to retrieve account by its ID
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<AccountDto>> getAccountById(@PathVariable Long id) {
		// Retrieve account details from the service using the provided ID
		AccountDto accountDto = accountService.getAccountById(id);

		// Return a response with HTTP status 'OK' and the retrieved account
		return ResponseEntity.ok(ResponseStructure.create(HttpStatus.OK.value(), "Account retrieved successfully!", accountDto));
	}

	// Deposit Amount API - PUT request to deposit an amount into an account
	@PutMapping("/{id}/deposit")
	public ResponseEntity<ResponseStructure<AccountDto>> deposit(@PathVariable Long id, @RequestBody Map<String, Double> request) {
		// Extract the deposit amount from the request map
		Double amount = request.get("amount");

		// Validate if the amount is greater than 0, as invalid or 0 deposits are not allowed
		if (amount == null || amount <= 0) {
			// If validation fails, return HTTP 'Bad Request' status and an empty AccountDto to maintain consistent response type
			AccountDto emptyAccountDto = new AccountDto();
			return ResponseEntity.badRequest() 
					.body(ResponseStructure.create(HttpStatus.BAD_REQUEST.value(), "Invalid amount", emptyAccountDto));
		}

		// Perform deposit operation by calling the service layer and passing the account ID and amount to deposit
		AccountDto updatedAccount = accountService.deposit(id, amount);

		// Return a response with HTTP status 'OK' and the updated account information
		return ResponseEntity.ok(ResponseStructure.create(HttpStatus.OK.value(), "Amount deposited successfully!", updatedAccount));
	}

	// Withdraw Amount API - PUT request to withdraw an amount from an account
	@PutMapping("/{id}/withdraw")
	public ResponseEntity<ResponseStructure<AccountDto>> withdraw(@PathVariable Long id, @RequestBody Map<String, Double> request) {
		// Extract the withdrawal amount from the request map
		Double amount = request.get("amount");

		// Validate if the amount is greater than 0, as invalid or 0 withdrawals are not allowed
		if (amount == null || amount <= 0) {
			// If validation fails, return HTTP 'Bad Request' status and an empty AccountDto to maintain consistent response type
			AccountDto emptyAccountDto = new AccountDto(); // Creating empty AccountDto for consistent response type
			return ResponseEntity.badRequest() 
					.body(ResponseStructure.create(HttpStatus.BAD_REQUEST.value(), "Invalid amount", emptyAccountDto));
		}

		// Perform withdraw operation by calling the service layer and passing the account ID and withdrawal amount
		AccountDto updatedAccount = accountService.withdraw(id, amount);

		// Return a response with HTTP status 'OK' and the updated account information after withdrawal
		return ResponseEntity.ok(ResponseStructure.create(HttpStatus.OK.value(), "Amount withdrawn successfully!", updatedAccount));
	}

	// Get All Accounts API - GET request to retrieve all accounts
	@GetMapping
	public ResponseEntity<ResponseStructure<List<AccountDto>>> getAllAccounts() {
		// Retrieve all account details from the service layer
		List<AccountDto> accounts = accountService.getAllAccounts();

		// Return a response with HTTP status 'OK' and all account details
		return ResponseEntity.ok(ResponseStructure.create(HttpStatus.OK.value(), "All accounts retrieved successfully!", accounts));
	}

	// Delete Account by ID API - DELETE request to delete an account using its ID
	@DeleteMapping("/{id}")
	public ResponseStructure<AccountDto> deleteAccountById(@PathVariable Long id) {
		// Retrieve account details from the service using the provided ID
		AccountDto accountDto = accountService.getAccountById(id);

		// Return a response with HTTP status 'OK' and the retrieved account
		return ResponseStructure.create(HttpStatus.OK.value(), "Actor Deleted Successfully!!", accountDto);

	}

}

