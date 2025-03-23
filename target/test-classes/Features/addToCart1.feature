
Feature: Add to card2
  As a customer of xyz app
  I want to add the product in cart
  so that I can purchase the product

  @regression
  Scenario: Add the blue shoes product
    Given  I'm on the Store Page
    When I add a "Blue Shoes" to the cart
    Then I should see 1 "Blue Shoes" in the cart
  @sanity
  Scenario Outline: Add the 2 set of product to cart
    Given  I'm on the Store Page
    When I add a "<product_name>" to the cart
    Then I should see 1 "<product_name>" in the cart
    Examples:
      | product_name |
      | Blue Shoes   |
      | Anchor Bracelet |

  @sanity
  Scenario: Add the product and place the order,billing
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
  @regression
  Scenario: Add the product from mens section and cancel from the cart
    Given I am Home Page of askomdch
    And Click on the SHOP NOW button based on the title "Latest Eyewear"
    When check out all the product in that page
    And Place the mouse to view to shopping card and click on the view to card
    Then Verify the Item should be zero after removing all the Items



