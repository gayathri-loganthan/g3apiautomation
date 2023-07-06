Feature: Assignment to create data combinations in same scenario

Scenario Outline: Create Incident

Given set the endpoint
And add the auth
When post the request with short description as "<short_description>" and  category as "<category>"
Then validate the response for POST


Examples:
	|short_description|category|
	|This is First|software|
	|This is Second|hardware|
	|This is Third|inquiry|