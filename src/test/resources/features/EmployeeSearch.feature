Feature: Employee Search


  Scenario: Search employee by id
    Given user navigate to hrm
    And  user login as admin
    And user navigate to employee view page
    When user add employee id
    And user click on the submit button
    Then user validate the employee is visible in table