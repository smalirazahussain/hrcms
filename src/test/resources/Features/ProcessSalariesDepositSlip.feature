@ProcessSalariesDepositSlip
Feature: ProcessSalariesDepositSlip

  @Update @UpdateProfile1
  Scenario: Add salary
    Given   [Login Page] User enter the email "12197"
    When    [Login Page] User enter the password "Password1"
    Then    [Login page] User tap on login button
    And     [Process Salaries DepositSlip Page] User Tap on Process Salaries Deposit Slip
    When    [Process Salaries DepositSlip Page] User enter company name and download the salary template























