Feature: ServiceNow Incident Management background

Background:
Given set the endpoint
And add the auth


Scenario: Get all the incidents with QP in Step Level filter 1
And add the query param as map
|sysparm_fields|sys_id, category, urgency|
|urgency|3|
When send the request for incident
Then validate the response for send data in datatable

Scenario: Get all the incidents with QP in Step Level filter 2
And add the query param as map
|sysparm_fields|sys_id, urgency, approval, knowledge, number|
|urgency|3|
|approval|not requested|
|knowledge|false|
When send the request for incident
Then validate the response for send data in datatable