Feature: Purchase Item

  @login
  Scenario: login with valid credential
    Given I am on Login page
    When I click on username and password field it takes input
    Then click on singIn button