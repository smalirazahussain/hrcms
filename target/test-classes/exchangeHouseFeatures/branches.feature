@AddEmployer
Feature: Branches

  @Update @UpdateProfile1
  Scenario: User add new branch to the Head office add approve by itself and admin
    Given  [Login Head Office Page] User enter the URL "https://exchangehouse.getthelingo.com/"
    When   [Login Head Office Page] User enter email id "dubaiexchange@mailinator.com"
    Then   [Login Head Office Page] User enter the Password "Password1"
    And    [Login Head Office Page] User tap on the login button
    #Then   [Dashboard Head Office Page] User verify to toast message to "Successfully Login"
    And    [Dashboard Head Office Page] User tap on the branches button
    Then   [Branch Head Office Page] User tap on the add branch button
    When   [Branch Head Office Page] User enter branch name "Branch"
    When   [Branch Head Office Page] User enter the branch location "dubai"
    Then   [Branch Head Office Page] User enter the email address "UKbranch"
    And    [Branch Head Office Page] User enter the Password "Password1"
    When   [Branch Head Office Page] User enter the confirm Password "Password1"
    And    [Branch Head Office Page] User enter branch phone no "971"
    Then   [Branch Head Office Page] User tap on add branch button
    And    [Branch Head Office Page] User validate toast message "Branch has been created and has been sent for further approval."
    Then   [OnBoard Approval Head Office Page] User tap onboard approval
    And    [OnBoard Approval Head Office Page] User tap on view button
    Then   [Admin Page] Open the admin tab "https://admin.getthelingo.com"
    Then   [Admin Page] User enter the  email "admin@admin.com"
    When   [Admin Page] User enter the Password "12345678"
    And    [Admin Page] User tap on login page
    When   [Admin Page] User tap on onboard Approvals
    Then   [Admin Page] User tap on Exchange House Clients button
    Then   [Admin Page] User select the exchange house ""
    And    [Admin Page] User tap on view button
    #And    [OnBoard Approval Head Office Page] User tap on view button
    Then   [Admin Page] Admin verification the branch and then approve

  Scenario Outline: Exchange house create a branch and then create multiple Employee in exchange house branch
    Given  [Login Head Office Page] User enter the URL "https://exchangehouse.getthelingo.com/"
    When   [Login Head Office Page] User enter email id "dubaiexchange@mailinator.com"
    Then   [Login Head Office Page] User enter the Password "Password1"
    And    [Login Head Office Page] User tap on the login button
    #Then   [Dashboard Head Office Page] User verify to toast message to "Successfully Login"
    And    [Dashboard Head Office Page] User tap on the branches button
    Then   [Branch Head Office Page] User tap on the add branch button
    When   [Branch Head Office Page] User enter branch name "Branch"
    When   [Branch Head Office Page] User enter the branch location "dubai"
    Then   [Branch Head Office Page] User enter the email address "UKbranch"
    And    [Branch Head Office Page] User enter the Password "Password1"
    When   [Branch Head Office Page] User enter the confirm Password "Password1"
    And    [Branch Head Office Page] User enter branch phone no "971"
    Then   [Branch Head Office Page] User tap on add branch button
    And    [Branch Head Office Page] User validate toast message "Branch has been created and has been sent for further approval."
    Then   [OnBoard Approval Head Office Page] User tap onboard approval
    And    [OnBoard Approval Head Office Page] User tap on view button
    Then   [Admin Page] Open the admin tab "https://admin.getthelingo.com"
    Then   [Admin Page] User enter the  email "admin@admin.com"
    When   [Admin Page] User enter the Password "12345678"
    And    [Admin Page] User tap on login page
    When   [Admin Page] User tap on onboard Approvals
    Then   [Admin Page] User tap on Exchange House Clients button
    Then   [Admin Page] User select the exchange house ""
    And    [Admin Page] User tap on view button
    #And    [OnBoard Approval Head Office Page] User tap on view button
    Then   [Admin Page] Admin verification the branch and then approve
    Given  [Login Head Office Page] User enter the URL "http://83.111.40.2:8087/#/login"
    Then   [Web Portal Page] User enter the user name "admin"
    Then   [Web Portal Page] User enter the Password "admin"
    Then   [Web Portal Page] User tap on the login button
    When   [Web Portal Page] User tap on the side manu "Company Administration"
    When   [Web Portal Page] User tap on the side manu "Manage Company"
    When   [Web Portal Page] User enter the branch name ""
    Then   [Web Portal Page] User tap edit button
    When   [Web Portal Page] User tap on the employer product
    Then   [Web Portal Page] User select the product ""
    Then   [Web Portal Page] User select the effective from date "01052022"
    Then   [Web Portal Page] User select the effective to date "01052026"
    Then   [Web Portal Page] User tap on add button
    Then   [Web Portal Page] User tap on Update employer button
    Given  [Login Head Office Page] User enter the URL "https://exchangehouse.getthelingo.com/"
    #When   [Login Head Office Page] User enter email id "dubaiexchange@mailinator.com"
    #Then   [Login Head Office Page] User enter the Password "123kamelpay321"
    Then    [Exchange House Establishments Page] User tap on establishments module
    Then    [Exchange House Establishments Page] User enter branch name
    Then    [Exchange House Manage Employees Page] User tap on Manage employees button
    And     [Employees Page] User create a multiple data for the employer "<MolNo>""<EmpCode>""<FirstName>""<LastName>""<DisplayName>""<DOB>"" <Gender> "" <Nationality>""<JoiningDate>""<Email>""<MobileNo>""<AlternatePhone>""<HomeAddress>""<HomeState>""<HomePostCode>""<WorkAddress>""<WorkState>""<WorkPostCode>""<PassportNo>""<PassportExpiry>""<EID>""<EIDExpiry>""<EstablishmentId>"
    And     [Employees Page] User upload a bulk employees file ""
    #And     [Request Page] User tap on the request button
    Then    [Request Page] User tap on the view button
    And     [Request Page] User tap on the Approve button
    Then    [Admin Page] Open the admin tab "https://admin.getthelingo.com/"
    When    [Admin Page] User tap on Exchange house client Approvals
    And     [Admin Page] User tap on view button
    Then    [Admin Page] User tap on approve button
    Then    [Admin Page] User Tap om the exchange house browse button
    #Then    [Admin Page] User tap No other bank employees in given file
    And     [Admin Page] User Tap on the approve button
    Then    [Admin Page] User verify the notification message "Action Successfully"

    Examples:
      |FirstName|MolNo|EmpCode|LastName|DisplayName|DOB|Gender|Nationality|JoiningDate|Email|MobileNo|AlternatePhone|HomeAddress|HomeState|HomePostCode|WorkAddress|WorkState|WorkPostCode|PassportNo|PassportExpiry|EID|EIDExpiry|EstablishmentId|
      |User|Mol12345|1|1|User|05/05/1978|M|BD|05/05/1978|@mailinator.com|971|971|Address|1|00001|2|2|2|Passport|10/05/2029|10000000000|10/05/2029||


  Scenario: Web
    Given  [Login Head Office Page] User enter the URL "https://exchangehouse.getthelingo.com/"
    When   [Login Head Office Page] User enter email id "dubaiexchange@mailinator.com"
    Then   [Login Head Office Page] User enter the Password "123kamelpay321"
    Then    [Exchange House Establishments Page] User tap on establishments module
    Then    [Exchange House Establishments Page] User enter branch name "Branch"
    Given  [Login Head Office Page] User enter the URL "http://20.203.21.188/#/login"
    Then   [Web Portal Page] User enter the user name "admin"
    Then   [Web Portal Page] User enter the Password "admin"
    Then   [Web Portal Page] User tap on the login button
    When   [Web Portal Page] User tap on the side manu "Company Administration"
    When   [Web Portal Page] User tap on the side manu "Manage Company"
    When   [Web Portal Page] User enter the branch name ""
    Then   [Web Portal Page] User tap edit button
    When   [Web Portal Page] User tap on the employer product
    Then   [Web Portal Page] User select the product "Dubai Exchange"
    Then   [Web Portal Page] User select the effective from date "01052022"
    Then   [Web Portal Page] User select the effective to date "01052026"
    Then   [Web Portal Page] User tap on add button
    Then   [Web Portal Page] User tap on Update employer button



















