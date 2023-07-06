Feature: Validate the values from datatable

Scenario: Get all the incidents with QP as string in Step Level

Given set the endpoint
And add the auth
And add the query param as "sysparm_fields" and "sys_id, number"
When send the request for incident
Then validate the response for QP as String


Scenario: Get all the incidents with QP in Step Level

Given set the endpoint
And add the auth
And add the query param as map
|sysparm_fields|sys_id, number, category, urgency, approval, knowledge, number|
When send the request for incident
Then validate the response for send data in datatable
|urgency|3|
|approval|not requested|
|knowledge|false|