@Login
Feature: LinkedEstablishmentID

  Scenario: Add link establishment id
    Given   [Login Page] User enter the email "11834"
    When    [Login Page] User enter the password "Password1"
    Then    [Login page] User tap on login button
    Then    [Profile Page] User tap oon the profile button
    And     [Link EstablishmentID Page] User tap on add Establishment button
    When    [Sign Up] User enter the name "hikma"
    Then    [Update Profile] User enter the establishment id "000000120128"
    Then    [Update Profile] User enter the year 2017
    And     [Update Profile] User enter the month "Dec"
    Then    [Update Profile] User enter the day "3"
    And     [Link EstablishmentID Page] User enter the expire year 2030
    Then    [Update Profile] User enter the expire month "Oct"
    And     [Update Profile] User enter the expire day "31"
    Then    [Update Profile] User tap on browse file
    And     [Update Profile] User enter the submit button
    Then    [Link EstablishmentID Page] User verify the notification message "Approval is processed for further actions"
    And     [Request Page] User tap on the request button
    Then    [Request Page] User tap on the view button
    And     [Request Page] User verify the establishment id in employer and then click the approval button
    Then    [Admin Page] Open the admin tab "http://admin.getthelingo.com"
    And     [Admin Page] User tap on login page
    Then    [Admin Page] User enter the  email "admin@admin.com"
    When    [Admin Page] User enter the Password "12345678"
    And     [Admin Page] User tap on login page
    When    [Admin Page] User tap on client Approvals
    Then    [Admin Page] User enter the company name
    And     [Admin Page] User tap on view button
    And     [Request Page] User verify the establishment id and then click the approval button

  @Update @UpdateProfile1
  Scenario: Add new employee with establishment id
    Given   [Login Page] User enter the email "12643"
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
    And     [Add Employer] User tap on the Add More Documents button
    Then    [Add Employer] User select the document "Passport"
    Then    [Add Employer] User enter issue year "01-Jan-2015"
    #Then    [Add Employer] User enter issue year 2017
    #And     [Update Profile] User enter the Passport month "June"
    #Then    [Update Profile] User enter issue add employer the day "22"
    And     [Update Profile] User enter the add employer expire year 2030
    Then    [Update Profile] User enter the Passport expire month "May"
    And     [Update Profile] User enter the add employer expire day "20"
    Then    [Add Employer]   User enter the Passport no
    Then    [Update Profile] User tap on browse file
    And     [Add Employer] user tao the Add New Establishment
   # When    [Add Employer] User select the establishment id
    When    [Add Employer] User enter the establishment id
    And     [Add Employer] user tap on the add employer
    Then    [Add Employer] User Validate the employee notification message "New employee added successfully, Please wait for approval"
    And     [Request Page] User tap on the request button
    Then    [Request Page] User tap on the view button
    And     [Request Page] User verify the mol and passport no and then click the approve button
    Then    [Request Page] User tap on the view button
    #And     [Request Page] User verify the mol and passport no and then click the approve button
    Then    [Request Page] User verify the establishment id and then click the approve button
    Then    [Admin Page] Open the admin tab "http://admin.getthelingo.com"
    And     [Admin Page] User tap on login page
    Then    [Admin Page] User enter the  email "admin@admin.com"
    When    [Admin Page] User enter the Password "12345678"
    And     [Admin Page] User tap on login page
    When    [Admin Page] User tap on client Approvals
    Then    [Admin Page] User enter the company name
    And     [Admin Page] User tap on establishment id view button
    Then    [Request Page] User verify the establishment id and then click the approve button
    And     [Admin Page] User tap on view button
    And     [Request Page] User verify the mol and passport no and then click the approve button
    Then    [Admin Page] User validate the toast message "Action Successful"


