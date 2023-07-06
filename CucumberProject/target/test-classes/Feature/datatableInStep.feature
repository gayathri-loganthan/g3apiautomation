Feature: ServiceNow Incident Management pass values in steps

Scenario: Get all the incidents with QP in Step Level

Given set the endpoint
And add the auth
And add the query param as map
|sysparm_fields|sys_id,task_effective_number,urgency,approval,knowledge|
|urgency|3|
|approval|not requested|
|knowledge|false|
When send the request for incident
Then validate the response for send data in datatable