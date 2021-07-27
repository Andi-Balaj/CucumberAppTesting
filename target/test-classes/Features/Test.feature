Feature: FrontEnd Test
  Scenario Outline: Open and run app
    Given User is logged in
    Then Add new user with Username as "<username>"
    And Edit user
    Then Delete user
    Then User is logged out
    Examples:
      | username|
      | George Andrei |