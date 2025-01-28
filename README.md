# Banking Application Using Spring Boot

## 1. Project Overview
This is a banking application built using Spring Boot, Hibernate, JPA, and MySQL. The main purpose of this application is to provide basic banking operations like creating accounts, depositing money, withdrawing money, getting account details, and deleting accounts, all exposed via REST APIs. The application communicates with a MySQL database to persist and retrieve data. MySQL was chosen due to its robustness and ability to handle relational data efficiently.

## 2. Key Technologies Used

### Spring Boot:
The core framework used for developing the application, providing automatic configuration, and simplifying deployment. Spring Boot allows us to create stand-alone, production-grade applications with minimal setup.

### Hibernate & JPA:
We used Hibernate as the ORM (Object Relational Mapping) tool with JPA to interact with the MySQL database. JPA allows us to map database tables to Java objects, and Hibernate takes care of the complexities of data interaction and transactions.

### MySQL:
MySQL is the relational database used to store account details, including account ID, balance, and account holder information.

### Spring Data JPA:
By integrating Spring Data JPA, we simplify data access and interactions with the database without writing complex queries. Spring Data automatically generates the necessary SQL based on our repository interfaces.

### REST APIs (Spring MVC):
I used RESTful services to expose the banking functionalities. The application communicates using HTTP methods such as GET, POST, and PUT, making it suitable for integration with frontend technologies or other services.

### Exception Handling and Response Wrapping:
I have implemented exception handling with custom error messages that are returned in a consistent format across all API endpoints.

## 3. Core Features of the Application

### Create Account:
Users can create a new bank account by providing their name and an initial balance. The information is persisted in MySQL through the use of Spring Data JPA. Upon successful creation, a 201 Created status is returned.

### Deposit Amount:
Users can deposit money into an account. The amount is added to the existing balance, and a success message is returned. If the amount is invalid (e.g., negative or zero), the API returns a 400 Bad Request with an appropriate error message.

### Withdraw Amount:
Users can withdraw money from their account. If the account has sufficient funds, the requested amount is subtracted from the balance. If not, an error message with a 400 Bad Request status is returned, specifying 'Insufficient balance'.

### Get Account Information:
We offer an API that allows users to fetch their account details by ID, which includes the account holder's name and current balance.

### Delete Account:
Users can delete their accounts. This operation removes the account from the database. If successful, it returns a 204 No Content status.

## 4. Database Design

I used MySQL to manage all account data, and the tables are modeled to store basic account details. Here's a high-level overview of the database design:

### Account Table (Relational Database):
| Column               | Description                       |
|----------------------|-----------------------------------|
| id                   | Unique account ID (Primary Key)   |
| account_holder_name  | Name of the account holder        |
| balance              | Current account balance           |

### JPA Mappings:
The `Account` Java entity is mapped to the database's accounts table. Each field in the Java class has a direct mapping to a column in the MySQL table.

```java
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "account_holder_name")
    private String accountHolderName;

    private Double balance;
}
