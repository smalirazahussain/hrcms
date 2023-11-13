@AddEmployer
Feature: OtherCompany

  @Update @UpdateProfile1
  Scenario: Add new employer
    Given   [Login Page] User enter the email "12718"
    When    [Login Page] User enter the password "Password1"
    Then    [Login page] User tap on login button
    Then    [Other Company] User tap on my other companies
    Given   [Add Employer] user tap on Add other company button
    Then    [Update Profile] User enter the establishment id ""
    When    [Sign Up] User enter the name "kardiya01"
    #Then    [Sign Up] User enter the email "kardiya"
    Then    [Sign Up] Enter the Phone code "92"
    Then    [Sign Up] User enter the phone no "3451234567"
    When    [Login Page] User enter the password "Password1"
    Then    [Sign Up] User enter the confirm password "Password1"
    And     [Update Profile] User the address "asdfghjkl;1234567890"
    Then    [Other Company] User tap on State on other company
    And     [Update Profile] Select the state "Dubai"
    When    [Update Profile] User enter the city "Dubai"
    Then    [Update Profile] User enter the document name "Trade License"
    And     [Update Profile] User enter the document tittle "personal details"
    Then    [Update Profile] User enter the year 2017
    And     [Update Profile] User enter the month "Dec"
    Then    [Update Profile] User enter the day "3"
    And     [Update Profile] User enter the expire year 2030
    Then    [Update Profile] User enter the expire month "Oct"
    And     [Update Profile] User enter the expire day "31"
    Then     [Update Profile] User tap on browse file
    And     [Update Profile] User enter the submit button

  @Update @UpdateProfile1
  Scenario: Add new employer with Establishment Card
    Given   [Login Page] User enter the email "kamelpay469437@kamelpay.com"
    When    [Login Page] User enter the password "123kamelpay321"
    Then    [Login page] User tap on login button
    Then    [Other Company] User tap on my other companies
    Given   [Add Employer] user tap on Add other company button
    Then    [Update Profile] User enter the establishment id ""
    When    [Sign Up] User enter the name "kardiya01"
    Then    [Sign Up] User enter the email "kardiya"
    Then    [Sign Up] Enter the Phone code "92"
    Then    [Sign Up] User enter the phone no "3451234567"
    When    [Login Page] User enter the password "Password1"
    Then    [Sign Up] User enter the confirm password "Password1"
    And     [Update Profile] User the address "asdfghjkl;1234567890"
    Then    [Other Company] User tap on State on other company
    And     [Update Profile] Select the state "Dubai"
    When    [Update Profile] User enter the city "Dubai"
    Then    [Update Profile] User enter the document name "Establishment Card"
    And     [Update Profile] User enter the document tittle "personal details"
    Then    [Update Profile] User enter the year 2017
    And     [Update Profile] User enter the month "Dec"
    Then    [Update Profile] User enter the day "3"
    And     [Update Profile] User enter the expire year 2030
    Then    [Update Profile] User enter the expire month "Oct"
    And     [Update Profile] User enter the expire day "31"
    Then     [Update Profile] User tap on browse file
    And     [Update Profile] User enter the submit button

  @Update @UpdateProfile1
  Scenario: Add new employer with different state
    Given   [Login Page] User enter the email "kamelpay469437@kamelpay.com"
    When    [Login Page] User enter the password "123kamelpay321"
    Then    [Login page] User tap on login button
    Then    [Other Company] User tap on my other companies
    Given   [Add Employer] user tap on Add other company button
    Then    [Update Profile] User enter the establishment id ""
    When    [Sign Up] User enter the name "kardiya01"
    Then    [Sign Up] User enter the email "kardiya"
    Then    [Sign Up] Enter the Phone code "92"
    Then    [Sign Up] User enter the phone no "3451234567"
    When    [Login Page] User enter the password "Password1"
    Then    [Sign Up] User enter the confirm password "Password1"
    And     [Update Profile] User the address "asdfghjkl;1234567890"
    Then    [Other Company] User tap on State on other company
    And     [Update Profile] Select the state "Ras Al Khaimah"
    When    [Update Profile] User enter the city "Dubai"
    Then    [Update Profile] User enter the document name "Establishment Card"
    And     [Update Profile] User enter the document tittle "personal details"
    Then    [Update Profile] User enter the year 2017
    And     [Update Profile] User enter the month "Dec"
    Then    [Update Profile] User enter the day "3"
    And     [Update Profile] User enter the expire year 2030
    Then    [Update Profile] User enter the expire month "Oct"
    And     [Update Profile] User enter the expire day "31"
    Then     [Update Profile] User tap on browse file
    And     [Update Profile] User enter the submit button


















