# Banking Manager (Java)

## Description
A **console-based Banking system** implemented in Java that simulates basic banking operations such as creating accounts, depositing and withdrawing funds, applying interest, and displaying account details.
Through this project, I learned **object-oriented programming**, **inheritance**, and **polymorphism** through different account types (Savings and Checking), along with input validation and user interaction.

## Features
- Create **Savings** and **Checking** accounts
- Auto-generated account numbers (ex. `AC1`, `AC2`)
- Deposit funds with input validation
- Withdraw funds with:
  - Balance checks for Savings accounts
  - Overdraft limit handling for Checking accounts
- Apply interest to all Savings accounts
- Display all existing accounts and balances
- Handling of invalid user input

## Technologies & Concepts
- **Language:** Java  
- **Core Concepts:**
  - Object-Oriented Programming (OOP)
  - Inheritance and method overriding
  - Polymorphism using abstract classes
  - Arrays for account storage
  - Exception handling (`InputMismatchException`)
  - Console-based user interaction with `Scanner`

## Architecture
The system follows an object-oriented design:
- **Bank**
  - Entry point of the application
  - Manages user input and menu navigation
  - Stores and manages all bank accounts
- **BankAccount (abstract)**
  - Defines shared properties and behaviors
  - Implements common deposit and withdrawal logic
- **SavingsAccount**
  - Extends `BankAccount`
  - Applies a fixed interest rate to balances
- **CheckingAccount**
  - Extends `BankAccount`
  - Supports withdrawals with an overdraft limit

## Project Structure
```
BankingSystem/
├── Bank.java
├── BankAccount.java
├── CheckingAccount.java
└── SavingsAccount.java
```

## How to Run
Compile and run the program from the terminal:
```bash
javac Bank.java BankAccount.java CheckingAccount.java SavingsAccount.java
java Bank
```
## Sample Menu Options
```
1. Create Account
2. Deposit
3. Withdraw
4. Display All Accounts
5. Apply Interest Rate
6. Exit
```

## Sample Functionality
- Prevents deposits of non-positive amounts
- Prevents withdrawals that exceed balance or overdraft limits
- Applies interest only to Savings accounts
- Displays clear success and error messages for user actions

## Limitations & Future Enhancements
- Fixed-size account storage (array limited to 10 accounts)
- No persistent storage (data resets when program exits)
- Possible improvements:
  - Dynamic storage using collections (`ArrayList`)
  - File or database persistence
  - Transaction history tracking
  - User authentication
  - Graphical user interface (GUI)
