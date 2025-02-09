@tag
Feature: Error Validation
  I want to use this template for my feature file


  @ErrorValidation
  Scenario Outline: Positive Test of Submitting order
    Given I landed on Ecomm page
    And Logged in with username <name> and password <password>
    Then "Incorrect email or password." message is displayed
   

    Examples: 
      |    name            |  password  |
      | Skip923@gmail.com  |  Test1234  |
      | Skip123@gmail.com  |  Test234   |
