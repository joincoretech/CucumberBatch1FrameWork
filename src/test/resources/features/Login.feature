Feature: Login

 @smoke @regression
  Scenario: Valid login
    When  User add valid userName
    And   User add valid password
    And   User click on the sign in button
    Then User login successfully

 @smoke
  Scenario: Invalid login
    When User add invalid username
    And  User add invalid password
    And  User click on the sign in button
    Then User see error message
  @regression
  Scenario: Invalid login with empty password
    When  User add valid userName
    And  User does not add password
    And  User click on the sign in button
    Then User see error message
@test
  Scenario: Invalid login with empty username
    When  User does not add userName
    And   User add valid password
    And  User click on the sign in button
    Then User see error message credentials are required

  @datalogin
  Scenario Outline: login with multiple data
    When  User add valid "<userName>" and "<password>"
    And   User click on the sign in button
    Then User login successfully

    Examples:
    | userName         | password   |
    |  batch1@gmailcom | batch1@123 |
    |  admin@gmail.com | admin#123  |

     @error
    Scenario: login with invalid credentials
      When user add invalid username and password and verify error message
       |    username    | password   |    errormessage                 |
       |  atch1@gmailcom| batch1@123 | Username and Password is Wrong!|
       |  admin@gmail.com| adm#123   | Username and Password is Wrong! |

       @excel
       Scenario: login use excel data
         When user add username and password from excel "testdata" and verify the error message