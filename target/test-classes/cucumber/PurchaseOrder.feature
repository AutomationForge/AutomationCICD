@tag
Feature: Title of your feature
  I want to use this template for my feature file

Background:
   Given I landed on Ecomm page
    

  @Regression
  Scenario Outline: Positive Test of Submitting order
    Given Logged in with username <name> and password <password>
    When I add the product <productName> to Cart
    And Checkout the product <productName>  and submit the order
    Then "THANKYOU FOR THE ORDER." message is displayed on ConfirmationPage

    Examples: 
      |    name            |  password  | productName  |
      | Skip123@gmail.com  |  Test1234  | QWERTY       |
      | Skip1234@gmail.com |  Test1234  |BANARSI SAREE |
