Feature: Assignement 5

Scenario: Create Incident 

Given set the endpoint
And add the auth
When send the request for post
Then validate status code as 201 for A5
Then validate length of task_number

#use hooks
#validation use 2 methods : int code and matchers 

Scenario Outline: update the description with 6 digit random alphanumeric 

Given set the endpoint
And add the auth
When send the request for put with update description as "<description>" and "<category>"
Then validate description for 6 digit Alphanumeric

Examples:
|description|category|
|abc123|test|

Scenario: Delete Incident


Given set the endpoint
And add the auth
When send delete request 
Then validate the status code as 204
Then Validate if the incident is deleted


