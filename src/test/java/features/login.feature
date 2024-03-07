@Reg
Feature: Login Functionality
@smoke
Scenario: login with valid credentials
When user enter "standard_user" and "secret_sauce" details
And user click on login button
Then validate successful login

Scenario: login with invalid credentials
When user enter "no_user" and "no_sauce" details
And user click on login button
Then validate error message

Scenario: login with valid username and invalid password
When user enter "standard_user" and "notfrank sauce" details
And user click on login button
Then validate error message

Scenario: login with invalid username and valid password
When user enter "frank_user" and "secret_sauce" details
And user click on login button
Then validate error message