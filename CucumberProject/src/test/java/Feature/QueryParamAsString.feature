Feature: ServiceNow Incident Management filter QP with String

Scenario: Get all the incidents with QP as string in Step Level

Given set the endpoint
And add the auth
And add the query param as "sysparm_fields" and "sys_id, number"
When send the request for incident
Then validate the response for QP as String