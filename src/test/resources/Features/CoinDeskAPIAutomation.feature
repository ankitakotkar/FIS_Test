Feature: Coin Desk API Interactions
#Author : Ankit Akotkar
  Scenario: Calling Coin Desk API and Validating response contents
  
    Given User calls specified coin desk API
    Then The response status code should be 200
    And The response should contain 3 BPI keys
    And The "GBP" key description in response should be "British Pound Sterling"