@PendingBadge
Feature: PendingBadge

  @PendingBadge
  Scenario: User Create a employee onboard approval check the Pending Badge
    Given   [Login Page] User enter the email "12205"
    When    [Login Page] User enter the password "Password2"
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
    And     [Request Page] User verify the "Pending" Badge display on the request module
    And     [Request Page] User tap on the request button
    Then    [Request Page] User tap on the view button
    And     [Request Page] User verify the mol and passport no and then click the approve button
    And     [Request Page] User verify the "Pending" Badge not display if request resolve on the client sde

  Scenario Outline: When a user creates multiple employee approvals, a 'Pending' badge should be displayed. Once the approvals are resolved, the 'Pending' badge should be hidden
    Given   [Login Page] User enter the email "12205"
    When    [Login Page] User enter the password "Password2"
    Then    [Login page] User tap on login button
    Then    [Employees Page] User tap on employees button
    And     [Employees Page] User create a multiple data for the employer "<MolNo>""<EmpCode>""<FirstName>""<LastName>""<DisplayName>""<DOB>"" <Gender> "" <Nationality>""<JoiningDate>""<Email>""<MobileNo>""<AlternatePhone>""<HomeAddress>""<HomeState>""<HomePostCode>""<WorkAddress>""<WorkState>""<WorkPostCode>""<PassportNo>""<PassportExpiry>""<EID>""<EIDExpiry>""<EstablishmentId>"
    And     [Employees Page] User upload a bulk employees file ""
    And     [Request Page] User verify the "Pending" Badge display on the request module
    And     [Request Page] User tap on the request button
    Then    [Request Page] User tap on the view button
    And     [Request Page] User tap on the Approve button
    And     [Request Page] User verify the "Pending" Badge not display if request resolve on the client sde
    Examples:
      |FirstName|MolNo|EmpCode|LastName|DisplayName|DOB|Gender|Nationality|JoiningDate|Email|MobileNo|AlternatePhone|HomeAddress|HomeState|HomePostCode|WorkAddress|WorkState|WorkPostCode|PassportNo|PassportExpiry|EID|EIDExpiry|EstablishmentId|
      |User|Mol12345|1|1|User|05/05/1978|M|BD|05/05/1978|@mailinator.com|971|971|Address|1|00001|2|2|2|Passport|10/05/2029|10000000000|10/05/2029|7754116879536638|


  Scenario: When a user adds a new employer with another bank, a 'Pending' badge should be displayed. Once the approval is resolved, the 'Pending' badge should be hidden.
    Given   [Login Page] User enter the email "12205"
    When    [Login Page] User enter the password "Password2"
    Then    [Login page] User tap on login button
    Then    [Employees Page] User tap on employees button
    Given   [Add Employer] user tap on new employer button
    And     [Add Employer  User Select the Bank "Other Bank"
    Then    [Add Employer] User Select the bask "Ajman Bank"
    And     [Add Employer] User enter the branch name "Dubai"
    Then    [Add Employer] User enter the iBAN no "CY17"
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
    And     [Request Page] User verify the "Pending" Badge display on the request module
    And     [Request Page] User tap on the request button
    Then    [Request Page] User tap on the view button
    And     [Request Page] User verify the mol and passport no and then click the approve button
    And     [Request Page] User verify the "Pending" Badge not display if request resolve on the client sde

  Scenario: Add salary
    Given   [Login Page] User enter the email "12528"
    When    [Login Page] User enter the password "Password1"
    Then    [Login page] User tap on login button
    And     [Process Salaries DepositSlip Page] User Tap on Process Salaries Deposit Slip
    When    [Process Salaries DepositSlip Page] User enter company name and download the salary template
    Then    [Process Salaries DepositSlip Page] User select the month and then upload the process file "2012-04"
    And     [Process Salaries DepositSlip Page] User tap on browse file and upload a salary process file
    Then    [Process Salaries DepositSlip Page] User tap on submit button
    And     [Request Page] User verify the "Pending" Badge display on the request module
    And     [Request Page] User tap on the request button
    Then    [Request Page] User tap on the view button
    And     [Request Page] User tap on the Approve button
    And     [Request Page] User verify the "Pending" Badge not display if request resolve on the client sde


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
      Given   [Login Page] User enter the email "12202"
      When    [Login Page] User enter the password "Password1"
      Then    [Login page] User tap on login button
      Then    [Employees Page] User tap on employees button
      Then    [Employees Page] User tap on Template button "kamelpayEmployees"

  Scenario: User Download a KamelPays Bulk Employees file download and add employee detail
    Given   [Login Page] User enter the email "11793"
    When    [Login Page] User enter the password "Password1"
    Then    [Login page] User tap on login button
    Then    [Employees Page] User tap on employees button
    Then    [Employees Page] User tap on Template button "kamelpayEmployees"
    And     [Employees Page] User enter Employee ID ""

 Scenario Outline: User create a excel and enter the multiple employee data and then approve the admin side
   Given   [Login Page] User enter the email "11793"
   When    [Login Page] User enter the password "Password1"
   Then    [Login page] User tap on login button
   Then    [Employees Page] User tap on employees button
   #And     [Employees Page] User create a multiple data for the employer "<MolNo>" "<EmpCode>" "<FirstName>" "<LastName>" "<DisplayName>" "<DOB>" " <Gender> "   " <Nationality>" "<JoiningDate>"   "<Email>" "<MobileNo>"   "<AlternatePhone>" "<HomeAddress>" "<HomeState>" "<HomePostCode>"  "<WorkAddress>" "<WorkState>" "<WorkPostCode>" "<PassportNo>"     "<PassportExpiry>" "<EID>" "<EIDExpiry>" "<EstablishmentId>"
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
   Then    [Admin Page] User select the card type "Centiv"
   Then    [Admin Page] User tap No other bank employees in given file
   And     [Admin Page] User Tap on the approve button

   Examples:
   #  | FirstName | MolNo             | EmpCode | LastName | DisplayName | DOB         | Gender | Nationality | JoiningDate    | Email          | MobileNo      | AlternatePhone | HomeAddress | HomeState | HomePostCode | WorkAddress | WorkState | WorkPostCode | PassportNo       | PassportExpiry | EID              | EIDExpiry      | EstablishmentId                |
    # | User     | 098765456789oiuytrt | 2123    | 1    | User1            | 05/05/1978 | M      | PK          | 05/05/1978    | user1@gmail.com| 97100011111 | 97100011111    | Address1    | State1    | 00001        | WorkAddress1 | State2    | 00002        | PassportNumber1  | 10/05/2029     | EIDNumber1       | 10/05/2029     | 8711258059247301               |
     | User2     | jnvnaskfb23459cvq27 | 5678    | 2    | User2            | 06/06/1980 | F      | US          | 06/06/1980    | user2@gmail.com| 97100022222 | 97100022222    | Address2    | State2    | 00002        | WorkAddress2 | State3    | 00003        | PassportNumber2  | 15/05/2030     | EIDNumber2       | 15/05/2030     | EstablishmentId2               |

  Scenario Outline: Create multiple Employee
    Given   [Login Page] User enter the email "12205"
    When    [Login Page] User enter the password "Password2"
    Then    [Login page] User tap on login button
    Then    [Employees Page] User tap on employees button
    And     [Employees Page] User create a multiple data for the employer "<MolNo>""<EmpCode>""<FirstName>""<LastName>""<DisplayName>""<DOB>"" <Gender> "" <Nationality>""<JoiningDate>""<Email>""<MobileNo>""<AlternatePhone>""<HomeAddress>""<HomeState>""<HomePostCode>""<WorkAddress>""<WorkState>""<WorkPostCode>""<PassportNo>""<PassportExpiry>""<EID>""<EIDExpiry>""<EstablishmentId>"
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

























