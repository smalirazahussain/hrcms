@ProcessSalariesDepositSlip
Feature: ProcessSalariesDepositSlip

  @Update @UpdateProfile1
  Scenario: Add salary
    Given   [Login Page] User enter the email "12205"
    When    [Login Page] User enter the password "Password2"
    Then    [Login page] User tap on login button
    And     [Process Salaries DepositSlip Page] User Tap on Process Salaries Deposit Slip
    When    [Process Salaries DepositSlip Page] User enter company name and download the salary template

  Scenario: Add salary against the employees and create a approval foe the employer and then approve for the admin portal
    Given   [Login Page] User enter the email "11944"
    When    [Login Page] User enter the password "Password1"
    Then    [Login page] User tap on login button
    And     [Process Salaries DepositSlip Page] User Tap on Process Salaries Deposit Slip
    When    [Process Salaries DepositSlip Page] User enter company name and download the salary template
    Then    [Process Salaries DepositSlip Page] User select the month and then upload the process file "2012-04"
    And     [Process Salaries DepositSlip Page] User tap on browse file and upload a salary process file
    Then    [Process Salaries DepositSlip Page] User tap on submit button
    And     [Request Page] User tap on the request button
    Then    [Request Page] User tap on the view button
    And     [Request Page] User tap on the Approve button
    Then    [Admin Page] Open the admin tab "https://admin.getthelingo.com/"
    And     [Admin Page] User tap on login page
    Then    [Admin Page] User enter the  email "admin@admin.com"
    When    [Admin Page] User enter the Password "12345678"
    And     [Admin Page] User tap on login page
    When    [Admin Page] User tap on client Approvals
    Then    [Admin Page] User enter the company name
    And     [Admin Page] User tap on view button
    Then    [Admin Page] User tap on approve button
    Then    [Admin Page] User tap on process salary approve button
    #And     [Admin Page] User Tap on the approve button
    Then    [Admin Page] User verify the notification message "Action Successfully"

  @Update @UpdateProfile1
  Scenario: Add salary add
    Given   [Login Page] User enter the email "12197"
    When    [Login Page] User enter the password "Password1"
    Then    [Login page] User tap on login button
    And     [Process Salaries DepositSlip Page] User Tap on Process Salaries Deposit Slip
    When    [Process Salaries DepositSlip Page] User enter company name and download the salary template then enter the salary in total colomn





















