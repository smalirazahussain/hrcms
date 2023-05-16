@AddEmployer
Feature: Branches

  @Update @UpdateProfile1
  Scenario: User add new branch to the Head office add approve by itself and admin
    #Given  [Login Head Office Page] User enter the URL "https://stage.exchangehouse.getthelingo.com/#"
    When   [Login Head Office Page] User enter email id "uk003.exchange@kamelpay.cards"
    Then   [Login Head Office Page] User enter the Password "123kamelpay321"
    And    [Login Head Office Page] User tap on the login button
    #Then   [Dashboard Head Office Page] User verify to toast message to "Successfully Login"
    And    [Dashboard Head Office Page] User tap on the branches button
    Then   [Branch Head Office Page] User tap on the add branch button
    When   [Branch Head Office Page] User enter branch name "Branch"
    When   [Branch Head Office Page] User enter the branch location "dubai"
    Then   [Branch Head Office Page] User enter the email address "UKbranch"
    And    [Branch Head Office Page] User enter the Password "Password1"
    When   [Branch Head Office Page] User enter the confirm Password "Password1"
    And    [Branch Head Office Page] User enter branch phone no "8 888 8888"
    Then   [Branch Head Office Page] User tap on add branch button
    And    [Branch Head Office Page] User validate toast message ""























