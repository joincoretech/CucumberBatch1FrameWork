Feature: Dashboard Tabs Functionality


  @dashboardTabs  @regression
  Scenario: Dashboard Tab verification
    When  User add valid userName
    And   User add valid password
    And   User click on the sign in button
    Then User login successfully
    Then user verify the dashboard tabs
    | Dashboard	| Employee | Leave |  Change Password | Master List |