package com.jsp.springboot.banking_application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jsp.springboot.banking_application.entity.Account;

// Marking this interface as a repository for Spring Data JPA
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    // Inherits methods for common CRUD operations from JpaRepository
    // No need to implement basic methods such as save(), findById(), delete() as they're 
    // automatically provided by JpaRepository for the entity class Account and ID type Long.
}
