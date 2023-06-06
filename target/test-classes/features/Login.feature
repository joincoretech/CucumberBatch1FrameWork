Feature: Login


  Scenario: Valid login
    When  User add valid userName
    And   User add valid password
    And   User click on the sign in button
    Then User login successfully


    Scenario: Invalid login
      When User add invalid username
      And  User add invalid password
      And  User click on the sign in button
      Then User see error message

  Scenario: Invalid login with empty password
    When  User add valid userName
    And  User does not add password
    And  User click on the sign in button
    Then User see error message

  Scenario: Invalid login with empty username
    When  User does not add userName
    And   User add valid password
    And  User click on the sign in button
    Then User see error message credentials are required