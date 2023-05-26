Feature: US-321 Searching the employee

  @regression @tag123
  Scenario: Search employee by id
    Given user is navigated to HRMS application
    When user enters valid username and password
    And user clicks on login button
    Then user is successfully logged in
    When user clicks on PIM option
    And user clicks on Employee list option
    When user enters a valid employee id
    And user clicks on search button
    Then user see employee information is displayed