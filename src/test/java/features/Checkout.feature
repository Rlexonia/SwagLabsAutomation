@Reg
Feature: Checkout Functionality
Background: user navigate swag labs
When user enter "standard_user" and "secret_sauce" details
And user click on login button
And user click on add to cart button
Then validate cart count is "1"
And user navigate to checkout page

Scenario: Checkout with valid firstname lastname and postalcode
And user enter personal details "Test" "Automation" "201301"
And user click on Continue button
Then validate user navigate to checkout two page

Scenario: Checkout with empty firstname valid lastname and valid postalcode
And user enter personal details "" "Automation" "201301"
And user click on Continue button
Then checkout validate error message

Scenario: Checkout with valid firstname empty lastname and valid postalcode
And user enter personal details "Test" "" "201301"
And user click on Continue button
Then checkout validate error message
@smoke
Scenario: Checkout with valid firstname valid lastname and empty postalcode
And user enter personal details "Test" "Automation" ""
And user click on Continue button
Then checkout validate error message
