@Login
Feature: Login Tests

  @Login @Login01
  Scenario: User successfully login
    Given   [Login Page] User enter the email "automation21@mailinator.com"
    When    [Login Page] User enter the password "Password1"
    Then    [Login page] User tap on login button
    And     [Login page] Verified user land on update profile page "Update Profile"

  @Login @Login02
  Scenario: User login without email address
    When    [Login Page] User enter the password "Password1"
    Then    [Login page] User tap on login button
    And     [Login page] Validate error message in email "Please enter your Email."

  @Login @Login03
  Scenario: User login without Password
    Given   [Login Page] User enter the email "kardiya01@mailinator.com"
    Then    [Login page] User tap on login button
    And     [Login page] Validate error message in Password "Please enter your Password."

  @Login @Login04
  Scenario: User Validate the password is hidden
    Given   [Login Page] User enter the email "kardiya01@mailinator.com"
    When    [Login Page] User enter the password "Password1"
    Then    [Login Page] User validate password is hidden "........."
    And     [Login Page] User tap on eye button
    Then    [Login page] User tap on login button
    And     [Login page] Verified user land on update profile page "Update Profile"

  @Login @Login05
  Scenario: User tap on eye button and validate the password
    Given   [Login Page] User enter the email "kardiya01@mailinator.com"
    When    [Login Page] User enter the password "Password1"
    And     [Login Page] User tap on eye button
    Then    [Login Page] Validate the password "Password1"
    Then    [Login page] User tap on login button
    And     [Login page] Verified user land on update profile page "Update Profile"

  @Login @Login05
  Scenario: User tap on eye button and validate the password 123
    Given   [Login Page] User enter the email "hikma05@mailinator.com"
    When    [Login Page] User enter the password "Password1"
    Then    [Login page] User tap on login button
    Then    [Sign Up] User enter the otp code "1111"

  Scenario Outline: Multiple user login
    Given   [Login Page] User upgrade  the email  "<email>"
    When    [Login Page] User enter the password "Password1"
    Then    [Login page] User tap on login button
    Then    [Sign Up] User enter the otp code "1111"
    And     [Sign Up] User tap on verify button
    Examples:

      |  | email                       |
      |  | automation21@mailinator.com |
      |  | automation22@mailinator.com |
      |  | automation23@mailinator.com |
      |  | automation24@mailinator.com |
      |  | automation25@mailinator.com |
      |  | automation26@mailinator.com |
      |  | automation27@mailinator.com |
      |  | automation28@mailinator.com |
      |  | automation29@mailinator.com |
      |  | automation30@mailinator.com |
      |  | automation31@mailinator.com |
      |  | automation32@mailinator.com |
      |  | automation33@mailinator.com |
      |  | automation34@mailinator.com |
      |  | automation35@mailinator.com |
      |  | automation36@mailinator.com |
      |  | automation37@mailinator.com |
      |  | automation38@mailinator.com |
      |  | automation39@mailinator.com |
      |  | automation40@mailinator.com |













