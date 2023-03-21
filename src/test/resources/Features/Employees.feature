@UpdateProfile
Feature: Update Profile

  @Update @UpdateProfile1
  Scenario: Add new employer
    Given   [Login Page] User enter the email "11247"
    When    [Login Page] User enter the password "Password1"
    Then    [Login page] User tap on login button
    Then    [Employees Page] User tap on employees button
    Given   [Add Employer] user tap on new employer button
    And     [Add Employer  User Select the Bank "Kamel Pay"
    And     [Add Employer] User enter the card "PayD Card"
    Then    [Add Employer] user enter the first name "ali"
    And     [Add Employer] user enter the middle name "raza"
    Then    [Add Employer] user enter the last name "hussain"
    And     [Add Employer] user enter the display name "demo1"
    Then    [Add Employer] user tap on gender field
    And     [Add Employer] user select the gender "Male"
    Then    [Add Employer] User enter the year 2017
    And     [Update Profile] User enter the month "Dec"
    Then    [Update Profile] User enter the day "3"
    And     [Add Employer] user enter the passport no ""
    Then    [Add Employer] user tao the nationality
   # Then    [Add Employer] user select the nationality "Afghanistan"
    And     [Add Employer] user enter the Mol no ""
    Then    [Add Employer] user enter the Employer code ""
    Then    [Add Employer] User select the establishmentid ""
    And     [Add Employer] user enter the date of joining year 2017
    And     [Update Profile] User enter the month of joining  "Jan"
    Then    [Add Employer]  User enter the day "10"
    And     [Add Employer] User enter the Emirates id ""
    And     [Add Employer] user enter mobile no "92123456789"
    Then    [Add Employer] user enter  alternate mobile no "921234567890"
    Then    [Add Employer] User select the document "Labour Card"
    Then    [Add Employer] User enter issue year 2017
    And     [Update Profile] User enter the month "Jan"
    Then    [Update Profile] User enter issue add employer the day "22"
    And     [Update Profile] User enter the add employer expire year 2030
    Then    [Update Profile] User enter the expire month "Jan"
    And     [Update Profile] User enter the add employer expire day "20"
    Then    [Update Profile] User tap on browse file
    And     [Add Employer] user tap on the add employer
