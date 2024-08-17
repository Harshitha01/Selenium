@tag
Feature: Purchase the order from ECommerce website
  I want to use this template for my feature file
  
  Background:
  Given I land on Ecommerce Page

  @tag1
  Scenario: Positive Test of Submitting the order
    Given Logged in with username <UserName> and Password <Password>
    When I add Product <ProductName> to Cart
    And Checkout <ProductName> and submit the order
    Then I verify "THANKYOU FOR THE ORDER." message is displayed.

 

    Examples: 
      | UserName  				 | Password       | ProductName |
      | harshi@example.com | Harshi01051998 | ZARA COAT 3 |
   
