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

