Feature: Registration functionality

Scenario: User creates an account with only mandatory fields
Given User navigates to Register Account page
When User enters the details into below fields
|firstName  |suresh               |
|lastName   |m                    |
|telephone  | 1234546787          |
|password   | sureshm@434         |
And User selects Privacy Policy
And User clicks on Continue button
Then User account should created successfully 

Scenario: User creates an account with all fields
Given User navigates to Register Account page
When User enters the details into below fields
|firstName  |suresh               |
|lastName   |m                    |
|telephone  | 1234546787          |
|password   | sureshm@434         |
And User selects Yes for Newsletter
And User selects Privacy Policy
And User clicks on Continue button
Then User account should created successfully

Scenario: User creates a duplicate account
Given User navigates to Register Account page
When User enters the details into below fields with duplicate email
|firstName  |suresh               |
|lastName   |m                    |
|email      |sureshm434@gmail.com |
|telephone  | 1234546787          |
|password   | sureshm@434         |
And User selects Yes for Newsletter
And User selects Privacy Policy
And User clicks on Continue button
Then User should get proper warning message about duplicate email

Scenario: User creates an account without filling any details
Given User navigates to Register Account page
When User dont enter any details into fields
And User clicks on Continue button
Then User should get proper warning messages for every mandatory fields

