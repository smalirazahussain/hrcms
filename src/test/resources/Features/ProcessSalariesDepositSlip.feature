@ProcessSalariesDepositSlip
Feature: ProcessSalariesDepositSlip

  @Update @UpdateProfile1
  Scenario: Add salary
    Given   [Login Page] User enter the email "12197"
    When    [Login Page] User enter the password "Password1"
    Then    [Login page] User tap on login button
    And     [Process Salaries DepositSlip Page] User Tap on Process Salaries Deposit Slip
    When    [Process Salaries DepositSlip Page] User enter company name and download the salary template

  Scenario: Add salary against the employees and create a approval foe the employer and then approve for the admin portal
    Given   [Login Page] User enter the email "12205"
    When    [Login Page] User enter the password "Password1"
    Then    [Login page] User tap on login button
    And     [Process Salaries DepositSlip Page] User Tap on Process Salaries Deposit Slip
    When    [Process Salaries DepositSlip Page] User enter company name and download the salary template
    Then    [Process Salaries DepositSlip Page] User select the month and then upload the process file "2012-04"
    And     [Process Salaries DepositSlip Page] User tap on browse file and upload a salary process file

  @Update @UpdateProfile1
  Scenario: Add salary add
    Given   [Login Page] User enter the email "12197"
    When    [Login Page] User enter the password "Password1"
    Then    [Login page] User tap on login button
    And     [Process Salaries DepositSlip Page] User Tap on Process Salaries Deposit Slip
    When    [Process Salaries DepositSlip Page] User enter company name and download the salary template then enter the salary in total colomn





















