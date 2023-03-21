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
    Then    [Sign Up] Enter the Phone code "92"
    Then    [Sign Up] User enter the phone no "03451234567"
    When    [Login Page] User enter the password "Password1"
    Then    [Sign Up] User enter the confirm password "Password1"
    And     [Sign Up] User tap on Sign up button
    Then    [Sign Up]  Validate the email error message "Please enter your Email."

  @SignUp @SignUp001
  Scenario: User create a account without phone number  and validate the error message
    Given   [Sign Up] User tap on Sign up button
    When    [Sign Up] User enter the name "kardiya01"
    Then    [Sign Up] User enter the email "kardiya01@mailinator.com"
    Then    [Sign Up] Enter the Phone code "92"
    When    [Login Page] User enter the password "Password1"
    Then    [Sign Up] User enter the confirm password "Password1"
    And     [Sign Up] User tap on Sign up button on SignUp Page
    And     [Sign Up] Validate the phone no error message "Please enter Phone Number"

  Scenario: Validate create account without enter password and validate the error message
    Given   [Sign Up] User tap on Sign up button
    When    [Sign Up] User enter the name "kardiya01"
    Then    [Sign Up] User enter the email "kardiya01@mailinator.com"
    Then    [Sign Up] Enter the Phone code "92"
    Then    [Sign Up] User enter the phone no "3451234567"
    Then    [Sign Up] User enter the confirm password "Password1"
    And     [Sign Up] User tap on Sign up button on SignUp Page
    And     [Sign Up] Validate the password error message"Password is required"


  Scenario: Validate create account without enter confirm password and validate the error message
    Given   [Sign Up] User tap on Sign up button
    When    [Sign Up] User enter the name "kardiya01"
    Then    [Sign Up] User enter the email "kardiya01@mailinator.com"
    Then    [Sign Up] Enter the Phone code "92"
    Then    [Sign Up] User enter the phone no "3451234567"
    When    [Login Page] User enter the password "Password1"
    And     [Sign Up] User tap on Sign up button on SignUp Page
    And     [Sign Up] Validate the confirm password error message"Confirm Password is required"

  Scenario: Validate create new account
    Given   [Sign Up] User tap on Sign up button
    When    [Sign Up] User enter the name "hikma08"
    Then    [Sign Up] User enter the email "hikma08@mailinator.com"
    Then    [Sign Up] Enter the Phone code "92"
    Then    [Sign Up] User enter the phone no "3451234567"
    When    [Login Page] User enter the password "Password1"
    Then    [Sign Up] User enter the confirm password "Password1"
    And     [Sign Up] User tap on Sign up button on SignUp Page
    Then    [Sign Up] User enter the otp code "1111"
    And     [Sign Up] User tap on verify button










