Feature: Add cart functionality for eBAY

#Author : Ankit Akotkar
  Scenario: Verify item addition to cart
    Given User navigates to Ebay web site
    When User searches for "books" and clicks on first result displayed
    Then User adds item to the cart
    Then User verifies if the item is added to cart
    