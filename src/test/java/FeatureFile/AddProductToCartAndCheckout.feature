Feature: feature to test login functionality

  Scenario: Check login is successful with valid credentials
    Given user is on the login page
    When user enters the username and the password
    And clicks on the login button
    Then user is navigated to the home page
    And user clicks add to cart button of a product and checkout
    Then browser closes