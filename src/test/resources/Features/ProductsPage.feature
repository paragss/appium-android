@Product @RunAll
Feature: Test the Products page functionality

  @ListView
  Scenario: Validate user is able to switch between list view and grid view
    Given user is logged into application
    When I click on list view
    Then products should be displayed in a list

  @AddItemToCart
  Scenario: Validate user is able add product to cart
    Given user is logged into application
    When I click on Add to cart button
    And click on cart icon
    Then product should be added to cart

  @PlaceOrder
  Scenario: Validate user is able place an order
    Given user is logged into application
    When I click on Add to cart button
    And click on cart icon
    Then product should be added to cart
    When I click on checkout button
    And I enter firstname, lastname and zipcode
    And click on continue button
    When i click on finish
    Then order confirmation page should appear


