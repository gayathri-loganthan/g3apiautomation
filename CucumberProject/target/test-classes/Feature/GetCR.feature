Feature: ServiceNow Incident Management

Scenario Outline: Get all the incidents

Given set the endpoint
And add the auth
When send the request
Then validate the response for GET
