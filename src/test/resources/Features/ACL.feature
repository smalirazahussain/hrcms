@UpdateProfile
Feature: ACL

  Scenario: User approve by admin
    Given   [Login Page] User enter the email ""
    When    [Login Page] User enter the password ""
    Then    [Login page] User tap on login button
    Given   [Sub Admin] User tap on the sub admin button
    When    [Sub Admin] User tap on the search button
    When    [Sub Admin] User tap on the manage access button
    Then    [Sub Admin] User land on the "Manage Access" page
    Then    [ACL Page] first user deselect the checkbox first
    When    [Sub Admin] User tap on the search button
    When    [Sub Admin] User tap on the manage access button
    Then    [Sub Admin] Employer give him access to sub admin to creates single, multiple employees,Deactivate Employees,Download Employees and Request Checker
    And     [Sub Admin] User tap on the submit button
    Then    [Admin Page] User validate the toast message "Admin Updated Successfully"
    Then    [Sub Admin] Employer give him access to sub admin to creates single, multiple employees,Deactivate Employees,Download Employees and Request Checker
    When    [Sub Admin] User tap on the manage access button
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
    #And     [Add Employer] user enter the passport no ""
    Then    [Add Employer] user tao the nationality
    #And     [Add Employer] user tao the Add New Establishment
   # Then    [Add Employer] user select the nationality "Afghanistan"
    And     [Add Employer] user enter the Mol no ""
    Then    [Add Employer] user enter the Employer code ""
    When    [Add Employer] User select the establishment id
    Then    [Add Employer] Sub admin select the establishment id
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
    Then    [Add Employer] User navigate to the employer portal
    Given   [Login Page] User enter the email "12742"
    When    [Login Page] User enter the password "Password1"
    Then    [Login page] User tap on login button
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
    Then    [Admin Page] User validate the toast message "Action Successful"
    Then    [Admin Page] Open the admin tab "https://employer.getthelingo.com/"
    Then    [DesHBoard Page] User tap on the logout from dashboard
    And     [Sub Admin] Use tap on the I am not the Primary User? button
    And     [Sub Admin] Use enter the the company id ""
    And     [Sub Admin] Use enter the team member email
    And     [Sub Admin] Use enter the team member password
    Then    [Login page] User tap on login button
    Then    [Sub Admin] User verify the module are shown on the side bar
    Then    [Employees Page] User tap on employees button
    And     [Employees Page] User tap on the employee type
    Then    [Sub Admin] User employee is active then click on checkbox button
    Then    [Sub Admin] User tap on the Edit Personal Details button
    Then    [Sub Admin] User tap on the Edit Mol Est Id Details button
    Then    [Sub Admin] User enter the "Mol" no
    Then    [Sub Admin] User select the company establishment id no
    Then    [Admin Page] User validate the toast message "Request generated successfully"
    Then    [DesHBoard Page] User tap on the logout from dashboard
    Then    [Add Employer] User navigate to the employer portal
    Given   [Login Page] User enter the email "12742"
    When    [Login Page] User enter the password "Password1"
    Then    [Login page] User tap on login button
    And     [Request Page] User tap on the request button
    Then    [Request Page] User tap on the view button
    And     [Request Page] User verify the mol and passport no and then click the approve button
    Then    [Admin Page] Open the admin tab "http://admin.getthelingo.com"
    When    [Admin Page] User tap on client Approvals
    Then    [Admin Page] Sub admin enter the company in admin portal
    And     [Admin Page] User tap on view button
    And     [Request Page] User verify the mol and passport no and then click the approve button
    Then    [Admin Page] User validate the toast message "Action Successful"





