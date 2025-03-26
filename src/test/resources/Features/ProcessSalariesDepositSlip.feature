@ProcessSalariesDepositSlip
Feature: ProcessSalariesDepositSlip

  @ProcessSalariesDepositSlip @ProcessSalariesDepositSlip1
  Scenario: Add salary
    Given   [Login Page] User enter the email "12205"
    When    [Login Page] User enter the password "Password2"
    Then    [Login page] User tap on login button
    And     [Process Salaries DepositSlip Page] User Tap on Process Salaries Deposit Slip
    When    [Process Salaries DepositSlip Page] User enter company name and download the salary template

  @ProcessSalariesDepositSlip @ProcessSalariesDepositSlip2
  Scenario: Add salary information for employees and implement an approval process for employers. Once approved by the employer, the salary details can be forwarded to the admin portal for final approval."
    Given   [Login Page] User enter the email ""
    When    [Login Page] User enter the password ""
    Then    [Login page] User tap on login button
    And     [Process Salaries DepositSlip Page] User Tap on Process Salaries Deposit Slip
    When    [Process Salaries DepositSlip Page] User enter company name and download the salary template
    Then    [Process Salaries DepositSlip Page] User select the month and then upload the process file "2012-04"
    And     [Process Salaries DepositSlip Page] User tap on browse file and upload a salary process file
    Then    [Process Salaries DepositSlip Page] User tap on submit button
    And     [Employees Page] User verify the message "Salary file uploaded for approval"
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
    #Then    [Admin Page] User tap on process salary approve button
    #And     [Admin Page] User Tap on the approve button
    Then    [Admin Page] User verify the notification message "Action Successful"

  @ProcessSalariesDepositSlip @ProcessSalariesDepositSlip3
  Scenario: Create and upload salary files as well as deposit files for employees. Implement an approval process for employers to review and approve these files. Once approved by the employer, the files can then be forwarded for final approval.
    Given   [Login Page] User enter the email ""
    When    [Login Page] User enter the password ""
    Then    [Login page] User tap on login button
    And     [Process Salaries DepositSlip Page] User Tap on Process Salaries Deposit Slip
    When    [Process Salaries DepositSlip Page] User enter company name and download the salary template
    Then    [Process Salaries DepositSlip Page] User select the month and then upload the process file "2012-04"
    And     [Process Salaries DepositSlip Page] User tap on browse file and upload a salary process file
    Then    [Process Salaries DepositSlip Page] User tap on submit button
    And     [Employees Page] User verify the message "Salary file uploaded for approval"
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
    #Then    [Admin Page] User tap on process salary approve button
    #And     [Admin Page] User Tap on the approve button
    Then    [Admin Page] User verify the notification message "Action Successful"





  @Update @UpdateProfile1
  Scenario: Add salary add
    Given   [Login Page] User enter the email "12197"
    When    [Login Page] User enter the password "Password1"
    Then    [Login page] User tap on login button
    And     [Process Salaries DepositSlip Page] User Tap on Process Salaries Deposit Slip
    When    [Process Salaries DepositSlip Page] User enter company name and download the salary template then enter the salary in total colomn

  Scenario: Multiple approval
    Given   [Login Page] User enter the email ""
    When    [Login Page] User enter the password ""
    Then    [Login page] User tap on login button
    And     [Process Salaries DepositSlip Page] User Tap on Process Salaries Deposit Slip
    When    [Process Salaries DepositSlip Page] User enter company name and download the salary template
    Then    [Process Salaries DepositSlip Page] User select the month and then upload the process file "2012-04"
    And     [Process Salaries DepositSlip Page] User tap on browse file and upload a salary process file
    Then    [Process Salaries DepositSlip Page] User tap on submit button
    Then    [Process Salaries DepositSlip Page] User select the month and then upload the process file "2012-04"
    And     [Process Salaries DepositSlip Page] User tap on browse file and upload a salary process file
    Then    [Process Salaries DepositSlip Page] User tap on submit button
    Then    [Process Salaries DepositSlip Page] User select the month and then upload the process file "2012-04"
    And     [Process Salaries DepositSlip Page] User tap on browse file and upload a salary process file
    Then    [Process Salaries DepositSlip Page] User tap on submit button
    Then    [Process Salaries DepositSlip Page] User select the month and then upload the process file "2012-04"
    And     [Process Salaries DepositSlip Page] User tap on browse file and upload a salary process file
    Then    [Process Salaries DepositSlip Page] User tap on submit button
    Then    [Process Salaries DepositSlip Page] User select the month and then upload the process file "2012-04"
    And     [Process Salaries DepositSlip Page] User tap on browse file and upload a salary process file
    Then    [Process Salaries DepositSlip Page] User tap on submit button
    Then    [Process Salaries DepositSlip Page] User select the month and then upload the process file "2012-04"
    And     [Process Salaries DepositSlip Page] User tap on browse file and upload a salary process file
    Then    [Process Salaries DepositSlip Page] User tap on submit button
    Then    [Process Salaries DepositSlip Page] User select the month and then upload the process file "2012-04"
    And     [Process Salaries DepositSlip Page] User tap on browse file and upload a salary process file
    Then    [Process Salaries DepositSlip Page] User tap on submit button
    Then    [Process Salaries DepositSlip Page] User select the month and then upload the process file "2012-04"
    And     [Process Salaries DepositSlip Page] User tap on browse file and upload a salary process file
    Then    [Process Salaries DepositSlip Page] User tap on submit button
    Then    [Process Salaries DepositSlip Page] User select the month and then upload the process file "2012-04"
    And     [Process Salaries DepositSlip Page] User tap on browse file and upload a salary process file
    Then    [Process Salaries DepositSlip Page] User tap on submit button



















