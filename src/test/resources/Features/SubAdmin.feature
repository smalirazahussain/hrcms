@SubAmin
Feature: SubAdmin

  Scenario: User create a Sub Admin
    Given   [Login Page] User enter the email "11413"
    When    [Login Page] User enter the password "123kamelpay321"
    Then    [Login page] User tap on login button
    Given   [Sub Admin] User tap on the sub admin button
    Then    [Sub Admin] User tap on the add sub button
    When    [Sub Admin] User enter name "User"
    Then    [Sub Admin] User enter the email address "user"
    And     [Sub Admin] User enter the password "Password1"
    And     [Sub Admin] User enter the Confirm password ""
    Then    [Sub Admin] Use enter the phone no "56"
    And     [Sub Admin] User tap on the submit button
    Then    [Sub Admin] User land on the "Manage Access" page
    Then    [Sub Admin] User tap on all check boxes
    And     [Sub Admin] User tap on the submit button
    Then    [Admin Page] User validate the toast message "Admin Updated Successfully"


  Scenario: User create a Sub Admin and verify all the heck boxes are selected
    Given   [Login Page] User enter the email "12742"
    When    [Login Page] User enter the password "Password1"
    Then    [Login page] User tap on login button
    Given   [Sub Admin] User tap on the sub admin button
    Then    [Sub Admin] User tap on the add sub button
    When    [Sub Admin] User enter name "User"
    Then    [Sub Admin] User enter the email address "user"
    And     [Sub Admin] User enter the password "Password1"
    And     [Sub Admin] User enter the Confirm password ""
    Then    [Sub Admin] Use enter the phone no "56"
    And     [Sub Admin] User tap on the submit button
    Then    [Sub Admin] User land on the "Manage Access" page
    Then    [Sub Admin] User tap on all check boxes
    And     [Sub Admin] User tap on the submit button
    Then    [Admin Page] User validate the toast message "Admin Updated Successfully"
    And     [Sub Admin] User search the sub admin
    Then    [Sub Admin] User tap on manage access button
    Then    [Sub Admin] User verify all the check boxes are selected

  Scenario: User create a Sub Admin and verify all the heck boxes are selected then login and verify all the module are visible
    Given   [Login Page] User enter the email "12742"
    When    [Login Page] User enter the password "Password1"
    Then    [Login page] User tap on login button
    Given   [Sub Admin] User tap on the sub admin button
    Then    [Sub Admin] User tap on the add sub button
    When    [Sub Admin] User enter name "User"
    Then    [Sub Admin] User enter the email address "user"
    And     [Sub Admin] User enter the password "Password1"
    And     [Sub Admin] User enter the Confirm password ""
    Then    [Sub Admin] Use enter the phone no "56"
    And     [Sub Admin] User tap on the submit button
    Then    [Sub Admin] User land on the "Manage Access" page
    Then    [Sub Admin] User tap on all check boxes
    And     [Sub Admin] User tap on the submit button
    Then    [Admin Page] User validate the toast message "Admin Updated Successfully"
    And     [Sub Admin] User search the sub admin
    Then    [Sub Admin] User tap on manage access button
    Then    [Sub Admin] User verify all the check boxes are selected
    Then    [DesHBoard Page] User tap on the logout from dashboard
    And     [Sub Admin] Use tap on the I am not the Primary User? button
    And     [Sub Admin] Use enter the the company id ""
    And     [Sub Admin] Use enter the team member email
    And     [Sub Admin] Use enter the team member password
    Then    [Login page] User tap on login button
    Then    [Sub Admin] User verify all the module are shown on the side bar

  Scenario: User create a Sub Admin and give him access only to creates employees
    Given   [Login Page] User enter the email "12742"
    When    [Login Page] User enter the password "Password1"
    Then    [Login page] User tap on login button
    Given   [Sub Admin] User tap on the sub admin button
    Then    [Sub Admin] User tap on the add sub button
    When    [Sub Admin] User enter name "User"
    Then    [Sub Admin] User enter the email address "user"
    And     [Sub Admin] User enter the password "Password1"
    And     [Sub Admin] User enter the Confirm password ""
    Then    [Sub Admin] Use enter the phone no "56"
    And     [Sub Admin] User tap on the submit button
    Then    [Sub Admin] User land on the "Manage Access" page
    Then    [Sub Admin] Employer give him access to sub admin to creates single, multiple employees,Deactivate Employees,Download Employees and Request Checker
    And     [Sub Admin] User tap on the submit button
    Then    [Admin Page] User validate the toast message "Admin Updated Successfully"
    And     [Sub Admin] User search the sub admin
    Then    [Sub Admin] User tap on manage access button
    Then    [Sub Admin] User verify check boxes they are selected
    Then    [DesHBoard Page] User tap on the logout from dashboard
    And     [Sub Admin] Use tap on the I am not the Primary User? button
    And     [Sub Admin] Use enter the the company id ""
    And     [Sub Admin] Use enter the team member email
    And     [Sub Admin] Use enter the team member password
    Then    [Login page] User tap on login button
    Then    [Sub Admin] User verify the module are shown on the side bar

  Scenario Outline: User create a Sub Admin and give him access only to creates employees and creates multiple employees
    Given   [Login Page] User enter the email "12742"
    When    [Login Page] User enter the password "Password1"
    Then    [Login page] User tap on login button
    Given   [Sub Admin] User tap on the sub admin button
    Then    [Sub Admin] User tap on the add sub button
    When    [Sub Admin] User enter name "User"
    Then    [Sub Admin] User enter the email address "user"
    And     [Sub Admin] User enter the password "Password1"
    And     [Sub Admin] User enter the Confirm password ""
    Then    [Sub Admin] Use enter the phone no "56"
    And     [Sub Admin] User tap on the submit button
    Then    [Sub Admin] User land on the "Manage Access" page
    Then    [Sub Admin] Employer give him access to sub admin to creates single, multiple employees,Deactivate Employees,Download Employees and Request Checker
    And     [Sub Admin] User tap on the submit button
    Then    [Admin Page] User validate the toast message "Admin Updated Successfully"
    And     [Sub Admin] User search the sub admin
    Then    [Sub Admin] User tap on manage access button
    Then    [Sub Admin] User verify check boxes they are selected
    Then    [DesHBoard Page] User tap on the logout from dashboard
    And     [Sub Admin] Use tap on the I am not the Primary User? button
    And     [Sub Admin] Use enter the the company id ""
    And     [Sub Admin] Use enter the team member email
    And     [Sub Admin] Use enter the team member password
    Then    [Login page] User tap on login button
    Then    [Sub Admin] User verify the module are shown on the side bar
    Then    [Employees Page] User tap on employees button
    And     [Employees Page] User create a multiple data for the employer "<MolNo>""<EmpCode>""<FirstName>""<LastName>""<DisplayName>""<DOB>"" <Gender> "" <Nationality>""<JoiningDate>""<Email>""<MobileNo>""<AlternatePhone>""<HomeAddress>""<HomeState>""<HomePostCode>""<WorkAddress>""<WorkState>""<WorkPostCode>""<PassportNo>""<PassportExpiry>""<EID>""<EIDExpiry>""<EstablishmentId>"
    And     [Employees Page] User upload a bulk employees file ""
    #And     [Employees Page] User verify the message "Successfully Employees File Uploaded"
    Then    [DesHBoard Page] User tap on the logout from dashboard
    Then    [Admin Page] Open the admin tab "https://employer.getthelingo.com"
    Given   [Login Page] User enter the email "12742"
    When    [Login Page] User enter the password "Password1"
    Then    [Login page] User tap on login button
    And     [Request Page] User tap on the request button
    Then    [Request Page] User verify the approval description topic "Employees File Upload"
    And     [Request Page] User verify the approval status topic "Waiting For Your Approval"
    Then    [Request Page] User tap on the view button
    And     [Request Page] User tap on the Approve button
    #And     [Request Page] User verify the approval sent to the admin"Request sent to admin for further approval"
