@AddEmployer
Feature: AddEmployer

  @Update @UpdateProfile1
  Scenario: Add new employer
    Given   [Login Page] User enter the email "11834"
    When    [Login Page] User enter the password "Password1"
    Then    [Login page] User tap on login button
    Then    [Employees Page] User tap on employees button
    Given   [Add Employer] user tap on new employer button
    And     [Add Employer  User Select the Bank "Kamel Pay"
    Then    [Add Employer] User select the card type "PayD Card"
    Then    [Add Employer] user enter the first name "User"
    And     [Add Employer] user enter the middle name "mid"
    Then    [Add Employer] user enter the last name ""
    And     [Add Employer] user enter the display name ""
    Then    [Add Employer] user tap on gender field
    And     [Add Employer] user select the gender "Male"
    Then    [Add Employer] User enter the year 2017
    And     [Update Profile] User enter the month "Dec"
    Then    [Update Profile] User enter the day "3"
    #And     [Add Employer] user enter the passport no ""
    Then    [Add Employer] user tao the nationality
   # Then    [Add Employer] user select the nationality "Afghanistan"
    And     [Add Employer] user enter the Mol no ""
    Then    [Add Employer] user enter the Employer code ""
    When    [Add Employer] User select the establishment id
    And     [Add Employer] user enter the date of joining year 2017
    And     [Update Profile] User enter the month of joining  "Jan"
    Then    [Add Employer]  User enter the day "10"
    And     [Add Employer] user enter mobile no "971"
    Then    [Add Employer] user enter  alternate mobile no "921234567890"
    Then    [Add Employer] User enter issue year "01-Jan-2015"
    #Then    [Add Employer] User enter issue year 2017
    #And     [Update Profile] User enter the Passport month "June"
    #Then    [Update Profile] User enter issue add employer the day "22"
    And     [Update Profile] User enter the add employer expire year 2030
    Then    [Update Profile] User enter the Passport expire month "May"
    And     [Update Profile] User enter the add employer expire day "20"
    Then    [Add Employer]   User enter the Passport no
    Then    [Update Profile] User tap on browse file
    And     [Add Employer] user tap on the add employer
    Then    [Add Employer] User Validate the employee notification message "New employee added successfully, Please wait for approval"
    And     [Request Page] User tap on the request button
    Then    [Request Page] User tap on the view button
    And     [Request Page] User verify the mol and passport no and then click the approve button
    Then    [Admin Page] Open the admin tab "http://admin.getthelingo.com"
    And     [Admin Page] User tap on login page
    Then    [Admin Page] User enter the  email "admin@admin.com"
    When    [Admin Page] User enter the Password "12345678"
    And     [Admin Page] User tap on login page
    When    [Admin Page] User tap on client Approvals
    Then    [Admin Page] User enter the company name
    And     [Admin Page] User tap on view button
    And     [Request Page] User verify the mol and passport no and then click the approve button
    Then    [Admin Page] User validate the toast message "Action Successfully"

  Scenario: Add new employer with Centiv Card
    Given   [Login Page] User enter the email "11793"
    When    [Login Page] User enter the password "Password1"
    Then    [Login page] User tap on login button
    Then    [Employees Page] User tap on employees button
    Given   [Add Employer] user tap on new employer button
    And     [Add Employer  User Select the Bank "Kamel Pay"
    Then    [Add Employer] User select the card type "Centiv Card"
    Then    [Add Employer] user enter the first name "User"
    And     [Add Employer] user enter the middle name "mid"
    Then    [Add Employer] user enter the last name ""
    And     [Add Employer] user enter the display name ""
    Then    [Add Employer] user tap on gender field
    And     [Add Employer] user select the gender "Male"
    Then    [Add Employer] User enter the year 2017
    And     [Update Profile] User enter the month "Dec"
    Then    [Update Profile] User enter the day "3"
    #And     [Add Employer] user enter the passport no ""
    Then    [Add Employer] user tao the nationality
   # Then    [Add Employer] user select the nationality "Afghanistan"
    And     [Add Employer] user enter the Mol no ""
    Then    [Add Employer] user enter the Employer code ""
    When    [Add Employer] User select the establishment id
    And     [Add Employer] user enter the date of joining year 2017
    And     [Update Profile] User enter the month of joining  "Jan"
    Then    [Add Employer]  User enter the day "10"
    And     [Add Employer] user enter mobile no "971"
    Then    [Add Employer] user enter  alternate mobile no "921234567890"
    Then    [Add Employer] User enter issue year "01-Jan-2015"
    #Then    [Add Employer] User enter issue year 2017
    #And     [Update Profile] User enter the Passport month "June"
    #Then    [Update Profile] User enter issue add employer the day "22"
    And     [Update Profile] User enter the add employer expire year 2030
    Then    [Update Profile] User enter the Passport expire month "May"
    And     [Update Profile] User enter the add employer expire day "20"
    Then    [Add Employer]   User enter the Passport no
    Then    [Update Profile] User tap on browse file
    And     [Add Employer] user tap on the add employer
    Then    [Add Employer] User Validate the employee notification message "New employee added successfully, Please wait for approval"
    And     [Request Page] User tap on the request button
    Then    [Request Page] User tap on the view button
    And     [Request Page] User verify the mol and passport no and then click the approve button
    Then    [Admin Page] Open the admin tab "http://admin.getthelingo.com"
    And     [Admin Page] User tap on login page
    Then    [Admin Page] User enter the  email "admin@admin.com"
    When    [Admin Page] User enter the Password "12345678"
    And     [Admin Page] User tap on login page
    When    [Admin Page] User tap on client Approvals
    Then    [Admin Page] User enter the company name
    And     [Admin Page] User tap on view button
    And     [Request Page] User verify the mol and passport no and then click the approve button
    Then    [Admin Page] User validate the toast message "Action Successfully"

  Scenario: Add new employer with other bank
    Given   [Login Page] User enter the email "11793"
    When    [Login Page] User enter the password "Password1"
    Then    [Login page] User tap on login button
    Then    [Employees Page] User tap on employees button
    Given   [Add Employer] user tap on new employer button
    And     [Add Employer  User Select the Bank "Other Bank"
    Then    [Add Employer] User Select the bask "Ajman Bank"
    And     [Add Employer] User enter the branch name "Dubai"
    Then    [Add Employer] User enter the iBAN no "CY17002001280000001200527600"
    Then    [Add Employer] user enter the first name "User"
    And     [Add Employer] user enter the middle name "mid"
    Then    [Add Employer] user enter the last name ""
    And     [Add Employer] user enter the display name ""
    Then    [Add Employer] user tap on gender field
    And     [Add Employer] user select the gender "Male"
    Then    [Add Employer] User enter the year 2017
    And     [Update Profile] User enter the month "Dec"
    Then    [Update Profile] User enter the day "3"
    #And     [Add Employer] user enter the passport no ""
    #Then    [Add Employer] user tao the nationality
    Then    [Add Employer] user select the nationality "Pakistan"
    And     [Add Employer] user enter the Mol no ""
    Then    [Add Employer] user enter the Employer code "12345"
    And     [Add Employer] user enter the date of joining year 2017
    And     [Update Profile] User enter the month of joining  "Jan"
    Then    [Add Employer]  User enter the day "10"
    #And     [Add Employer] User enter the Emirates id ""
    And     [Add Employer] user enter mobile no "971"
    Then    [Add Employer] user enter  alternate mobile no "921234567890"
    When    [Add Employer] User select the establishment id
    When    [Add Employer] User tap on the add document
    Then    [Add Employer] User select the document "Labour Card"
    Then    [Add Employer] User enter issue year 2017
    #And     [Update Profile] User enter the month "Jan"
    Then    [Update Profile] User enter issue add employer the day "22"
    And     [Update Profile] User enter the add employer expire year 2030
    #Then    [Update Profile] User enter the expire month "Jan"
    And     [Update Profile] User enter the add employer expire day "20"
    Then    [Add Employer]   User enter the Passport no
    Then    [Update Profile] User tap on browse file
    And     [Add Employer] user tap on the add employer
    Then    [Add Employer] Validate employees should add successfully "New employee added successfully, Please wait for approval"
    And     [Request Page] User tap on the request button
    Then    [Request Page] User tap on the view button
    And     [Request Page] User verify the mol and passport no and then click the approve button
    Then    [Admin Page] Open the admin tab "http://admin.getthelingo.com"
    And     [Admin Page] User tap on login page
    Then    [Admin Page] User enter the  email "admin@admin.com"
    When    [Admin Page] User enter the Password "12345678"
    And     [Admin Page] User tap on login page
    When    [Admin Page] User tap on client Approvals
    Then    [Admin Page] User enter the company name
    And     [Admin Page] User tap on view button
    And     [Request Page] User verify the mol and passport no and then click the approve button
    Then    [Admin Page] User validate the toast message "Action Successfully"

  @Update @UpdateProfile1
  Scenario: Add new employer without enter employee type and validate the error message "Please enter Employee Type"
    Given   [Login Page] User enter the email "11793"
    When    [Login Page] User enter the password "Password1"
    Then    [Login page] User tap on login button
    Then    [Employees Page] User tap on employees button
    Given   [Add Employer] user tap on new employer button
    #And     [Add Employer  User Select the Bank "Kamel Pay"
    #Then    [Add Employer] User select the card type "PayD Card"
    Then    [Add Employer] user enter the first name "User"
    And     [Add Employer] user enter the middle name "mid"
    Then    [Add Employer] user enter the last name ""
    And     [Add Employer] user enter the display name ""
    Then    [Add Employer] user tap on gender field
    And     [Add Employer] user select the gender "Male"
    Then    [Add Employer] User enter the year 2017
    And     [Update Profile] User enter the month "Dec"
    Then    [Update Profile] User enter the day "3"
    #And     [Add Employer] user enter the passport no ""
    Then    [Add Employer] user tao the nationality
   # Then    [Add Employer] user select the nationality "Afghanistan"
    And     [Add Employer] user enter the Mol no ""
    Then    [Add Employer] user enter the Employer code ""
    When    [Add Employer] User select the establishment id
    And     [Add Employer] user enter the date of joining year 2017
    And     [Update Profile] User enter the month of joining  "Jan"
    Then    [Add Employer]  User enter the day "10"
    And     [Add Employer] user enter mobile no "971"
    Then    [Add Employer] user enter  alternate mobile no "921234567890"
    When    [Add Employer] User tap on the add document
    Then    [Add Employer] User select the document "Labour Card"
    Then    [Add Employer] User enter issue year "01-Jan-2015"
    #Then    [Add Employer] User enter issue year 2017
    #And     [Update Profile] User enter the Passport month "June"
    #Then    [Update Profile] User enter issue add employer the day "22"
    And     [Update Profile] User enter the add employer expire year 2030
    Then    [Update Profile] User enter the Passport expire month "Jan"
    And     [Update Profile] User enter the add employer expire day "20"
    Then    [Add Employer]   User enter the Passport no
    Then    [Update Profile] User tap on browse file
    And     [Add Employer] user tap on the add employer
    Then    [Add Employer] User forget employee type and validate  the error message "Please enter Employee Type"

  @Update @UpdateProfile1
  Scenario: Add new employer without enter card type and validate the error message "Please enter card type"
    Given   [Login Page] User enter the email "11793"
    When    [Login Page] User enter the password "Password1"
    Then    [Login page] User tap on login button
    Then    [Employees Page] User tap on employees button
    Given   [Add Employer] user tap on new employer button
    And     [Add Employer  User Select the Bank "Kamel Pay"
    #Then    [Add Employer] User select the card type "PayD Card"
    Then    [Add Employer] user enter the first name "User"
    And     [Add Employer] user enter the middle name "mid"
    Then    [Add Employer] user enter the last name ""
    And     [Add Employer] user enter the display name ""
    Then    [Add Employer] user tap on gender field
    And     [Add Employer] user select the gender "Male"
    Then    [Add Employer] User enter the year 2017
    And     [Update Profile] User enter the month "Dec"
    Then    [Update Profile] User enter the day "3"
    Then    [Add Employer] user tao the nationality
    And     [Add Employer] user enter the Mol no ""
    Then    [Add Employer] user enter the Employer code ""
    When    [Add Employer] User select the establishment id
    And     [Add Employer] user enter the date of joining year 2017
    And     [Update Profile] User enter the month of joining  "Jan"
    Then    [Add Employer]  User enter the day "10"
    And     [Add Employer] user enter mobile no "971"
    Then    [Add Employer] user enter  alternate mobile no "921234567890"
    Then    [Add Employer] User enter issue year "01-Jan-2015"
    And     [Update Profile] User enter the add employer expire year 2030
    Then    [Update Profile] User enter the Passport expire month "Jan"
    And     [Update Profile] User enter the add employer expire day "20"
    Then    [Add Employer]   User enter the Passport no
    Then    [Update Profile] User tap on browse file
    And     [Add Employer] user tap on the add employer
    Then    [Add Employer] User forget employee type and validate  the error message "Please enter card type"

  @Update @UpdateProfile1
  Scenario: Add new employer without enter Last Name and validate the error message "Please enter Last Name"
    Given   [Login Page] User enter the email "11793"
    When    [Login Page] User enter the password "Password1"
    Then    [Login page] User tap on login button
    Then    [Employees Page] User tap on employees button
    Given   [Add Employer] user tap on new employer button
    And     [Add Employer  User Select the Bank "Kamel Pay"
    Then    [Add Employer] User select the card type "PayD Card"
    Then    [Add Employer] user enter the first name "User"
    And     [Add Employer] user enter the middle name "mid"
    And     [Add Employer] user enter the display name ""
    Then    [Add Employer] user tap on gender field
    And     [Add Employer] user select the gender "Male"
    Then    [Add Employer] User enter the year 2017
    And     [Update Profile] User enter the month "Dec"
    Then    [Update Profile] User enter the day "3"
    Then    [Add Employer] user tao the nationality
    And     [Add Employer] user enter the Mol no ""
    Then    [Add Employer] user enter the Employer code ""
    When    [Add Employer] User select the establishment id
    And     [Add Employer] user enter the date of joining year 2017
    And     [Update Profile] User enter the month of joining  "Jan"
    Then    [Add Employer]  User enter the day "10"
    And     [Add Employer] user enter mobile no "971"
    Then    [Add Employer] user enter  alternate mobile no "921234567890"
    Then    [Add Employer] User enter issue year "01-Jan-2015"
    And     [Update Profile] User enter the add employer expire year 2030
    Then    [Update Profile] User enter the Passport expire month "Jan"
    And     [Update Profile] User enter the add employer expire day "20"
    Then    [Add Employer]   User enter the Passport no
    Then    [Update Profile] User tap on browse file
    And     [Add Employer] user tap on the add employer
    Then    [Add Employer] User forget employee type and validate  the error message "Please enter Last Name"

  @Update @UpdateProfile1
  Scenario: Add new employer without enter Gender and validate the error message "Please enter Gender"
    Given   [Login Page] User enter the email "11793"
    When    [Login Page] User enter the password "Password1"
    Then    [Login page] User tap on login button
    Then    [Employees Page] User tap on employees button
    Given   [Add Employer] user tap on new employer button
    And     [Add Employer  User Select the Bank "Kamel Pay"
    Then    [Add Employer] User select the card type "PayD Card"
    Then    [Add Employer] user enter the first name "User"
    And     [Add Employer] user enter the middle name "mid"
    Then    [Add Employer] user enter the last name ""
    And     [Add Employer] user enter the display name ""
    Then    [Add Employer] User enter the year 2017
    And     [Update Profile] User enter the month "Dec"
    Then    [Update Profile] User enter the day "3"
    #And     [Add Employer] user enter the passport no ""
    Then    [Add Employer] user tao the nationality
   # Then    [Add Employer] user select the nationality "Afghanistan"
    And     [Add Employer] user enter the Mol no ""
    Then    [Add Employer] user enter the Employer code ""
    When    [Add Employer] User select the establishment id
    And     [Add Employer] user enter the date of joining year 2017
    And     [Update Profile] User enter the month of joining  "Jan"
    Then    [Add Employer]  User enter the day "10"
    And     [Add Employer] user enter mobile no "971"
    Then    [Add Employer] user enter  alternate mobile no "921234567890"
    When    [Add Employer] User tap on the add document
    Then    [Add Employer] User enter issue year "01-Jan-2015"
    #Then    [Add Employer] User enter issue year 2017
    #And     [Update Profile] User enter the Passport month "June"
    #Then    [Update Profile] User enter issue add employer the day "22"
    And     [Update Profile] User enter the add employer expire year 2030
    Then    [Update Profile] User enter the Passport expire month "Jan"
    And     [Update Profile] User enter the add employer expire day "20"
    Then    [Add Employer]   User enter the Passport no
    Then    [Update Profile] User tap on browse file
    And     [Add Employer] user tap on the add employer
    Then    [Add Employer] User forget employee type and validate  the error message "Please enter Gender"

  @Update @UpdateProfile1
  Scenario: Add new employer without   enter Nationality and validate the error message "Please enter Nationality"
    Given   [Login Page] User enter the email "11195"
    When    [Login Page] User enter the password "Password1"
    Then    [Login page] User tap on login button
    Then    [Employees Page] User tap on employees button
    Given   [Add Employer] user tap on new employer button
    And     [Add Employer  User Select the Bank "Kamel Pay"
    Then    [Add Employer] User select the card type "PayD Card"
    Then    [Add Employer] user enter the first name "User"
    And     [Add Employer] user enter the middle name "mid"
    Then    [Add Employer] user enter the last name ""
    And     [Add Employer] user enter the display name ""
    Then    [Add Employer] user tap on gender field
    And     [Add Employer] user select the gender "Male"
    Then    [Add Employer] User enter the year 2017
    And     [Update Profile] User enter the month "Dec"
    Then    [Update Profile] User enter the day "3"
    And     [Add Employer] user enter the Mol no ""
    Then    [Add Employer] user enter the Employer code ""
    When    [Add Employer] User select the establishment id
    And     [Add Employer] user enter the date of joining year 2017
    And     [Update Profile] User enter the month of joining  "Jan"
    Then    [Add Employer]  User enter the day "10"
    And     [Add Employer] user enter mobile no "971"
    Then    [Add Employer] user enter  alternate mobile no "921234567890"
    When    [Add Employer] User tap on the add document
    Then    [Add Employer] User enter issue year "01-Jan-2015"
    #Then    [Add Employer] User enter issue year 2017
    #And     [Update Profile] User enter the Passport month "June"
    #Then    [Update Profile] User enter issue add employer the day "22"
    And     [Update Profile] User enter the add employer expire year 2030
    Then    [Update Profile] User enter the Passport expire month "Jan"
    And     [Update Profile] User enter the add employer expire day "20"
    Then    [Add Employer]   User enter the Passport no
    Then    [Update Profile] User tap on browse file
    And     [Add Employer] user tap on the add employer
    Then    [Add Employer] User forget employee type and validate  the error message "Please enter Nationality"

  @Update @UpdateProfile1
  Scenario: Add new employer Please enter First Name and validate the error message "Please enter First Name"
    Given   [Login Page] User enter the email "11195"
    When    [Login Page] User enter the password "Password1"
    Then    [Login page] User tap on login button
    Then    [Employees Page] User tap on employees button
    Given   [Add Employer] user tap on new employer button
    And     [Add Employer  User Select the Bank "Kamel Pay"
    Then    [Add Employer] User select the card type "PayD Card"
    And     [Add Employer] user enter the middle name "mid"
    Then    [Add Employer] user enter the last name ""
    And     [Add Employer] user enter the display name ""
    Then    [Add Employer] user tap on gender field
    And     [Add Employer] user select the gender "Male"
    Then    [Add Employer] User enter the year 2017
    And     [Update Profile] User enter the month "Dec"
    Then    [Update Profile] User enter the day "3"
    Then    [Add Employer] user tao the nationality
    And     [Add Employer] user enter the Mol no ""
    Then    [Add Employer] user enter the Employer code ""
    When    [Add Employer] User select the establishment id
    And     [Add Employer] user enter the date of joining year 2017
    And     [Update Profile] User enter the month of joining  "Jan"
    Then    [Add Employer]  User enter the day "10"
    And     [Add Employer] user enter mobile no "971"
    Then    [Add Employer] user enter  alternate mobile no "921234567890"
    Then    [Add Employer] User enter issue year "01-Jan-2015"
    And     [Update Profile] User enter the add employer expire year 2030
    Then    [Update Profile] User enter the Passport expire month "Jan"
    And     [Update Profile] User enter the add employer expire day "20"
    Then    [Add Employer]   User enter the Passport no
    Then    [Update Profile] User tap on browse file
    And     [Add Employer] user tap on the add employer
    Then    [Add Employer] User forget employee type and validate  the error message "Please enter First Name"

  @Update @UpdateProfile1
  Scenario: Add new employer without  enter Mol Number and validate the error message "Please enter Mol Number"
    Given   [Login Page] User enter the email "11195"
    When    [Login Page] User enter the password "Password1"
    Then    [Login page] User tap on login button
    Then    [Employees Page] User tap on employees button
    Given   [Add Employer] user tap on new employer button
    And     [Add Employer  User Select the Bank "Kamel Pay"
    Then    [Add Employer] User select the card type "PayD Card"
    Then    [Add Employer] user enter the first name "User"
    And     [Add Employer] user enter the middle name "mid"
    Then    [Add Employer] user enter the last name ""
    And     [Add Employer] user enter the display name ""
    Then    [Add Employer] user tap on gender field
    And     [Add Employer] user select the gender "Male"
    Then    [Add Employer] User enter the year 2017
    And     [Update Profile] User enter the month "Dec"
    Then    [Update Profile] User enter the day "3"
    Then    [Add Employer] user select the nationality "Afghanistan"
    Then    [Add Employer] user enter the Employer code ""
    When    [Add Employer] User select the establishment id
    And     [Add Employer] user enter the date of joining year 2017
    And     [Update Profile] User enter the month of joining  "Jan"
    Then    [Add Employer]  User enter the day "10"
    And     [Add Employer] user enter mobile no "971"
    Then    [Add Employer] user enter  alternate mobile no "921234567890"
    Then    [Add Employer] User enter issue year "01-Jan-2015"
    #Then    [Add Employer] User enter issue year 2017
    #And     [Update Profile] User enter the Passport month "June"
    #Then    [Update Profile] User enter issue add employer the day "22"
    And     [Update Profile] User enter the add employer expire year 2030
    Then    [Update Profile] User enter the Passport expire month "Jan"
    And     [Update Profile] User enter the add employer expire day "20"
    Then    [Add Employer]   User enter the Passport no
    Then    [Update Profile] User tap on browse file
    And     [Add Employer] user tap on the add employer
    Then    [Add Employer] User forget employee type and validate  the error message "Please enter Mol Number"

  @Update @UpdateProfile1
  Scenario: Add new employer without enter Employee Code and validate the error message "Please enter Employee Code"
    Given   [Login Page] User enter the email "11195"
    When    [Login Page] User enter the password "Password1"
    Then    [Login page] User tap on login button
    Then    [Employees Page] User tap on employees button
    Given   [Add Employer] user tap on new employer button
    And     [Add Employer  User Select the Bank "Kamel Pay"
    Then    [Add Employer] User select the card type "PayD Card"
    Then    [Add Employer] user enter the first name "User"
    And     [Add Employer] user enter the middle name "mid"
    Then    [Add Employer] user enter the last name ""
    And     [Add Employer] user enter the display name ""
    Then    [Add Employer] user tap on gender field
    And     [Add Employer] user select the gender "Male"
    Then    [Add Employer] User enter the year 2017
    And     [Update Profile] User enter the month "Dec"
    Then    [Update Profile] User enter the day "3"
    Then    [Add Employer] user select the nationality "Afghanistan"
    And     [Add Employer] user enter the Mol no ""
    When    [Add Employer] User select the establishment id
    And     [Add Employer] user enter the date of joining year 2017
    And     [Update Profile] User enter the month of joining  "Jan"
    Then    [Add Employer]  User enter the day "10"
    And     [Add Employer] user enter mobile no "971"
    Then    [Add Employer] user enter  alternate mobile no "921234567890"
    Then    [Add Employer] User enter issue year "01-Jan-2015"
    And     [Update Profile] User enter the add employer expire year 2030
    Then    [Update Profile] User enter the Passport expire month "Jan"
    And     [Update Profile] User enter the add employer expire day "20"
    Then    [Add Employer]   User enter the Passport no
    Then    [Update Profile] User tap on browse file
    And     [Add Employer] user tap on the add employer
    Then    [Add Employer] User forget employee type and validate  the error message "Please enter Employee Code"

  @Update @UpdateProfile1
  Scenario: Add new employer without  enter establishment Id and validate the error message "Please enter establishment Id"
    Given   [Login Page] User enter the email "11195"
    When    [Login Page] User enter the password "Password1"
    Then    [Login page] User tap on login button
    Then    [Employees Page] User tap on employees button
    Given   [Add Employer] user tap on new employer button
    And     [Add Employer  User Select the Bank "Kamel Pay"
    Then    [Add Employer] User select the card type "PayD Card"
    Then    [Add Employer] user enter the first name "User"
    And     [Add Employer] user enter the middle name "mid"
    Then    [Add Employer] user enter the last name ""
    And     [Add Employer] user enter the display name ""
    Then    [Add Employer] user tap on gender field
    And     [Add Employer] user select the gender "Male"
    Then    [Add Employer] User enter the year 2017
    And     [Update Profile] User enter the month "Dec"
    Then    [Update Profile] User enter the day "3"
    #And     [Add Employer] user enter the passport no ""
    Then    [Add Employer] user tao the nationality
   # Then    [Add Employer] user select the nationality "Afghanistan"
    And     [Add Employer] user enter the Mol no ""
    Then    [Add Employer] user enter the Employer code ""
    And     [Add Employer] user enter the date of joining year 2017
    And     [Update Profile] User enter the month of joining  "Jan"
    Then    [Add Employer]  User enter the day "10"
    And     [Add Employer] user enter mobile no "971"
    Then    [Add Employer] user enter  alternate mobile no "921234567890"
    Then    [Add Employer] User enter issue year "01-Jan-2015"
    #Then    [Add Employer] User enter issue year 2017
    #And     [Update Profile] User enter the Passport month "June"
    #Then    [Update Profile] User enter issue add employer the day "22"
    And     [Update Profile] User enter the add employer expire year 2030
    Then    [Update Profile] User enter the Passport expire month "Jan"
    And     [Update Profile] User enter the add employer expire day "20"
    Then    [Add Employer]   User enter the Passport no
    Then    [Update Profile] User tap on browse file
    And     [Add Employer] user tap on the add employer
    Then    [Add Employer] User forget employee type and validate  the error message "Please enter establishment Id"

  @Update @UpdateProfile1
  Scenario: Add new employer without  enter Passport and validate the error message "Please enter Passport"
    Given   [Login Page] User enter the email "11195"
    When    [Login Page] User enter the password "Password1"
    Then    [Login page] User tap on login button
    Then    [Employees Page] User tap on employees button
    Given   [Add Employer] user tap on new employer button
    And     [Add Employer  User Select the Bank "Kamel Pay"
    Then    [Add Employer] User select the card type "PayD Card"
    Then    [Add Employer] user enter the first name "User"
    And     [Add Employer] user enter the middle name "mid"
    Then    [Add Employer] user enter the last name ""
    And     [Add Employer] user enter the display name ""
    Then    [Add Employer] user tap on gender field
    And     [Add Employer] user select the gender "Male"
    Then    [Add Employer] User enter the year 2017
    And     [Update Profile] User enter the month "Dec"
    Then    [Update Profile] User enter the day "3"
    #And     [Add Employer] user enter the passport no ""
    Then    [Add Employer] user tao the nationality
   # Then    [Add Employer] user select the nationality "Afghanistan"
    And     [Add Employer] user enter the Mol no ""
    Then    [Add Employer] user enter the Employer code ""
    When    [Add Employer] User select the establishment id
    And     [Add Employer] user enter the date of joining year 2017
    And     [Update Profile] User enter the month of joining  "Jan"
    Then    [Add Employer]  User enter the day "10"
    And     [Add Employer] user enter mobile no "971"
    Then    [Add Employer] user enter  alternate mobile no "921234567890"
    Then    [Add Employer] User enter issue year "01-Jan-2015"
    #Then    [Add Employer] User enter issue year 2017
    #And     [Update Profile] User enter the Passport month "June"
    #Then    [Update Profile] User enter issue add employer the day "22"
    And     [Update Profile] User enter the add employer expire year 2030
    Then    [Update Profile] User enter the Passport expire month "Jan"
    And     [Update Profile] User enter the add employer expire day "20"
    Then    [Update Profile] User tap on browse file
    And     [Add Employer] user tap on the add employer
    Then    [Add Employer] User forget employee type and validate  the error message "Please enter Passport"

  @Update @UpdateProfile1
  Scenario: Add new employer without upload document and validate the error message "Please upload document"
    Given   [Login Page] User enter the email "11195"
    When    [Login Page] User enter the password "Password1"
    Then    [Login page] User tap on login button
    Then    [Employees Page] User tap on employees button
    Given   [Add Employer] user tap on new employer button
    And     [Add Employer  User Select the Bank "Kamel Pay"
    Then    [Add Employer] User select the card type "PayD Card"
    Then    [Add Employer] user enter the first name "User"
    And     [Add Employer] user enter the middle name "mid"
    Then    [Add Employer] user enter the last name ""
    And     [Add Employer] user enter the display name ""
    Then    [Add Employer] user tap on gender field
    And     [Add Employer] user select the gender "Male"
    Then    [Add Employer] User enter the year 2017
    And     [Update Profile] User enter the month "Dec"
    Then    [Update Profile] User enter the day "3"
    #And     [Add Employer] user enter the passport no ""
    Then    [Add Employer] user tao the nationality
   # Then    [Add Employer] user select the nationality "Afghanistan"
    And     [Add Employer] user enter the Mol no ""
    Then    [Add Employer] user enter the Employer code ""
    When    [Add Employer] User select the establishment id
    And     [Add Employer] user enter the date of joining year 2017
    And     [Update Profile] User enter the month of joining  "Jan"
    Then    [Add Employer]  User enter the day "10"
    And     [Add Employer] user enter mobile no "971"
    Then    [Add Employer] user enter  alternate mobile no "921234567890"
    Then    [Add Employer] User enter issue year "01-Jan-2015"
    #Then    [Add Employer] User enter issue year 2017
    #And     [Update Profile] User enter the Passport month "June"
    #Then    [Update Profile] User enter issue add employer the day "22"
    And     [Update Profile] User enter the add employer expire year 2030
    Then    [Update Profile] User enter the Passport expire month "Jan"
    And     [Update Profile] User enter the add employer expire day "20"
    Then    [Add Employer]   User enter the Passport no
    And     [Add Employer] user tap on the add employer
    Then    [Add Employer] User forget employee type and validate  the error message "Please upload document"



  Scenario: Add new employer with other bank and without document
    Given   [Login Page] User enter the email "11195"
    When    [Login Page] User enter the password "Password1"
    Then    [Login page] User tap on login button
    Then    [Employees Page] User tap on employees button
    Given   [Add Employer] user tap on new employer button
    And     [Add Employer  User Select the Bank "Other Bank"
    Then    [Add Employer] User Select the bask "Ajman Bank"
    And     [Add Employer] User enter the branch name "Dubai"
    Then    [Add Employer] User enter the iBAN no "CY17002001280000001200527600"
    Then    [Add Employer] user enter the first name "User"
    And     [Add Employer] user enter the middle name "mid"
    Then    [Add Employer] user enter the last name ""
    And     [Add Employer] user enter the display name ""
    Then    [Add Employer] user tap on gender field
    And     [Add Employer] user select the gender "Male"
    Then    [Add Employer] User enter the year 2017
    And     [Update Profile] User enter the month "Dec"
    Then    [Update Profile] User enter the day "3"
    #And     [Add Employer] user enter the passport no ""
    #Then    [Add Employer] user tao the nationality
    Then    [Add Employer] user select the nationality "Pakistan"
    And     [Add Employer] user enter the Mol no ""
    Then    [Add Employer] user enter the Employer code "12345"
    And     [Add Employer] user enter the date of joining year 2017
    And     [Update Profile] User enter the month of joining  "Jan"
    Then    [Add Employer]  User enter the day "10"
    #And     [Add Employer] User enter the Emirates id ""
    And     [Add Employer] user enter mobile no "971"
    Then    [Add Employer] user enter  alternate mobile no "921234567890"
    When    [Add Employer] User select the establishment id
    Then    [Update Profile] User tap on browse file
    And     [Add Employer] user tap on the add employer
    Then    [Add Employer] Validate employees should add successfully "New employee added successfully, Please wait for approval"
    And     [Request Page] User tap on the request button
    Then    [Request Page] User tap on the view button
    And     [Request Page] User verify the mol and passport no and then click the approve button
    Then    [Admin Page] Open the admin tab "http://admin.getthelingo.com"
    And     [Admin Page] User tap on login page
    Then    [Admin Page] User enter the  email "admin@admin.com"
    When    [Admin Page] User enter the Password "12345678"
    And     [Admin Page] User tap on login page
    When    [Admin Page] User tap on client Approvals
    Then    [Admin Page] User enter the company name
    And     [Admin Page] User tap on view button
    And     [Request Page] User verify the mol and passport no and then click the approve button
    Then    [Admin Page] User validate the toast message "Action Successfully"

  Scenario: Add new employer with other bank ""Arab African International Bank""
    Given   [Login Page] User enter the email "ali@mailinator.com"
    When    [Login Page] User enter the password "Password1"
    Then    [Login page] User tap on login button
    Then    [Employees Page] User tap on employees button
    Given   [Add Employer] user tap on new employer button
    Then    [Add Employer] user enter the first name "ali"
    And     [Add Employer] user enter the middle name "raza"
    Then    [Add Employer] user enter the last name "hussain"
    And     [Add Employer] user enter the display name "ali raza hussain"
    Then    [Add Employer] user tap on gender field
    And     [Add Employer] user select the gender "Male"
    Then    [Add Employer] User enter the year 2017
    And     [Update Profile] User enter the month "Dec"
    Then    [Update Profile] User enter the day "3"
    And     [Add Employer] user enter the passport no ""
    #Then    [Add Employer] user tao the nationality
    Then    [Add Employer] user select the nationality "Pakistan"
    And     [Add Employer] user enter the Mol no ""
    Then    [Add Employer] user enter the Employer code "12345"
    And     [Add Employer] user enter the date of joining year 2017
    And     [Update Profile] User enter the month of joining  "Jan"
    Then    [Add Employer]  User enter the day "10"
    And     [Add Employer] User enter the Emirates id ""
    And     [Add Employer] user enter mobile no "92123456789"
    Then    [Add Employer] user enter  alternate mobile no "921234567890"
    And     [Add Employer  User Select the Bank "Other Bank"
    Then    [Add Employer] User Select the bask "Arab African International Bank"
    And     [Add Employer] User enter the branch name "Dubai"
    Then    [Add Employer] User enter the iBAN no "CY17002001280000001200527600"
    Then    [Add Employer] User select the document "Labour Card"
    Then    [Add Employer] User enter issue year 2017
    And     [Update Profile] User enter the month "Jan"
    Then    [Update Profile] User enter issue add employer the day "22"
    And     [Update Profile] User enter the add employer expire year 2030
    Then    [Update Profile] User enter the expire month "Jan"
    And     [Update Profile] User enter the add employer expire day "20"
    Then    [Update Profile] User tap on browse file
    And     [Add Employer] user tap on the add employer
    Then    [Add Employer] Validate employees should add successfully "New employee added successfully, Please wait for approval"

  Scenario: User validate the error message on Mol no  "Please enter Mol Number"
    Given   [Login Page] User enter the email "ali@mailinator.com"
    When    [Login Page] User enter the password "Password1"
    Then    [Login page] User tap on login button
    Then    [Employees Page] User tap on employees button
    Given   [Add Employer] user tap on new employer button
    Then    [Add Employer] user enter the first name "ali"
    And     [Add Employer] user enter the middle name "raza"
    Then    [Add Employer] user enter the last name "hussain"
    And     [Add Employer] user enter the display name "ali raza hussain"
    Then    [Add Employer] user tap on gender field
    And     [Add Employer] user select the gender "Male"
    Then    [Add Employer] User enter the year 2017
    And     [Update Profile] User enter the month "Dec"
    Then    [Update Profile] User enter the day "3"
    And     [Add Employer] user enter the passport no ""
    Then    [Add Employer] user tao the nationality
    Then    [Add Employer] user select the nationality "Afghanistan"
    Then    [Add Employer] user enter the Employer code "12345"
    And     [Add Employer] user enter the date of joining year 2017
    And     [Update Profile] User enter the month of joining  "Jan"
    Then    [Add Employer]  User enter the day "10"
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
    Then    [Add Employer] User validate the error message "Please enter Mol Number"

  Scenario: User validate the error message on first name "Please enter First Name"
    Given   [Login Page] User enter the email "ali@mailinator.com"
    When    [Login Page] User enter the password "Password1"
    Then    [Login page] User tap on login button
    Then    [Employees Page] User tap on employees button
    Given   [Add Employer] user tap on new employer button
    And     [Add Employer] user enter the middle name "raza"
    Then    [Add Employer] user enter the last name "hussain"
    And     [Add Employer] user enter the display name "ali raza hussain"
    Then    [Add Employer] user tap on gender field
    And     [Add Employer] user select the gender "Male"
    Then    [Add Employer] User enter the year 2017
    And     [Update Profile] User enter the month "Dec"
    Then    [Update Profile] User enter the day "3"
    And     [Add Employer] user enter the passport no ""
    Then    [Add Employer] user tao the nationality
    Then    [Add Employer] user select the nationality "Afghanistan"
    And     [Add Employer] user enter the Mol no ""
    Then    [Add Employer] user enter the Employer code "12345"
    And     [Add Employer] user enter the date of joining year 2017
    And     [Update Profile] User enter the month of joining  "Jan"
    Then    [Add Employer]  User enter the day "10"
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
    Then    [Add Employer] user validate the error message on first name "Please enter First Name"


  Scenario: User validate the error message on first name "Please enter Last Name"
    Given   [Login Page] User enter the email "ali@mailinator.com"
    When    [Login Page] User enter the password "Password1"
    Then    [Login page] User tap on login button
    Then    [Employees Page] User tap on employees button
    Given   [Add Employer] user tap on new employer button
    Then    [Add Employer] user enter the first name "ali"
    And     [Add Employer] user enter the middle name "raza"
    And     [Add Employer] user enter the display name "ali raza hussain"
    Then    [Add Employer] user tap on gender field
    And     [Add Employer] user select the gender "Male"
    Then    [Add Employer] User enter the year 2017
    And     [Update Profile] User enter the month "Dec"
    Then    [Update Profile] User enter the day "3"
    And     [Add Employer] user enter the passport no ""
    Then    [Add Employer] user tao the nationality
    Then    [Add Employer] user select the nationality "Afghanistan"
    And     [Add Employer] user enter the Mol no ""
    Then    [Add Employer] user enter the Employer code "12345"
    And     [Add Employer] user enter the date of joining year 2017
    And     [Update Profile] User enter the month of joining  "Jan"
    Then    [Add Employer]  User enter the day "10"
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
    Then    [Add Employer] user validate the error message on last name "Please enter Last Name"

  Scenario: User validate the error message on display name "Please enter Display Name"
    Given   [Login Page] User enter the email "ali@mailinator.com"
    When    [Login Page] User enter the password "Password1"
    Then    [Login page] User tap on login button
    Then    [Employees Page] User tap on employees button
    Given   [Add Employer] user tap on new employer button
    Then    [Add Employer] user enter the first name "ali"
    And     [Add Employer] user enter the middle name "raza"
    Then    [Add Employer] user tap on gender field
    And     [Add Employer] user select the gender "Male"
    Then    [Add Employer] User enter the year 2017
    And     [Update Profile] User enter the month "Dec"
    Then    [Update Profile] User enter the day "3"
    And     [Add Employer] user enter the passport no ""
    Then    [Add Employer] user tao the nationality
    Then    [Add Employer] user select the nationality "Afghanistan"
    And     [Add Employer] user enter the Mol no ""
    Then    [Add Employer] user enter the Employer code "12345"
    And     [Add Employer] user enter the date of joining year 2017
    And     [Update Profile] User enter the month of joining  "Jan"
    Then    [Add Employer]  User enter the day "10"
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
    Then    [Add Employer] user validate the error message on display name "Please enter Display Name"

  Scenario: User validate the error message on display name "Please enter Gender"
    Given   [Login Page] User enter the email "ali@mailinator.com"
    When    [Login Page] User enter the password "Password1"
    Then    [Login page] User tap on login button
    Then    [Employees Page] User tap on employees button
    Given   [Add Employer] user tap on new employer button
    Then    [Add Employer] user enter the first name "ali"
    And     [Add Employer] user enter the middle name "raza"
    Then    [Add Employer] user enter the last name "hussain"
    And     [Add Employer] user enter the display name "ali raza hussain"
    Then    [Add Employer] user tap on gender field
    Then    [Add Employer] User enter the year 2017
    And     [Update Profile] User enter the month "Dec"
    Then    [Update Profile] User enter the day "3"
    And     [Add Employer] user enter the passport no ""
    Then    [Add Employer] user tao the nationality
    Then    [Add Employer] user select the nationality "Afghanistan"
    And     [Add Employer] user enter the Mol no ""
    Then    [Add Employer] user enter the Employer code "12345"
    And     [Add Employer] user enter the date of joining year 2017
    And     [Update Profile] User enter the month of joining  "Jan"
    Then    [Add Employer]  User enter the day "10"
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
    Then    [Add Employer] user validate the error message on gender "Please enter Gender"

  Scenario: User validate the error message on date of birth "Please enter Date Of Birth"
    Given   [Login Page] User enter the email "ali@mailinator.com"
    When    [Login Page] User enter the password "Password1"
    Then    [Login page] User tap on login button
    Then    [Employees Page] User tap on employees button
    Given   [Add Employer] user tap on new employer button
    Then    [Add Employer] user enter the first name "ali"
    And     [Add Employer] user enter the middle name "raza"
    Then    [Add Employer] user enter the last name "hussain"
    And     [Add Employer] user enter the display name "ali raza hussain"
    Then    [Add Employer] user tap on gender field
    And     [Add Employer] user select the gender "Male"
    And     [Add Employer] user enter the passport no ""
    Then    [Add Employer] user tao the nationality
    Then    [Add Employer] user select the nationality "Afghanistan"
    And     [Add Employer] user enter the Mol no ""
    Then    [Add Employer] user enter the Employer code "12345"
    And     [Add Employer] user enter mobile no "92123456789"
    Then    [Add Employer] user enter  alternate mobile no "921234567890"
    Then    [Add Employer] User select the document "Labour Card"
    Then    [Update Profile] User tap on browse file
    And     [Add Employer] user tap on the add employer
    Then    [Add Employer] user validate the error message on date of birth "Please enter Date Of Birth"

  Scenario: User validate the error message on passport no "Please enter Passport Number"
    Given   [Login Page] User enter the email "ali@mailinator.com"
    When    [Login Page] User enter the password "Password1"
    Then    [Login page] User tap on login button
    Then    [Employees Page] User tap on employees button
    Given   [Add Employer] user tap on new employer button
    Then    [Add Employer] user enter the first name "ali"
    And     [Add Employer] user enter the middle name "raza"
    Then    [Add Employer] user enter the last name "hussain"
    And     [Add Employer] user enter the display name "ali raza hussain"
    Then    [Add Employer] user tap on gender field
    And     [Add Employer] user select the gender "Male"
    Then    [Add Employer] User enter the year 2017
    And     [Update Profile] User enter the month "Dec"
    Then    [Update Profile] User enter the day "3"
    Then    [Add Employer] user tao the nationality
    Then    [Add Employer] user select the nationality "Afghanistan"
    And     [Add Employer] user enter the Mol no ""
    Then    [Add Employer] user enter the Employer code "12345"
    And     [Add Employer] user enter the date of joining year 2017
    And     [Update Profile] User enter the month of joining  "Jan"
    Then    [Add Employer]  User enter the day "10"
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
    Then    [Add Employer] user validate the error message on passport no "Please enter Passport Number"

  Scenario: user validate the error message on nationality "Please enter Nationality"
    Given   [Login Page] User enter the email "ali@mailinator.com"
    When    [Login Page] User enter the password "Password1"
    Then    [Login page] User tap on login button
    Then    [Employees Page] User tap on employees button
    Given   [Add Employer] user tap on new employer button
    Then    [Add Employer] user enter the first name "ali"
    And     [Add Employer] user enter the middle name "raza"
    Then    [Add Employer] user enter the last name "hussain"
    And     [Add Employer] user enter the display name "ali raza hussain"
    Then    [Add Employer] user tap on gender field
    And     [Add Employer] user select the gender "Male"
    Then    [Add Employer] User enter the year 2017
    And     [Update Profile] User enter the month "Dec"
    Then    [Update Profile] User enter the day "3"
    And     [Add Employer] user enter the passport no ""
    Then    [Add Employer] user tao the nationality
    And     [Add Employer] user enter the Mol no ""
    Then    [Add Employer] user enter the Employer code "12345"
    And     [Add Employer] user enter the date of joining year 2017
    And     [Update Profile] User enter the month of joining  "Jan"
    Then    [Add Employer]  User enter the day "10"
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
    Then    [Add Employer] user validate the error message on nationality "Please enter Nationality"

  Scenario:  user validate the error message on Mol no "Please enter Mol Number"
    Given   [Login Page] User enter the email "ali@mailinator.com"
    When    [Login Page] User enter the password "Password1"
    Then    [Login page] User tap on login button
    Then    [Employees Page] User tap on employees button
    Given   [Add Employer] user tap on new employer button
    Then    [Add Employer] user enter the first name "ali"
    And     [Add Employer] user enter the middle name "raza"
    Then    [Add Employer] user enter the last name "hussain"
    And     [Add Employer] user enter the display name "ali raza hussain"
    Then    [Add Employer] user tap on gender field
    And     [Add Employer] user select the gender "Male"
    Then    [Add Employer] User enter the year 2017
    And     [Update Profile] User enter the month "Dec"
    Then    [Update Profile] User enter the day "3"
    And     [Add Employer] user enter the passport no ""
    Then    [Add Employer] user tao the nationality
    Then    [Add Employer] user select the nationality "Afghanistan"
    Then    [Add Employer] user enter the Employer code "12345"
    And     [Add Employer] user enter the date of joining year 2017
    And     [Update Profile] User enter the month of joining  "Jan"
    Then    [Add Employer]  User enter the day "10"
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
    Then    [Add Employer] user validate the error message on Mol No "Please enter Mol Number"


  Scenario: user validate the error message on employee No "Please enter Employee Code"
    Given   [Login Page] User enter the email "ali@mailinator.com"
    When    [Login Page] User enter the password "Password1"
    Then    [Login page] User tap on login button
    Then    [Employees Page] User tap on employees button
    Given   [Add Employer] user tap on new employer button
    Then    [Add Employer] user enter the first name "ali"
    And     [Add Employer] user enter the middle name "raza"
    Then    [Add Employer] user enter the last name "hussain"
    And     [Add Employer] user enter the display name "ali raza hussain"
    Then    [Add Employer] user tap on gender field
    And     [Add Employer] user select the gender "Male"
    Then    [Add Employer] User enter the year 2017
    And     [Update Profile] User enter the month "Dec"
    Then    [Update Profile] User enter the day "3"
    And     [Add Employer] user enter the passport no ""
    Then    [Add Employer] user tao the nationality
    Then    [Add Employer] user select the nationality "Afghanistan"
    And     [Add Employer] user enter the Mol no ""
    And     [Add Employer] user enter the date of joining year 2017
    And     [Update Profile] User enter the month of joining  "Jan"
    Then    [Add Employer]  User enter the day "10"
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
    Then    [Add Employer] user validate the error message on employee No "Please enter Employee Code"

  Scenario: user validate the error message on employee No "Please enter Date of joining"
    Given   [Login Page] User enter the email "ali@mailinator.com"
    When    [Login Page] User enter the password "Password1"
    Then    [Login page] User tap on login button
    Then    [Employees Page] User tap on employees button
    Given   [Add Employer] user tap on new employer button
    Then    [Add Employer] user enter the first name "ali"
    And     [Add Employer] user enter the middle name "raza"
    Then    [Add Employer] user enter the last name "hussain"
    And     [Add Employer] user enter the display name "ali raza hussain"
    Then    [Add Employer] user tap on gender field
    And     [Add Employer] user select the gender "Male"
    Then    [Add Employer] User enter the year 2017
    And     [Update Profile] User enter the month "Dec"
    Then    [Update Profile] User enter the day "3"
    And     [Add Employer] user enter the passport no ""
    Then    [Add Employer] user tao the nationality
    Then    [Add Employer] user select the nationality "Afghanistan"
    And     [Add Employer] user enter the Mol no ""
    Then    [Add Employer] user enter the Employer code "12345"
    And     [Add Employer] user enter the date of joining year 2017
    And     [Update Profile] User enter the month of joining  "Jan"
    #Then    [Add Employer]  User enter the day "10"
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
    Then    [Add Employer] user validate the error message on date of joining  "Please enter Date of joining"

  Scenario: Add new employer with other bank validation "Mol No"
    Given   [Login Page] User enter the email "ali@mailinator.com"
    When    [Login Page] User enter the password "Password1"
    Then    [Login page] User tap on login button
    Then    [Employees Page] User tap on employees button
    Given   [Add Employer] user tap on new employer button
    Then    [Add Employer] user enter the first name "K"
    And     [Add Employer] user enter the middle name "L"
    Then    [Add Employer] user enter the last name "KM"
    And     [Add Employer] user enter the display name "KM"
    Then    [Add Employer] user tap on gender field
    And     [Add Employer] user select the gender "Female"
    Then    [Add Employer] User enter the year 2017
    And     [Update Profile] User enter the month "Dec"
    Then    [Update Profile] User enter the day "3"
    And     [Add Employer] user enter the passport no ""
    #Then    [Add Employer] user tao the nationality
    Then    [Add Employer] user select the nationality "Korea, Republic of"
    And     [Add Employer] user enter the Mol no ""
    Then    [Add Employer] user enter the Employer code "12345"
    And     [Add Employer] user enter the date of joining year 2011
    And     [Update Profile] User enter the month of joining  "Jan"
    Then    [Add Employer]  User enter the day "10"
    And     [Add Employer] User enter the Emirates id ""
    And     [Add Employer] user enter mobile no "92123456789"
    Then    [Add Employer] user enter  alternate mobile no "921234567890"
    And     [Add Employer  User Select the Bank "Other Bank"
    Then    [Add Employer] User Select the bask "Arab African International Bank"
    And     [Add Employer] User enter the branch name "Dubai"
    Then    [Add Employer] User enter the iBAN no "CY17002001280000001200527600"
    Then    [Add Employer] User select the document "Labour Card"
    Then    [Add Employer] User enter issue year 2017
    And     [Update Profile] User enter the month "Jan"
    Then    [Update Profile] User enter issue add employer the day "22"
    And     [Update Profile] User enter the add employer expire year 2030
    Then    [Update Profile] User enter the expire month "Jan"
    And     [Update Profile] User enter the add employer expire day "20"
    Then    [Update Profile] User tap on browse file
    And     [Add Employer] user tap on the add employer
    Then    [Add Employer] Validate employees should add successfully "New employee added successfully, Please wait for approval"
    Then    [Add Employer] User tap on eye button
    Then    [Add Employer] Validate the Mol no ""
    Then    [Add Employer] check

  Scenario: Add new employer with other bank validation ""Arab African International Bank""
    Given   [Login Page] User enter the email "ali@mailinator.com"
    When    [Login Page] User enter the password "Password1"
    Then    [Login page] User tap on login button
    Then    [Employees Page] User tap on employees button
    Given   [Add Employer] user tap on new employer button
    Then    [Add Employer] user enter the first name "ali"
    And     [Add Employer] user enter the middle name "raza"
    Then    [Add Employer] user enter the last name "hussain"
    And     [Add Employer] user enter the display name "ali raza hussain"
    Then    [Add Employer] user tap on gender field
    And     [Add Employer] user select the gender "Male"
    Then    [Add Employer] User enter the year 2017
    And     [Update Profile] User enter the month "Dec"
    Then    [Update Profile] User enter the day "3"
    And     [Add Employer] user enter the passport no ""
    #Then    [Add Employer] user tao the nationality
    Then    [Add Employer] user select the nationality "Pakistan"
    And     [Add Employer] user enter the Mol no ""
    Then    [Add Employer] user enter the Employer code "12345"
    And     [Add Employer] user enter the date of joining year 2017
    And     [Update Profile] User enter the month of joining  "Jan"
    Then    [Add Employer]  User enter the day "10"
    And     [Add Employer] User enter the Emirates id ""
    And     [Add Employer] user enter mobile no "92123456789"
    Then    [Add Employer] user enter  alternate mobile no "921234567890"
    And     [Add Employer  User Select the Bank "Other Bank"
    Then    [Add Employer] User Select the bask "Arab African International Bank"
    And     [Add Employer] User enter the branch name "Dubai"
    Then    [Add Employer] User enter the iBAN no "CY17002001280000001200527600"
    Then    [Add Employer] User select the document "Labour Card"
    Then    [Add Employer] User enter issue year 2017
    And     [Update Profile] User enter the month "Jan"
    Then    [Update Profile] User enter issue add employer the day "22"
    And     [Update Profile] User enter the add employer expire year 2030
    Then    [Update Profile] User enter the expire month "Jan"
    And     [Update Profile] User enter the add employer expire day "20"
    Then    [Update Profile] User tap on browse file
    And     [Add Employer] user tap on the add employer
    Then    [Add Employer] Validate employees should add successfully "New employee added successfully, Please wait for approval"
    Then    [Add Employer] User tap on eye button
    Then    [Add Employer] Validate the bank "Arab African International Bank"

    Scenario: User Download a KamelPays Bulk Employees file download
      Given   [Login Page] User enter the email "11793"
      When    [Login Page] User enter the password "Password1"
      Then    [Login page] User tap on login button
      Then    [Employees Page] User tap on employees button
      Then    [Employees Page] User tap on Template button "kamelpayEmployees"

  Scenario: User Download a KamelPays Bulk Employees file download and add employee detail
    #Given   [Login Page] User enter the email "11793"
    #When    [Login Page] User enter the password "Password1"
    #Then    [Login page] User tap on login button
    #Then    [Employees Page] User tap on employees button
    #Then    [Employees Page] User tap on Template button "kamelpayEmployees"
    And     [Employees Page] User enter Employee ID ""


  Scenario Outline: Create Employee
    Given I am on the Employees page
    When I enter Employee ID "<employee_id>"
    And I enter First Name "<first_name>"
    And I enter Last Name "<last_name>"
    And I enter Email "<email>"
    And I enter Mobile "<mobile>"
    And I enter Home Address "<home_address>"
    And I enter Work Address "<work_address>"
    And I click Submit button
    Then Employee should be created successfully

    Examples:
      | employee_id | first_name | last_name | email             | mobile       | home_address           | work_address           |
      | 1001        | John       | Smith     | john.smith@acme.com| 1234567890   | 123 Main St, Anytown   | 456 Oak Ave, Anycity   |
      | 1002        | Jane       | Doe       | jane.doe@acme.com  | 9876543210   | 456 High St, Somewhere | 789 Low Ave, Anyplace |






















