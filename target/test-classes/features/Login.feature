Feature: Login functionality

  @sprint1 @regression @tc1101
  Scenario: Valid admin login
    #Given user is navigated to HRMS application
    When user enters valid username and password
    And user clicks on login button
    Then user is successfully logged in

    @tc1102 @regression
  Scenario: Valid ess login
    #Given user is navigated to HRMS application
    When user enters ess username and ess password
    And user clicks on login button
    Then user is successfully logged in

  @tc1103 @regression
  Scenario: Invalid admin login
    #Given user is navigated to HRMS application
    When user enters invalid username and password
    And user clicks on login button
    Then error message displayed







