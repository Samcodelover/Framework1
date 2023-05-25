Feature: Add Employee

  @sprint3 @regression
  Scenario: Valid admin login
    Given user is navigated to HRMS application
    When user enters valid username and password
    And user clicks on login button
    Then user is successfully logged in
    When user clicks on PIM option
    And user clicks on Add Employee button
    And user enter firstname and lastname
    And user clicks on save button
    Then employee added successfully
