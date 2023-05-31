Feature: Add Employee


  Background:
    When user enters valid username and password
    And user clicks on login button
    Then user is successfully logged in
    When user clicks on PIM option
    And user clicks on Add Employee button

  @sprint3 @regression
  Scenario: Valid admin login
    And user enter firstname and lastname
    And user clicks on save button
    Then employee added successfully

  @test1
  Scenario: Adding one employee using feature file
    And user enter "ooo" and "oaa"
    And user clicks on save button
    Then employee added successfully

  @outline1
  Scenario Outline: Adding multiple employees using feature file
    And user enter value for "<firstNameValue>" and "<lastNameValue>"
    And user clicks on save button
    Then employee added successfully
    Examples:
      | firstNameValue | lastNameValue |
      | aaa       | bbb      |
      | aaa1      | bbb1     |

    @datatable
    Scenario: Adding multiple employees using data table
      When user adds multiple employee and verify they are added successfully
      |firstName|middleName|lastName|
      |zara     |MS        |cami    |
      |birgul   |MS        |ozin   |
      |alina    |MS        |boba   |




