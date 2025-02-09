# Mobile Login Test Automation

## Overview
This project automates the login screen for a mobile app using Appium and Cucumber in Java.

## Requirements
- Java 11 or higher
- Maven
- Appium
- Cucumber
- TestNG

## Setup Instructions
1. Clone the repository:
   ```bash
   git clone <repository-url>
   cd mobile-login-test-automation
   ```

2. Install dependencies:
   ```bash
   mvn clean install
   ```

3. Set up Appium server:
   - Ensure Appium is installed and running.

4. Configure the desired capabilities in the `resources/config/` file

5. Run the tests:
   ```bash
   mvn test
   ```

## Project Structure
- `src/main/java/org/danamon/pageobject/`: Contains the Page Object Model classes.
- `src/test/resources/features/`: Contains the Cucumber feature files.
- `src/test/java/stepsdefinitions/`: Contains the step definitions for Cucumber.
- `src/test/java/runners/`: Contains the test runner class.
- `src/test/java/utils/`: Contains utility classes for configuration

## Test Output
- Test results will be printed in the console.
- An HTML report will be generated in the `target/reports/` directory.
