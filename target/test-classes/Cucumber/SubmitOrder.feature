@tag
Feature: Purchase the order from Ecommerce Website
  I want to use this template for my feature file

  Background: 
    Given I landed on Ecommerce Page

  @tag2
  Scenario Outline: Positive test of submitting the order
    Given logged in with username <name> and password <password>
    When I add the product "<ProductName>" to the cart
    And Checkout "<ProductName>" and submit the order
    Then "THANKYOU FOR THE ORDER." message is displayed on the ConfirmationPage

    Examples: 
      | name                 | password  | ProductName |
      | laxman2089@gmail.com | Lucky@123 | ZARA COAT 3 |
