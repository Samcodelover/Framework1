Feature: US-321 Searching the employee

  Background:
     #Given user is navigated to HRMS application
    When user enters valid username and password
    And user clicks on login button
    Then user is successfully logged in
    When user clicks on PIM option
    And user clicks on Employee list option

  @regression @test
  Scenario: Search employee by name
    When user enters a valid employee name
    And user clicks on search button
    Then user see employee information is displayed

  @regression @tag123
  Scenario: Search employee by id
    When user enters a valid employee id
    And user clicks on search button
    Then user see employee information is displayed

