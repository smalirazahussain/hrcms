@Login
Feature: LinkedEstablishmentID

  Scenario: Add link establishment id
    Given   [Login Page] User enter the email "11793"
    When    [Login Page] User enter the password "Password1"
    Then    [Login page] User tap on login button
    Then    [Profile Page] User tap oon the profile button
    And     [Link EstablishmentID Page] User tap on add Establishment button
    When    [Sign Up] User enter the name "hikma"
    Then    [Update Profile] User enter the establishment id ""
    Then    [Update Profile] User enter the year 2017
    And     [Update Profile] User enter the month "Dec"
    Then    [Update Profile] User enter the day "3"
    And     [Link EstablishmentID Page] User enter the expire year 2030
    Then    [Update Profile] User enter the expire month "Oct"
    And     [Update Profile] User enter the expire day "31"
    Then    [Update Profile] User tap on browse file
    And     [Update Profile] User enter the submit button
    Then    [Link EstablishmentID Page] User verify the notification message "Approval is processed for further actions"

