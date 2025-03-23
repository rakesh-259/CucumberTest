Feature: search the product scenarios
  Scenario:
    Given I am Home Page of askomdch
    And click on "SHOP NOW" button
    When Navigate to store Page and sort the product by "Sort by price: low to high"
    And Filter by scroll from "10$" to "30$"
    And Click on Filter
    Then Verify the filtered data prize is with in the "30$"

