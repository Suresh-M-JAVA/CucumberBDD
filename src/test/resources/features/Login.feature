Feature: Login functionality

Scenario: Login with valid credentials
Given User navigates to login page
When User enters valid email address "sureshm434@gmail.com" into email field
And User enters valid password "sureshm@434" into password field
And User clicks on Login button
Then User should get successfully logged in

Scenario: Login with invalid credentials
Given User navigates to login page
When User enters invalid email address into email field
And User enters invalid password "sureshm@43412" into password field
And User clicks on Login button
Then User should get a proper warning message about credentials mismatch

Scenario: Login with valid email and invalid password
Given User navigates to login page
When User enters valid email address "sureshm434@gmail.com" into email field
And User enters invalid password "sureshm@43412" into password field
And User clicks on Login button
Then User should get a proper warning message about credentials mismatch

Scenario: Login with invalid email and valid password
Given User navigates to login page
When User enters valid email address "sureshm434@gmail.com" into email field
And User enters invalid password "sureshm@43412" into password field
And User clicks on Login button
Then User should get a proper warning message about credentials mismatch

Scenario: Login without providing any credentials
Given User navigates to login page
When User dont enter email address into email field
And User dont enter password into password field
And User clicks on Login button
Then User should get a proper warning message about credentials mismatch
 