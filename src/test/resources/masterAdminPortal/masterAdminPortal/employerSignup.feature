@employerSignUp
Feature: employerSignUp


  Scenario: Create an employer from the master admin,with all steps approved through the master admin.
    Given   [MasterAdmin Page] The user navigate to the master admin portal
    Then    [Admin Page] User enter the  email "admin@admin.com"
    When    [Admin Page] User enter the Password "12345678"
    And     [Admin Page] User tap on login page
    Then    [Sign Up] User enter the otp code "111111"
    Then    [MasterAdmin Page] the user verifies the OTP toast message "OTP Verified".
    When    [MasterAdmin EmployerPage] The user clicks on the employer button
    When    [MasterAdmin EmployerPage] The user clicks on the add employer button
    Then    [Update Profile] User select the Payroll type"WPS"
    Then    [Update Profile] User enter the establishment id ""
    When    [Sign Up] User enter the name ""
    Then    [Sign Up] User enter the email "email"
    Then    [Sign Up] User enter the phone no ""
    When    [Login Page] User enter the password ""
    Then    [Sign Up] User enter the confirm password ""
    And     [Update Profile] User enter the company address ""
    Then    [Update Profile] User enter the building no ""
    Then    [Update Profile] User enters the Zip Code "00000"
    And     [MasterAdmin EmployerPage] The user Select the state "Dubai"
    When    [Update Profile] User enter the city "Dubai"
    Then    [MasterAdmin OtherDetailsPage] User selects FreeZone "Yes"
    And     [MasterAdmin OtherDetailsPage] User checks the Migrated Employer checkbox
    And     [Update Profile] User enters the trade license issue date ""
    And     [Update Profile] User enters the trade license expiry date ""
    And     [Update Profile] User enters the trade license number ""
    And     [Update Profile] User uploads the Trade License document "Trade doc.pdf"
    And     [Update Profile] User enters the sponsor document issue date ""
    And     [Update Profile] User enters the sponsor document expiry date ""
    And     [Update Profile] User enters the sponsor document number ""
    And     [Update Profile] User uploads the Sponsor Document "sponsor_doc.pdf"
    Then    [Update Profile] User clicks on the "Submit" button
    Then    [MasterAdmin Page] The user verifies the success toast message "On Board request has been sent for further approval"
    Then    [Dashboard Page] The user navigates to "Onboard Approvals"
    Then    [Onboard Approvals] The user searches for employer and verify the employer name in the onboard approvals table   ""
    Then    [Onboard Approvals] The user verifies the approval tracking status is "Waiting for Checker's approval"
    And     [Admin Page] User tap on view button
    Then    [Admin Page] User verify establishment id and approve by admin
    Then    [Basic EmployerDetails] The user verifies all employer details
    Then    [Additional Details] The user navigates to the "Additional Details" tab
    Then    [Additional Details] The user click to the Add/Edit Onboarding Source button
    When    [Onboard Approvals] The user clicks on the "Approve" button
    Then    [Onboard Approvals] The user verifies the success toast message "Employer successfully approved"