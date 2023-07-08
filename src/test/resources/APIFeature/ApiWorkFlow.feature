Feature: Test all APIs
  Description: this feature file is to test all the APIs

  Background:
    Given generate token

  @APIWorkFlow
  Scenario: Create a User
    Given prepare a request to create user
    When a POST call is made to create a user
    Then verify the status code 201
    And the response contain employee name "name" and value "Aziz"