#    And     [Request Page] User verify the approval status topic "Waiting For Your Approval"
#    Then    [Request Page] User tap on the view button
#    And     [Request Page] User tap on the Approve button
    Then    [Admin Page] Open the admin tab "https://admin.getthelingo.com/"
    And     [Admin Page] User tap on login page
    Then    [Admin Page] User enter the  email "admin@admin.com"
    When    [Admin Page] User enter the Password "12345678"
    And     [Admin Page] User tap on login page
    When    [Admin Page] User tap on client Approvals
    #Then    [Admin Page] User enter the company name
    Then    [Admin Page] Sub admin enter the company
    And     [Admin Page] User tap on view button
    Then    [Admin Page] User tap on approve button
    Then    [Admin Page] User Tap om the browse button
    Then    [Admin Page] User select the card type "PayD"
    Then    [Admin Page] User tap No other bank employees in given file
    And     [Admin Page] User Tap on the approve button
    Then    [Admin Page] User verify the notification message "Action Successful"

    Examples:
      |FirstName|MolNo|EmpCode|LastName|DisplayName|DOB|Gender|Nationality|JoiningDate|Email|MobileNo|AlternatePhone|HomeAddress|HomeState|HomePostCode|WorkAddress|WorkState|WorkPostCode|PassportNo|PassportExpiry|EID|EIDExpiry|EstablishmentId|
      |User|Mol12345|1|1|User|05/05/1978|M|BD|05/05/1978|@mailinator.com|971|971|Address|1|00001|2|2|2|Passport|10/05/2029|10000000000|10/05/2029|345676543523342|

  Scenario: User create a Sub Admin and give him access only to creates employees and creates single employee
    Given   [Login Page] User enter the email "12742"
    When    [Login Page] User enter the password "Password1"
    Then    [Login page] User tap on login button
    Given   [Sub Admin] User tap on the sub admin button
    Then    [Sub Admin] User tap on the add sub button
    When    [Sub Admin] User enter name "User"
    Then    [Sub Admin] User enter the email address "user"
    And     [Sub Admin] User enter the password "Password1"
    And     [Sub Admin] User enter the Confirm password ""
    Then    [Sub Admin] Use enter the phone no "56"
    And     [Sub Admin] User tap on the submit button
    Then    [Sub Admin] User land on the "Manage Access" page
    Then    [Sub Admin] Employer give him access to sub admin to creates single, multiple employees,Deactivate Employees,Download Employees and Request Checker
    And     [Sub Admin] User tap on the submit button
    Then    [Admin Page] User validate the toast message "Admin Updated Successfully"
    And     [Sub Admin] User search the sub admin
    Then    [Sub Admin] User tap on manage access button
    Then    [Sub Admin] User verify check boxes they are selected
    Then    [DesHBoard Page] User tap on the logout from dashboard
    And     [Sub Admin] Use tap on the I am not the Primary User? button
    And     [Sub Admin] Use enter the the company id ""
    And     [Sub Admin] Use enter the team member email
    And     [Sub Admin] Use enter the team member password
    Then    [Login page] User tap on login button
    Then    [Sub Admin] User verify the module are shown on the side bar
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
    Then    [Add Employer] user tao the nationality
    And     [Add Employer] user enter the Mol no ""
    Then    [Add Employer] user enter the Employer code ""
    When    [Add Employer] Sub admin select the establishment id
    And     [Add Employer] user enter the date of joining year 2017
    And     [Update Profile] User enter the month of joining  "Jan"
    Then    [Add Employer]  User enter the day "10"
    And     [Add Employer] user enter mobile no "56"
    Then    [Add Employer] user enter  alternate mobile no ""
    And     [Add Employer] User tap on the Add More Documents button
    Then    [Add Employer] User select the document "Passport"
    Then    [Add Employer] User enter issue year "01-Jan-2015"
    #Then    [Add Employer] User enter issue year 2017
    #And     [Update Profile] User enter the Passport month "June"
    #Then    [Update Profile] User enter issue add employer the day "22"
    And     [Update Profile] User enter the add employer expire year 2030
    Then    [Update Profile] User enter the Passport expire month "Dec"
    And     [Update Profile] User enter the add employer expire day "20"
    Then    [Add Employer]   User enter the Passport no
    Then    [Update Profile] User tap on browse file
    And     [Add Employer] user tap on the add employer
    Then    [Add Employer] User Validate the employee notification message "New employee added successfully, Please wait for approval"
    Then    [DesHBoard Page] User tap on the logout from dashboard
    Then    [Admin Page] Open the admin tab "https://employer.getthelingo.com"
    Given   [Login Page] User enter the email "12742"
    When    [Login Page] User enter the password "Password1"
    Then    [Login page] User tap on login button
    And     [Request Page] User tap on the request button
    Then    [Request Page] User verify the approval description topic "Employees File Upload"
    And     [Request Page] User verify the approval status topic "Waiting For Your Approval"
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
    Then    [Admin Page] User validate the toast message "Action Successful"

  Scenario: User create a Sub Admin and give him access only to creates employees and update phone No
    Given   [Login Page] User enter the email "12742"
    When    [Login Page] User enter the password "Password1"
    Then    [Login page] User tap on login button
    Given   [Sub Admin] User tap on the sub admin button
    Then    [Sub Admin] User tap on the add sub button
    When    [Sub Admin] User enter name "User"
    Then    [Sub Admin] User enter the email address "user"
    And     [Sub Admin] User enter the password "Password1"
    And     [Sub Admin] User enter the Confirm password ""
    Then    [Sub Admin] Use enter the phone no "56"
    And     [Sub Admin] User tap on the submit button
    Then    [Sub Admin] User land on the "Manage Access" page
    Then    [Sub Admin] Employer give him access to sub admin to creates single, multiple employees,Deactivate Employees,Download Employees and Request Checker
    And     [Sub Admin] User tap on the submit button
    Then    [Admin Page] User validate the toast message "Admin Updated Successfully"
    And     [Sub Admin] User search the sub admin
    Then    [Sub Admin] User tap on manage access button
    Then    [Sub Admin] User verify check boxes they are selected
    Then    [DesHBoard Page] User tap on the logout from dashboard
    And     [Sub Admin] Use tap on the I am not the Primary User? button
    And     [Sub Admin] Use enter the the company id ""
    And     [Sub Admin] Use enter the team member email
    And     [Sub Admin] Use enter the team member password
    Then    [Login page] User tap on login button
    Then    [Sub Admin] User verify the module are shown on the side bar
    Then    [Employees Page] User tap on employees button
    Then    [Sub Admin] User employee is active then click on eye button




  Scenario: User create a Sub Admin and then login his credential and verify all the module are visible
    Given   [Login Page] User enter the email "12742"
    When    [Login Page] User enter the password "Password1"
    Then    [Login page] User tap on login button
    Given   [Sub Admin] User tap on the sub admin button
    Then    [Sub Admin] User tap on the add sub button
    When    [Sub Admin] User enter name "User"
    Then    [Sub Admin] User enter the email address "user"
    And     [Sub Admin] User enter the password "Password1"
    And     [Sub Admin] User enter the Confirm password ""
    Then    [Sub Admin] Use enter the phone no "56"
    And     [Sub Admin] User tap on the submit button
    Then    [Sub Admin] User land on the "Manage Access" page
    Then    [Sub Admin] User tap on all check boxes
    And     [Sub Admin] User tap on the submit button
    Then    [Admin Page] User validate the toast message "Admin Updated Successfully"
    And     [Sub Admin] User search the sub admin
    Then    [Sub Admin] User tap on manage access button
    Then    [Sub Admin] User verify all the check boxes are selected

  Scenario: USer create a Sub Admin without enter a email
    Given   [Login Page] User enter the email "kamelpay469437@kamelpay.com"
    When    [Login Page] User enter the password "123kamelpay321"
    Then    [Login page] User tap on login button
    Given   [Sub Admin] User tap on the sub admin button
    Then    [Sub Admin] User tap on the add sub button
    When    [Sub Admin] User enter name "ali raza"
    And     [Sub Admin] User enter the password "Password1"
    Then    [Sub Admin] Use enter the phone no ""
    And     [Sub Admin] User select the Role "HR"
    Then    [Sub Admin] Use tap on the Add sub admin
    And     [Sub Admin] User should validate the error message on the email "Please enter your Email."

  Scenario: USer create a Sub Admin without name
    Given   [Login Page] User enter the email "kamelpay469437@kamelpay.com"
    When    [Login Page] User enter the password "123kamelpay321"
    Then    [Login page] User tap on login button
    Given   [Sub Admin] User tap on the sub admin button
    Then    [Sub Admin] User tap on the add sub button
    Then    [Sub Admin] User enter the email address "ali"
    And     [Sub Admin] User enter the password "Password1"
    Then    [Sub Admin] Use enter the phone no ""
    And     [Sub Admin] User select the Role "HR"
    Then    [Sub Admin] Use tap on the Add sub admin
    And     [Sub Admin] User should validate the error message on the email "Please enter Company name"

  Scenario: USer create a Sub Admin without password
    Given   [Login Page] User enter the email "kamelpay469437@kamelpay.com"
    When    [Login Page] User enter the password "123kamelpay321"
    Then    [Login page] User tap on login button
    Given   [Sub Admin] User tap on the sub admin button
    Then    [Sub Admin] User tap on the add sub button
    When    [Sub Admin] User enter name "ali raza"
    Then    [Sub Admin] User enter the email address "ali"
    Then    [Sub Admin] Use enter the phone no ""
    And     [Sub Admin] User select the Role "HR"
    Then    [Sub Admin] Use tap on the Add sub admin
    And     [Sub Admin] User should validate the error message on the email "Password is required"

  Scenario: USer create a Sub Admin without phone no
    Given   [Login Page] User enter the email "kamelpay469437@kamelpay.com"
    When    [Login Page] User enter the password "123kamelpay321"
    Then    [Login page] User tap on login button
    Given   [Sub Admin] User tap on the sub admin button
    Then    [Sub Admin] User tap on the add sub button
    When    [Sub Admin] User enter name "ali raza"
    Then    [Sub Admin] User enter the email address "ali"
    And     [Sub Admin] User enter the password "Password1"
    And     [Sub Admin] User select the Role "HR"
    Then    [Sub Admin] Use tap on the Add sub admin
    And     [Sub Admin] User should validate the error message on the email "Please enter Phone Number"

  Scenario: USer create a Sub Admin without select role
    Given   [Login Page] User enter the email "kamelpay469437@kamelpay.com"
    When    [Login Page] User enter the password "123kamelpay321"
    Then    [Login page] User tap on login button
    Given   [Sub Admin] User tap on the sub admin button
    Then    [Sub Admin] User tap on the add sub button
    When    [Sub Admin] User enter name "ali raza"
    Then    [Sub Admin] User enter the email address "ali"
    And     [Sub Admin] User enter the password "Password1"
    Then    [Sub Admin] Use enter the phone no ""
    Then    [Sub Admin] Use tap on the Add sub admin
    And     [Sub Admin] User should validate the error message on the email "Please select a role"
















