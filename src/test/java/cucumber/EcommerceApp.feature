
@tag
Feature: Login with different creds and verify the product is added
  I want to use this template for my feature file
 Background:
 Given Launch the Ecommerce App

  @tag2
  Scenario Outline: Login with different creds to verify the app
    Given login with valid <username> and <password>
    When Add the product into cart
    Then verify the exact product is added into the card
    And Checkout once product is verified

    Examples: 
      | username                 | password     |
      | roja.reddy@gmail.com     | Hydrogen@01  |
      | rajesh.manne@gmail.com   | rmanne0425   |
