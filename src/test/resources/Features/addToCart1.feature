Feature: Add to card2
  Scenario:
    Given  I'm on the Store Page
    When I add a "Blue Shoes" to the cart
    Then I should see 1 "Blue Shoes" in the cart

  Scenario Outline:
    Given  I'm on the Store Page
    When I add a "<product_name>" to the cart
    Then I should see 1 "<product_name>" in the cart
    Examples:
      | product_name |
      | Blue Shoes   |
      | Anchor Bracelet |


  Scenario:
    Given I am application User
    And I have the product in cart
    And I'm check out page
    When I'm providing Billing Details
      | FirstName | Rakesh |
      | LastName  | Mandagiri |
      | Country   | United States (US) |
      | Street_address | x154 CheckGJ street |
      | City           | Orlando             |
      | State          | Florida             |
      | ZIP_Code       | 32801               |
      | Email_address  | Mand123@gmail.com   |
    And I place an order
    Then the Order should be placed successfully

