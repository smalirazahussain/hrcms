@Branches
Feature: Branches

  @Branches @Branches1
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
    Given  [Login Head Office Page] User enter the URL "http://10.10.5.100:8004"
    Then   [Web Portal Page] User enter the user name "admin"
    Then   [Web Portal Page] User enter the Password "Password1"
    Then   [Web Portal Page] User tap on the login button
    When   [Web Portal Page] User tap on the side manu "Corporate"
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


  Scenario: ExchangeHouse creates a statement request for approval by the branch employee, then the request is approved and further approved by the admin
    Given  [Login Head Office Page] User enter the URL "https://exchangehouse.getthelingo.com/"
    When   [Login Head Office Page] User enter email id "dubaiexchange@kamelpay.com"
    Then   [Login Head Office Page] User enter the Password "Password1"
    And    [Login Head Office Page] User tap on the login button
    #Then   [Dashboard Head Office Page] User verify to toast message to "Successfully Login"
    And    [Dashboard Head Office Page] User tap on the branches button
    When   [Branch Head Office Page] User search the branch "Branch90107"
    Then   [Branch Head Office Page] User tap on the view employees button
    Then   [Branch Head Office Page] User tap on the eye button
    When   [Branch Head Office Page] User tap on the statement request button
    And    [Branch Head Office Page] User validate the message "This statement request has 15 AED charges, do you want to continue?" abd click ont the continue button
    Then   [Branch Head Office Page] User validate the top-up message "Approval is processed for further actions"
    Then   [OnBoard Approval Head Office Page] User tap onboard approval
    Then   [OnBoard Approval Head Office Page] User tap onboard approval for statement request
    #And    [OnBoard Approval Head Office Page] User tap on view button
    And    [OnBoard Approval Head Office Page] User tap on view button and approve by exchangeHouse
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

  Scenario: ExchangeHouse creates a new employer, then the request is approved and further approved by the admin
    Given  [Login Head Office Page] User enter the URL "https://exchangehouse.getthelingo.com/"
    When   [Login Head Office Page] User enter email id "dubaiexchange@kamelpay.com"
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
    Given  [Login Head Office Page] User enter the URL "https://exchangehouse.getthelingo.com/"
    Then   [Dashboard Head Office Page] User tap on employers onboard button
    When   [Branch Head Office Page] User search the branch they are created ""
    Then   [Branch Head Office Page] User tap on the add employer button
    When    [Sign Up] User enter the name "dubaicompany"
    Then    [Sign Up] User enter the email "email"
    #Then    [Sign Up] Enter the Phone code "971"
    Then    [Sign Up] User enter the branch employer phone no "12345678"
    When    [Login Page] User enter the password "Password1"
    Then    [Sign Up] User enter the confirm password "Password1"
    Then    [Update Profile] User enter the establishment id ""
    And     [Update Profile] User the address "Company Address "
    Then    [Update Profile] User enter the building no ""
    And     [Update Profile] Select the branch state "Dubai"
    When    [Update Profile] User enter the city "Dubai"
    Then    [Update Profile] User select the Payroll type"WPS"
    #Then    [Update Profile] User select the Payroll type"NON-WPS"
    And     [Update Profile] User select the FreeZone
    #Then    [Update Profile] User enter the document name "Trade License"
    #And     [Update Profile] User enter the document tittle "personal details"
    And     [Update Profile] User tap on the add more document
    Then    [Update Profile] User enter the document name "Trade License"
    Then    [Update Profile] User enter the year 2017
    And     [Update Profile] User enter the month "Dec"
    Then    [Update Profile] User enter the day "3"
    And     [Update Profile] User enter the expire year 2030
    Then    [Update Profile] User enter the expire month "Oct"
    And     [Update Profile] User enter the expire day "31"
    Then    [Update Profile] User enter the Trade License Number "TLNO"
    Then    [Update Profile] User tap on browse file
    And     [Update Profile] User enter the submit button
    Then    [Update Profile] Validate the onboard approval message "On Board request has been sent for further approval"
    Then    [OnBoard Approval Head Office Page] User tap onboard approval
    Then    [OnBoard Approval Head Office Page] User tap Clients OnBoard
    When    [Branch Head Office Page] User search the branch they are created ""
    When    [Branch Head Office Page] User search the branch  ""
    And     [OnBoard Approval Head Office Page] User tap on view button
    Then    [Admin Page] Open the admin tab "http://admin.getthelingo.com"
    When    [Admin Page] User tap on onboard Approvals
    Then   [Admin Page] User tap on Exchange House Clients button
    Then    [Admin Page] User select the exchange house ""
    When    [Branch Head Office Page] User search the branch they are created ""
    And     [Admin Page] User tap on view button
    #Then    [Admin Page] User verify establishment id and approve by admin
    Then    [Admin Page] User verify establishment id for the branch company and approve by admin
    And     [Admin Page] User verify the employer approve by the admin "Action Successfully"

  Scenario Outline: Exchange house create a branch and then create a domestic for the branch and then create multiple Employee in domestic employer
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
    Given  [Login Head Office Page] User enter the URL "http://10.10.5.100:8004"
    Then   [Web Portal Page] User enter the user name "admin"
    Then   [Web Portal Page] User enter the Password "Password1"
    Then   [Web Portal Page] User tap on the login button
    When   [Web Portal Page] User tap on the side manu "Corporate"
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
    And     [Exchange House Domestic Employer Page] User tap on the domestic employer page
    Then    [Exchange House Establishments Page] User enter branch name when they are creates
    Then    [Exchange House Domestic Employer Page] User tap on the domestic employer add button
    And     [Exchange House Domestic Employer Page] User verify the notification message "On Board request has been sent for further approva"
    And     [Exchange House Domestic Employer Page] User tap on view button and approve by exchange house
    Then    [Admin Page] Open the admin tab "https://admin.getthelingo.com"
    When    [Admin Page] User tap on onboard Approvals
    Then    [Admin Page] User tap on Exchange House Clients button
    Then    [Admin Page] User select the exchange house ""
    And     [Admin Page] User select the branch ""
    #Then    [Exchange House Establishments Page] User tap on establishments module
    And    [Admin Page] User tap on view button
    #And    [OnBoard Approval Head Office Page] User tap on view button
    Then   [Admin Page] Admin verification the branch and then approve
    Given  [Login Head Office Page] User enter the URL "http://10.10.5.100:8004"
    Then   [Web Portal Page] User enter the user name "admin"
    Then   [Web Portal Page] User enter the Password "Password1"
    Then   [Web Portal Page] User tap on the login button
    When   [Web Portal Page] User tap on the side manu "Corporate"
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
    And     [Exchange House Domestic Employer Page] User tap on the domestic employer page
    #Then    [Exchange House Establishments Page] User enter branch name when they are creates
    Then    [Employees Page] User create a multiple data for the domestic employer "<MolNo>""<EmpCode>""<FirstName>""<LastName>""<DisplayName>""<DOB>"" <Gender> "" <Nationality>""<JoiningDate>""<Email>""<MobileNo>""<AlternatePhone>""<HomeAddress>""<HomeState>""<HomePostCode>""<WorkAddress>""<WorkState>""<WorkPostCode>""<PassportNo>""<PassportExpiry>""<EID>""<EIDExpiry>""<EstablishmentId>"
    And     [Employees Page] User upload a bulk employees file ""
    And     [ExchangeHouse Approval Page] User tap on the exchange house approval button
    Then    [ExchangeHouse Approval Page] User select the branch
    Then    [Request Page] User tap on the view button
    And     [Request Page] User tap on the Approve button
    Then    [Admin Page] Open the admin tab "https://admin.getthelingo.com/"
    When    [Admin Page] User tap on Exchange house client Approvals
    And     [Admin Page] User tap on view button
    Then    [Admin Page] User tap on approve button
    Then    [Admin Page] User Tap om the exchange house browse button
    #Then    [Admin Page] User tap No other bank employees in given file
    And     [Admin Page] User Tap on the approve button
    Then    [Admin Page] User verify the notification message "Action Successful"

    Examples:
      |FirstName|MolNo|EmpCode|LastName|DisplayName|DOB|Gender|Nationality|JoiningDate|Email|MobileNo|AlternatePhone|HomeAddress|HomeState|HomePostCode|WorkAddress|WorkState|WorkPostCode|PassportNo|PassportExpiry|EID|EIDExpiry|EstablishmentId|
      |Ahsan|Mol12345|1|1|User|05/05/1978|M|BD|05/05/1978|@mailinator.com|971|971|Address|1|00001|2|2|2|Passport|10/05/2029|10000000000|10/05/2029||

  Scenario Outline: check data

    Then    [Employees Page] User create a multiple data for the domestic employer "<MolNo>""<EmpCode>""<FirstName>""<LastName>""<DisplayName>""<DOB>"" <Gender> "" <Nationality>""<JoiningDate>""<Email>""<MobileNo>""<AlternatePhone>""<HomeAddress>""<HomeState>""<HomePostCode>""<WorkAddress>""<WorkState>""<WorkPostCode>""<PassportNo>""<PassportExpiry>""<EID>""<EIDExpiry>""<EstablishmentId>"


    Examples:
      |FirstName|MolNo|EmpCode|LastName|DisplayName|DOB|Gender|Nationality|JoiningDate|Email|MobileNo|AlternatePhone|HomeAddress|HomeState|HomePostCode|WorkAddress|WorkState|WorkPostCode|PassportNo|PassportExpiry|EID|EIDExpiry|EstablishmentId|
      |User|Mol12345|1|1|User|05/05/1978|M|BD|05/05/1978|@mailinator.com|971|971|Address|1|00001|2|2|2|Passport|10/05/2029|10000000000|10/05/2029||
  @Branches @Branches4
  Scenario Outline: Exchange house create a branch and then Login a branch and add domestic employer then add employee on the domestic employer
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
    Given  [Login Head Office Page] User enter the URL "http://10.10.5.100:8004"
    Then   [Web Portal Page] User enter the user name "admin"
    Then   [Web Portal Page] User enter the Password "Password1"
    Then   [Web Portal Page] User tap on the login button
    When   [Web Portal Page] User tap on the side manu "Corporate"
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
    And    [Login Head Office Page] User tap on the logout button
    When   [Login Head Office Page] User select the role "Branch"
    When   [Login Head Office Page] User enter email id ""
    Then   [Login Head Office Page] User enter the Password "Password1"
    And    [Login Head Office Page] User tap on the login button
    And     [Exchange House Domestic Employer Page] User tap on the domestic employer page
    #Then    [Exchange House Establishments Page] User enter branch name when they are creates
    Then    [Exchange House Domestic Employer Page] User tap on the domestic employer add button
    And     [Exchange House Domestic Employer Page] User verify the notification message "On Board request has been sent for further approva"
    And     [Exchange House Domestic Employer Page] User tap on view button and approve by exchange house
    Then    [Admin Page] Open the admin tab "https://admin.getthelingo.com"
    When    [Admin Page] User tap on onboard Approvals
    Then    [Admin Page] User tap on Exchange House Clients button
    Then    [Admin Page] User select the exchange house ""
    And     [Admin Page] User select the branch ""
    #Then    [Exchange House Establishments Page] User tap on establishments module
    And    [Admin Page] User tap on view button
    #And    [OnBoard Approval Head Office Page] User tap on view button
    Then   [Admin Page] Admin verification the branch and then approve
    Given  [Login Head Office Page] User enter the URL "http://10.10.5.100:8004"
    Then   [Web Portal Page] User enter the user name "admin"
    Then   [Web Portal Page] User enter the Password "Password1"
    Then   [Web Portal Page] User tap on the login button
    When   [Web Portal Page] User tap on the side manu "Corporate"
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
    And     [Exchange House Domestic Employer Page] User tap on the domestic employer page
    #Then    [Exchange House Establishments Page] User enter branch name when they are creates
    Then    [Employees Page] User create a multiple data for the domestic employer "<MolNo>""<EmpCode>""<FirstName>""<LastName>""<DisplayName>""<DOB>"" <Gender> "" <Nationality>""<JoiningDate>""<Email>""<MobileNo>""<AlternatePhone>""<HomeAddress>""<HomeState>""<HomePostCode>""<WorkAddress>""<WorkState>""<WorkPostCode>""<PassportNo>""<PassportExpiry>""<EID>""<EIDExpiry>""<EstablishmentId>"
    And     [Employees Page] User upload a bulk employees file ""
    And     [ExchangeHouse Approval Page] User tap on the exchange house approval button
    Then    [ExchangeHouse Approval Page] User select the branch
    Then    [Request Page] User tap on the view button
    And     [Request Page] User tap on the Approve button
    Then    [Admin Page] Open the admin tab "https://admin.getthelingo.com/"
    When    [Admin Page] User tap on Exchange house client Approvals
    And     [Admin Page] User tap on view button
    Then    [Admin Page] User tap on approve button
    Then    [Admin Page] User Tap om the exchange house browse button
    #Then    [Admin Page] User tap No other bank employees in given file
    And     [Admin Page] User Tap on the approve button
    Then    [Admin Page] User verify the notification message "Action Successful"

    Examples:
      |FirstName|MolNo|EmpCode|LastName|DisplayName|DOB|Gender|Nationality|JoiningDate|Email|MobileNo|AlternatePhone|HomeAddress|HomeState|HomePostCode|WorkAddress|WorkState|WorkPostCode|PassportNo|PassportExpiry|EID|EIDExpiry|EstablishmentId|
      |User|Mol12345|1|1|User|05/05/1978|M|BD|05/05/1978|@mailinator.com|971|971|Address|1|00001|2|2|2|Passport|10/05/2029|10000000000|10/05/2029||





















