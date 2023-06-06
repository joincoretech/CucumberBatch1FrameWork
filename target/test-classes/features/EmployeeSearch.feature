Feature: Employee Search

  Background:
    And  user login as admin
    And user navigate to employee view page


  Scenario: Search employee by id
    When user add employee id
    And user click on the submit button
    Then user validate the employee is visible in table


  Scenario: Search employee by name
    When user add employee name
    And user click on the submit button
    Then user validate the employee is visible in table
