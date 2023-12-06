Feature: E-commerce Shopping Functionality

  Scenario Outline: Register a New User with Valid Details
    Given the user is on the <website> registration page
    When the user attempts to register with valid details
    #Then the user should be successfully registered
    When the user clicks on the continue button

  Scenario Outline: Add a Single Item to the Shopping Cart
    Given the user is on the <website> home page
    When the user searches for <product>
    #And the user adds the first result to the cart
    #Then the item should be added to the shopping cart

  #Scenario Outline: Complete a Purchase with a Single Item
    #Given the user has an item in the <website> shopping cart
    #When the user proceeds to checkout and completes the purchase
    #Then the purchase confirmation for the item should be displayed
#
  #Scenario Outline: View Order History
    #Given the user has completed orders on <website>
    #When the user navigates to the order history page
    #Then the user's past orders should be displayed

  Examples:
    | website                                  | product    |
    | https://www.automationexercise.com/ | Winter top |
