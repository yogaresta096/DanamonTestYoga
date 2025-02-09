Feature: Mobile Login

  Scenario: Valid Login
    Given the user is on the login screen
    When the user enters valid credentials
    Then the user should be logged in successfully

  Scenario: Invalid Login with Wrong Username
    Given the user is on the login screen
    When the user enters an invalid username
    Then an error message should be displayed

  Scenario: Invalid Login with Wrong Password
    Given the user is on the login screen
    When the user enters an invalid password
    Then an error message should be displayed
