@SignUp
Feature: Login Tests

  @SignUp @SignUp001
  Scenario: User Create a New User
    Given   [Sign Up] User tap on Sign up button
    When    [Sign Up] User enter the name "kardiya01"
    Then    [Sign Up] User enter the email "kardiya"
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
    Then    [Sign Up] User enter the email "kardiya"
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
    And     [Sign Up] User tap on Sign up button on SignUp Page
    Then    [Sign Up]  Validate the email error message "Please enter your Email."

  @SignUp @SignUp001
  Scenario: User create a account without phone number  and validate the error message
    Given   [Sign Up] User tap on Sign up button
    When    [Sign Up] User enter the name "kardiya01"
    Then    [Sign Up] User enter the email "kardiya"
    Then    [Sign Up] Enter the Phone code "92"
    When    [Login Page] User enter the password "Password1"
    Then    [Sign Up] User enter the confirm password "Password1"
    And     [Sign Up] User tap on Sign up button on SignUp Page
    And     [Sign Up] Validate the phone no error message "Please enter Phone Number"

  Scenario: Validate create account without enter password and validate the error message
    Given   [Sign Up] User tap on Sign up button
    When    [Sign Up] User enter the name "kardiya01"
    Then    [Sign Up] User enter the email "kardiya"
    Then    [Sign Up] Enter the Phone code "92"
    Then    [Sign Up] User enter the phone no "3451234567"
    Then    [Sign Up] User enter the confirm password "Password1"
    And     [Sign Up] User tap on Sign up button on SignUp Page
    And     [Sign Up] Validate the password error message"Password is required"


  Scenario: Validate create account without enter confirm password and validate the error message
    Given   [Sign Up] User tap on Sign up button
    When    [Sign Up] User enter the name "kardiya01"
    Then    [Sign Up] User enter the email "kardiya"
    Then    [Sign Up] Enter the Phone code "92"
    Then    [Sign Up] User enter the phone no "3451234567"
    When    [Login Page] User enter the password "Password1"
    And     [Sign Up] User tap on Sign up button on SignUp Page
    And     [Sign Up] Validate the confirm password error message"Confirm Password is required"

  Scenario: Validate create new account
    Given   [Sign Up] User tap on Sign up button
    When    [Sign Up] User enter the name "hikma"
    Then    [Sign Up] User enter the email "hikma"
    Then    [Sign Up] Enter the Phone code "92"
    Then    [Sign Up] User enter the phone no "3451234567"
    When    [Login Page] User enter the password "Password1"
    Then    [Sign Up] User enter the confirm password "Password1"
    And     [Sign Up] User tap on Sign up button on SignUp Page
    Then    [Sign Up] User enter the otp code "1111"
    And     [Sign Up] User tap on verify button

  Scenario Outline: Multiple user
    Given   [Sign Up] User tap on Sign up button
    When    [Sign up] Enter the user name email id "<company>" and "<email>"
    Then    [Sign Up] Enter the Phone code "92"
    Then    [Sign Up] User enter the phone no "3451234567"
    When    [Login Page] User enter the password "Password1"
    Then    [Sign Up] User enter the confirm password "Password1"
    And     [Sign Up] User tap on Sign up button on SignUp Page
    Then    [Sign Up] User enter the otp code "1111"
    And     [Sign Up] User tap on verify button
    And     [Login page] Verified user land on update profile page "Update Profile"
    Then    [Update Profile] User enter the establishment id ""
    And     [Update Profile] User the address "asdfghjkl;1234567890"
    Then    [Update Profile] User tap on State
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
    Then    [Update Profile] User tap on browse file
    #Then    [Update Profile] User upload the personal document
    And     [Update Profile] User enter the submit button


    Examples:
      | company      | email      |
      | automation21 | automation |
      | automation22 | automation |
      | automation23 | automation |
      | automation24 | automation |
      | automation25 | automation |
      | automation26 | automation |
      | automation27 | automation |
      | automation28 | automation |
      | automation29 | automation |
      | automation30 | automation |
      | automation31 | automation |
      | automation32 | automation |
      | automation33 | automation |
      | automation34 | automation |
      | automation35 | automation |
      | automation36 | automation |
      | automation37 | automation |
      | automation38 | automation |
      | automation39 | automation |
      | automation40 | automation |

    










