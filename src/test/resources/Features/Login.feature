@Login
Feature: Login Tests

  @Login @Login01
  Scenario: User successfully login
    Given   [Login Page] User enter the email "kardiya01@mailinator.com"
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















