@ACL
Feature: ACL

  Scenario: Employer give all employee all access and verify that all button are shows on the employee module
    Given   [Login Page] User enter the email ""
    When    [Login Page] User enter the password ""
    Then    [Login page] User tap on login button
    Then    [Login page] User verify toast msg "OTP Generated"
    And     [Sub Admin] User tap on the submit button
    #Then    [Login page] User verify toast msg "Two Factor Enabled"
    Then    [Sign Up] User enter the otp code "111111"
    And     [Sign Up] User tap on verify button
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
    Then    [DesHBoard Page] User tap on the logout from dashboard
    And     [Sub Admin] Use tap on the I am not the Primary User? button
    And     [Sub Admin] Use enter the the company id ""
    And     [Sub Admin] Use paste the team member email
    And     [Sub Admin] User enter the password "Password1"
    Then    [Login page] User tap on login button
    And     [Sub Admin] User tap on the submit button
    Then    [Sign Up] User enter the otp code "111111"
    And     [Sign Up] User tap on verify button
    Then    [Sub Admin] User validate the button are present




