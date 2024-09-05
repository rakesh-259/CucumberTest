Feature: Add to card2
  Scenario:
    Given  I'm on the Store Page
    When I add a "Blue Shoes" to the cart
    Then I should see 1 "Blue Shoes" in the cart
