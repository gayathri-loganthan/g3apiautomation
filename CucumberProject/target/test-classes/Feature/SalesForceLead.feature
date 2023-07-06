Feature: Create, Update and Delete Lead


Scenario Outline: Create Salesforce Lead
Given Enter the URL for access token generation
And Enter the grant type "<grant>" and "<client_id>" and "<client_secret>" and "<username>" and "<password>" and generate access token
And Send the SalesForce URI
#And Pass the SalesForce auth 
And Pass the access token
When Enter the "<FirstName>" and "<LastName>" and "<Company>"
Then Validate status code 201

Examples:
|FirstName|LastName|Company|
|Nishita|Venkatesh|GEMS|

Scenario: Update Company Name in Lead
Given Enter the URL for access token generation
And Enter the grant type "<grant>" and "<client_id>" and "<client_secret>" and "<username>" and "<password>" and generate access token
And Send the SalesForce URI
#And Pass the SalesForce auth 
And Pass the access token
And Get all the Lead
When Update Company Name
Then Validate status code 204

Scenario: Delete Lead created in this Feature
Given Enter the URL for access token generation
And Enter the grant type "<grant>" and "<client_id>" and "<client_secret>" and "<username>" and "<password>" and generate access token
And Send the SalesForce URI
#And Pass the SalesForce auth 
And Pass the access token
And Get all the Lead
When Delete Lead 
Then Validate status code 204
Then Validate if the lead is deleted
