@AddEmployer
Feature: AddEmployer

  Scenario: USer create a Sub Admin
    Given   [Login Page] User enter the email "11195"
    When    [Login Page] User enter the password "Password1"
    Then    [Login page] User tap on login button
    Given   [Sub Admin] User tap on the sub admin button
    Then    [Sub Admin] User tap on the add sub button
    When    [Sub Admin] User enter name "User"
    Then    [Sub Admin] User enter the email address "ali"
    And     [Sub Admin] User enter the password "Password1"
    Then    [Sub Admin] Use enter the phone no ""
    #And     [Sub Admin] User select the Role "HR"
    #Then    [Sub Admin] Use tap on the Add sub admin
    #Then    [Sub Admin] User tap the role manage access "USERS_DELETE"
    #Then    [Sub Admin] User tap the role manage access "USERS_UPDATE"
    #Then    [Sub Admin] User tap the role manage access "USERS_READ"
    #Then    [Sub Admin] User tap the role manage access "USERS_CREATE"
    And     [Sub Admin] User tap on the submit button

  Scenario: USer create a Sub Admin without enter a email
    Given   [Login Page] User enter the email "kamelpay469437@kamelpay.com"
    When    [Login Page] User enter the password "123kamelpay321"
    Then    [Login page] User tap on login button
    Given   [Sub Admin] User tap on the sub admin button
    Then    [Sub Admin] User tap on the add sub button
    When    [Sub Admin] User enter name "ali raza"
    And     [Sub Admin] User enter the password "Password1"
    Then    [Sub Admin] Use enter the phone no ""
    And     [Sub Admin] User select the Role "HR"
    Then    [Sub Admin] Use tap on the Add sub admin
    And     [Sub Admin] User should validate the error message on the email "Please enter your Email."

  Scenario: USer create a Sub Admin without name
    Given   [Login Page] User enter the email "kamelpay469437@kamelpay.com"
    When    [Login Page] User enter the password "123kamelpay321"
    Then    [Login page] User tap on login button
    Given   [Sub Admin] User tap on the sub admin button
    Then    [Sub Admin] User tap on the add sub button
    Then    [Sub Admin] User enter the email address "ali"
    And     [Sub Admin] User enter the password "Password1"
    Then    [Sub Admin] Use enter the phone no ""
    And     [Sub Admin] User select the Role "HR"
    Then    [Sub Admin] Use tap on the Add sub admin
    And     [Sub Admin] User should validate the error message on the email "Please enter Company name"

  Scenario: USer create a Sub Admin without password
    Given   [Login Page] User enter the email "kamelpay469437@kamelpay.com"
    When    [Login Page] User enter the password "123kamelpay321"
    Then    [Login page] User tap on login button
    Given   [Sub Admin] User tap on the sub admin button
    Then    [Sub Admin] User tap on the add sub button
    When    [Sub Admin] User enter name "ali raza"
    Then    [Sub Admin] User enter the email address "ali"
    Then    [Sub Admin] Use enter the phone no ""
    And     [Sub Admin] User select the Role "HR"
    Then    [Sub Admin] Use tap on the Add sub admin
    And     [Sub Admin] User should validate the error message on the email "Password is required"

  Scenario: USer create a Sub Admin without phone no
    Given   [Login Page] User enter the email "kamelpay469437@kamelpay.com"
    When    [Login Page] User enter the password "123kamelpay321"
    Then    [Login page] User tap on login button
    Given   [Sub Admin] User tap on the sub admin button
    Then    [Sub Admin] User tap on the add sub button
    When    [Sub Admin] User enter name "ali raza"
    Then    [Sub Admin] User enter the email address "ali"
    And     [Sub Admin] User enter the password "Password1"
    And     [Sub Admin] User select the Role "HR"
    Then    [Sub Admin] Use tap on the Add sub admin
    And     [Sub Admin] User should validate the error message on the email "Please enter Phone Number"

  Scenario: USer create a Sub Admin without select role
    Given   [Login Page] User enter the email "kamelpay469437@kamelpay.com"
    When    [Login Page] User enter the password "123kamelpay321"
    Then    [Login page] User tap on login button
    Given   [Sub Admin] User tap on the sub admin button
    Then    [Sub Admin] User tap on the add sub button
    When    [Sub Admin] User enter name "ali raza"
    Then    [Sub Admin] User enter the email address "ali"
    And     [Sub Admin] User enter the password "Password1"
    Then    [Sub Admin] Use enter the phone no ""
    Then    [Sub Admin] Use tap on the Add sub admin
    And     [Sub Admin] User should validate the error message on the email "Please select a role"
















