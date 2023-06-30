@front-end
Feature: Proceed to Checkout

  @UITests1
  Scenario Outline: Proceed to Checkout of amazon
    Given User Navigate to the Amazon website and clicks on Sign in button
    And User enter valid login credentials "<username>" and "<password>"
    Then Verify that the "<user>" is successfully logged in
    When User search for an "<product>" to add in Cart
    And User Add a "<product>" to the cart
    And User Click on the cart icon to view the cart page
    Then User should be able to see selected "<product>" in cart
    When User Click on the "Proceed to Checkout" button
    Then Ensure that the checkout page is loaded successfully

    Examples:
      | username   | password    | user         | product                         |
      | 9330850753 | Mumbai@2023 | Hello, Ankit | Apple iPhone 14 (128 GB) - Blue |