@SubAmin
Feature: SubAdmin

  Scenario: User create a Sub Admin
    Given   [Login Page] User enter the email "11413"
    When    [Login Page] User enter the password "123kamelpay321"
    Then    [Login page] User tap on login button
    Given   [Sub Admin] User tap on the sub admin button
    Then    [Sub Admin] User tap on the add sub button
    When    [Sub Admin] User enter name "User"
    Then    [Sub Admin] User enter the email address "user"
    And     [Sub Admin] User enter the password "Password1"
    And     [Sub Admin] User enter the Confirm password ""
    Then    [Sub Admin] Use enter the phone no "56"
    And     [Sub Admin] User tap on the submit button
    Then    [Sub Admin] User land on the "Manage Access" page
    Then    [Sub Admin] User tap on all check boxes
    And     [Sub Admin] User tap on the submit button
    Then    [Admin Page] User validate the toast message "Admin Updated Successfully"


  Scenario: User create a Sub Admin and verify all the heck boxes are selected
    Given   [Login Page] User enter the email "12742"
    When    [Login Page] User enter the password "Password1"
    Then    [Login page] User tap on login button
    Given   [Sub Admin] User tap on the sub admin button
    Then    [Sub Admin] User tap on the add sub button
    When    [Sub Admin] User enter name "User"
    Then    [Sub Admin] User enter the email address "user"
    And     [Sub Admin] User enter the password "Password1"
    And     [Sub Admin] User enter the Confirm password ""
    Then    [Sub Admin] Use enter the phone no "56"
    And     [Sub Admin] User tap on the submit button
    Then    [Sub Admin] User land on the "Manage Access" page
    Then    [Sub Admin] User tap on all check boxes
    And     [Sub Admin] User tap on the submit button
    Then    [Admin Page] User validate the toast message "Admin Updated Successfully"
    And     [Sub Admin] User search the sub admin
    Then    [Sub Admin] User tap on manage access button
    Then    [Sub Admin] User verify all the check boxes are selected

  Scenario: User create a Sub Admin and verify all the heck boxes are selected then login and verify all the module are visible
    Given   [Login Page] User enter the email "12742"
    When    [Login Page] User enter the password "Password1"
    Then    [Login page] User tap on login button
    Given   [Sub Admin] User tap on the sub admin button
    Then    [Sub Admin] User tap on the add sub button
    When    [Sub Admin] User enter name "User"
    Then    [Sub Admin] User enter the email address "user"
    And     [Sub Admin] User enter the password "Password1"
    And     [Sub Admin] User enter the Confirm password ""
    Then    [Sub Admin] Use enter the phone no "56"
    And     [Sub Admin] User tap on the submit button
    Then    [Sub Admin] User land on the "Manage Access" page
    Then    [Sub Admin] User tap on all check boxes
    And     [Sub Admin] User tap on the submit button
    Then    [Admin Page] User validate the toast message "Admin Updated Successfully"
    And     [Sub Admin] User search the sub admin
    Then    [Sub Admin] User tap on manage access button
    Then    [Sub Admin] User verify all the check boxes are selected
    Then    [DesHBoard Page] User tap on the logout from dashboard
    And     [Sub Admin] Use tap on the I am not the Primary User? button
    And     [Sub Admin] Use enter the the company id ""
    And     [Sub Admin] Use enter the team member email
    And     [Sub Admin] Use enter the team member password
    Then    [Login page] User tap on login button
    Then    [Sub Admin] User verify all the module are shown on the side bar

  Scenario: User create a Sub Admin and give him access only to creates employees
    Given   [Login Page] User enter the email "12742"
    When    [Login Page] User enter the password "Password1"
    Then    [Login page] User tap on login button
    Given   [Sub Admin] User tap on the sub admin button
    Then    [Sub Admin] User tap on the add sub button
    When    [Sub Admin] User enter name "User"
    Then    [Sub Admin] User enter the email address "user"
    And     [Sub Admin] User enter the password "Password1"
    And     [Sub Admin] User enter the Confirm password ""
    Then    [Sub Admin] Use enter the phone no "56"
    And     [Sub Admin] User tap on the submit button
    Then    [Sub Admin] User land on the "Manage Access" page
    Then    [Sub Admin] Employer give him access to sub admin to creates single, multiple employees,Deactivate Employees,Download Employees and Request Checker
    And     [Sub Admin] User tap on the submit button
    Then    [Admin Page] User validate the toast message "Admin Updated Successfully"
    And     [Sub Admin] User search the sub admin
    Then    [Sub Admin] User tap on manage access button
    Then    [Sub Admin] User verify check boxes they are selected
    Then    [DesHBoard Page] User tap on the logout from dashboard
    And     [Sub Admin] Use tap on the I am not the Primary User? button
    And     [Sub Admin] Use enter the the company id ""
    And     [Sub Admin] Use enter the team member email
    And     [Sub Admin] Use enter the team member password
    Then    [Login page] User tap on login button
    Then    [Sub Admin] User verify all the module are shown on the side bar

  Scenario: User create a Sub Admin and then login his credential and verify all the module are visible
    Given   [Login Page] User enter the email "12742"
    When    [Login Page] User enter the password "Password1"
    Then    [Login page] User tap on login button
    Given   [Sub Admin] User tap on the sub admin button
    Then    [Sub Admin] User tap on the add sub button
    When    [Sub Admin] User enter name "User"
    Then    [Sub Admin] User enter the email address "user"
    And     [Sub Admin] User enter the password "Password1"
    And     [Sub Admin] User enter the Confirm password ""
    Then    [Sub Admin] Use enter the phone no "56"
    And     [Sub Admin] User tap on the submit button
    Then    [Sub Admin] User land on the "Manage Access" page
    Then    [Sub Admin] User tap on all check boxes
    And     [Sub Admin] User tap on the submit button
    Then    [Admin Page] User validate the toast message "Admin Updated Successfully"
    And     [Sub Admin] User search the sub admin
    Then    [Sub Admin] User tap on manage access button
    Then    [Sub Admin] User verify all the check boxes are selected

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
















