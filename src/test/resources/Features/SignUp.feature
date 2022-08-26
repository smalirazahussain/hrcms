@SignUp
Feature: Login Tests

  @SignUp @SignUp001
  Scenario: User Create a New User
    Given   [Sign Up] User tap on Sign up button
    When    [Sign Up] User enter the name "kardiya01"
    Then    [Sign Up] User enter the email "kardiya01@mailinator.com"
    Then    [Sign Up] Enter the Phone code "92"
    Then    [Sign Up] User enter the phone no "3451234567"
    When    [Login Page] User enter the password "Password1"
    Then    [Sign Up] User enter the confirm password "Password1"
    And     [Sign Up] User tap on Sign up button on SignUp Page
    Then    [Sign Up] Validate the error message on user "Email Already Exist"
    #And     [Login page] Verified user land on update profile page "Update Profile"

  @SignUp @SignUp002
  Scenario: User sign up without enter the company name and validate the error message
    Given   [Sign Up] User tap on Sign up button
    Then    [Sign Up] User enter the email "kardiya01@mailinator.com"
    Then    [Sign Up] Enter the Phone code "92"
    Then    [Sign Up] User enter the phone no "03451234567"
    When    [Login Page] User enter the password "Password1"
    Then    [Sign Up] User enter the confirm password "Password1"
    And     [Sign Up] User tap on Sign up button on SignUp Page
    Then    [Sign Up]  Validate the company name error message "Please enter Company name"

  @SignUp @SignUp002
  Scenario: User sign up without enter the email and validate the error message
    Given   [Sign Up] User tap on Sign up button
    When    [Sign Up] User enter the name "kardiya01"
    Then    [Sign Up] Enter the Company code "92'
    Then    [Sign Up] User enter the phone no "03451234567"
    When    [Login Page] User enter the password "Password1"
    Then    [Sign Up] User enter the confirm password "Password1"
    And     [Sign Up] User tap on Sign up button
    Then    [Sign Up]  Validate the email error message "Please enter your Email."

  @SignUp @SignUp001
  Scenario: User Create a drop
    Given   [Sign Up] User tap on Sign up button
    When    [Sign Up] User enter the name "kardiya01"
    Then    [Sign Up] User enter the email "kardiya01@mailinator.com"
    Then    [Sign Up] Enter the Country code












