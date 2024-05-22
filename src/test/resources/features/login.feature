Feature: User Login

Scenario: Successful Login with Valid Credentials
    Given the user is on the login page
    When the user enters valid credentials
    Then the user should be redirected to the inventory page

Scenario: Unsuccessful login with invalid credentials
     Given the user is on the login page
     When the user enters invalid credentials
     Then an error message should be displayed