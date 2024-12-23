# Web Application Testing Automation Using Selenium

## Project Overview
This project was developed by **Md Yeasin Arafat** as part of a comprehensive effort to automate the testing of web applications using Selenium. It targets key functionalities such as login tests, input validation, edge case testing, account creation, and basic security testing. The primary test environment is the Magento testing website.

---

## Features
1. **Functional Tests**
    - Valid Login
    - Invalid Login
    - Empty Field Handling

2. **Edge Case Testing**
    - Unusual inputs, boundary values, and unexpected scenarios.

3. **Input Validation Tests**
    - Ensures form fields handle input validation correctly.

4. **Account Creation**
    - Automatically creates a user account, logs in, adds products to the cart, proceeds to checkout, and completes payment testing.

5. **Security Tests**
    - SQL Injection testing for login security.
    - SSL verification for secure communication.

---

## Tools and Technologies
- **Programming Language**: Java
- **Browser Driver**: ChromeDriver
- **Testing Framework**: Selenium WebDriver
- **Target Website**: Magento (https://magento.softwaretestingboard.com/)

---

## How to Run the Project
### Prerequisites:
1. **Install Java**: Ensure you have JDK installed on your machine.
2. **Install Selenium**: Add Selenium WebDriver to your project.
3. **ChromeDriver**: Download ChromeDriver and place it in the `Drivers` folder.

### Steps to Execute:
1. Clone or download this repository.
2. Configure your `chromedriver` path in each Java file.
3. Compile and execute the test files sequentially:
    - `FunctionalTests.java`
    - `EdgeCaseTests.java`
    - `InputValidationTests.java`
    - `AccountCreationTest.java`
    - `SecurityTests.java`

   Example:
   ```bash
   javac -cp .:selenium-server.jar sampleapp/*.java
   java -cp .:selenium-server.jar sampleapp.AccountCreationTest
