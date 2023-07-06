Feature: Salesforce ID

Scenario Outline: Create Salesforce ID
Given Send the SalesForce URI
And Pass the SalesForce auth
When Enter the "<FirstName>" and "<LastName>"
Then Validate status code 201

Examples: 
|FirstName|LastName|
|Gayathri|Venkatesh|

Scenario: Assert Name in created ID
Given Send the SalesForce URI
And Pass the SalesForce auth
And Get all the ID
Then Validate first name contains firstname
#|result.Name|Gayathri|

Scenario: Update Mailing State in ID
Given Send the SalesForce URI
And Pass the SalesForce auth
And Get all the ID
When Modify mailing status
Then Validate status code 204

