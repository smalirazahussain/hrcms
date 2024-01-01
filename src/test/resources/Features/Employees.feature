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
    And     [Add Employer] User select the card type "PayD Card"
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
    Then    [Add Employer] User select the establishment id
    And     [Add Employer] user enter the date of joining year 2017
    And     [Update Profile] User enter the month of joining  "Jan"
    Then    [Add Employer]  User enter the day "10"
    #And     [Add Employer] User enter the Emirates id ""
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

  Scenario Outline: Create multiple Employees for any employer
    Given   [Login Page] User enter the email "1205"
    When    [Login Page] User enter the password "Password2"
    Then    [Login page] User tap on login button
    Then    [Employees Page] User tap on employees button
    And     [Employees Page] User create a multiple data for the any employer "<MolNo>""<EmpCode>""<FirstName>""<LastName>""<DisplayName>""<DOB>"" <Gender> "" <Nationality>""<JoiningDate>""<Email>""<MobileNo>""<AlternatePhone>""<HomeAddress>""<HomeState>""<HomePostCode>""<WorkAddress>""<WorkState>""<WorkPostCode>""<PassportNo>""<PassportExpiry>""<EID>""<EIDExpiry>""<EstablishmentId>"
    And     [Employees Page] User upload a bulk employees file ""
    And     [Request Page] User tap on the request button
    Then    [Request Page] User tap on the view button
    And     [Request Page] User tap on the Approve button
    Then    [Admin Page] Open the admin tab "https://admin.getthelingo.com/"
    And     [Admin Page] User tap on login page
    Then    [Admin Page] User enter the  email "admin@admin.com"
    When    [Admin Page] User enter the Password "12345678"
    And     [Admin Page] User tap on login page
    When    [Admin Page] User tap on client Approvals
    Then    [Admin Page] User enter the company name
    And     [Admin Page] User tap on view button
    Then    [Admin Page] User tap on approve button
    Then    [Admin Page] User Tap om the browse button
    Then    [Admin Page] User select the card type "PayD"
    Then    [Admin Page] User tap No other bank employees in given file
    And     [Admin Page] User Tap on the approve button
    Then    [Admin Page] User verify the notification message "Action Successfully"

    Examples:
      |FirstName|MolNo|EmpCode|LastName|DisplayName|DOB|Gender|Nationality|JoiningDate|Email|MobileNo|AlternatePhone|HomeAddress|HomeState|HomePostCode|WorkAddress|WorkState|WorkPostCode|PassportNo|PassportExpiry|EID|EIDExpiry|EstablishmentId|
      |User|Mol12345|1|1|User|05/05/1978|M|BD|05/05/1978|@mailinator.com|971|971|Address|1|00001|2|2|2|Passport|10/05/2029|10000000000|10/05/2029|7754116879536638|