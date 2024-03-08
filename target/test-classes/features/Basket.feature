@Reg @smoke
Feature: Basket Functionality

Background: user navigate swag labs app
When user enter "standard_user" and "secret_sauce" details
And user click on login button

Scenario: verify user is able to add the product into basket
And user click on add to cart button
Then validate cart count is "1"