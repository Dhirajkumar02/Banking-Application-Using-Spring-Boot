package com.jsp.springboot.banking_application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication  // This annotation marks the class as the entry point of the Spring Boot application.
public class BankingApplication {

    // The main method serves as the entry point when the Spring Boot application starts.
	public static void main(String[] args) {
        // This line runs the Spring Boot application by invoking the run() method.
		SpringApplication.run(BankingApplication.class, args);
	}

}
