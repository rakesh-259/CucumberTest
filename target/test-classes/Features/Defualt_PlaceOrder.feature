Feature: Place a order
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

