@UpdateProfile
Feature: Update Profile

  Scenario: User approve by admin
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
    Then    [Update Profile] User enter the establishment id ""
    And     [Update Profile] User the address "asdfghjkl;1234567890"
    #Then    [Update Profile] User tap on State
    #And     [Update Profile] Select D:\Hrcms\src\test\java\document\Mansha List test.xlsxstate "Dubai"
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
    Then    [Admin Page] Open the admin tab "http://admin.getthelingo.com"
    And     [Admin Page] User tap on login page
    Then    [Approval Page] User tap on approval
    And     [Approval Page] User create a new company and also approve by admin "11282"



    Scenario: abd
      Then    [Admin Page] Open the admin tab "http://10.40.5.62:52684"
      And     [Admin Page] User tap on login page
      Then    [Approval Page] User tap on approval
      And     [Approval Page] User cearte a new company and also approve by admin "11282"