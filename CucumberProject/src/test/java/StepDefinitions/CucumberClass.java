package StepDefinitions;

import java.util.Map;

import org.hamcrest.Matchers;

import io.cucumber.java.en.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CucumberClass {
	
	static RequestSpecification request;
	static Response response;
	static String sys_id; 
		
	@Given("set the endpoint")
	public void setEndpoint() {
		RestAssured.baseURI = "https://dev89356.service-now.com/api/now/table";
	}

	@And("add the auth")
	public void addAuth() {
		RestAssured.authentication=RestAssured.basic("admin","Soft2007!@");
	}
	
	@Then("add the query param as {string} and {string}")
	public void add_the_query_param_as_and(String key, String value) {
	    
		request = RestAssured.given().log().all();
		request.queryParam(key, value).contentType(ContentType.JSON);
	}
	
	
	@And("add the query param as map")
	public void add_the_query_param(io.cucumber.datatable.DataTable dataTable) {
	    
	    request = RestAssured.given().log().all();
	    
	    Map<String, String> asMap = dataTable.asMap();
	    request.queryParams(asMap).contentType("application/JSON");
	    
	}
	
	@When("send the request")
	public void send_the_request() {
	    request = RestAssured.given().contentType("application/JSON");
	    response = request.get("/change_request");
	}
	
	
	@When("send the request for post")
	public void send_the_request_POST() {
	    request = RestAssured.given().contentType("application/JSON")
	    		.queryParam("sysparm_fields", "description,short_description,sys_id,task_effective_number");
	    response = request.post("/incident");
	    sys_id = response.jsonPath().get("result.sys_id");
	}

	@When("send the request for incident")
	public void send_the_request_for_incident() {
	    //request = RestAssured.given().log().all();
	    response = request.get("/incident");
	
	}
	
	@When("post the request with short description as {string} and  category as {string}")
	public void postRequest(String short_description, String category) {
		
		request = RestAssured.given().contentType("application/JSON").when().body("{\r\n"
                + "    \"short_description\": \""+short_description+"\",\r\n"
                + "        \"category\": \""+category+"\"\r\n"
                + "}");
		response = request.post("/change_request");             
					
	}
	
	@When ("send the request for put with update description as {string} and {string}")
		public void validateAlphanumeric(String description, String category) {

		request = RestAssured.given()
				.contentType("application/JSON")
				.queryParam("sysparm_fields", "description,short_description,sys_id,task_effective_number")
				.when().body("{\r\n"
		                + "    \"description\": \""+description+"\",\r\n"
		                + "        \"category\": \""+category+"\"\r\n"
		                + "}");
		
		response = request.put("/incident/"+sys_id);
		
	}
	
	@When("send delete request")
	public void send_delete_request() {
		
		response = request.delete("/incident/"+sys_id);
	}

	@Then("validate the response for GET")
	public void validate_response_GET() {
		response.then().assertThat().statusCode(200);
		response.prettyPrint();
	}
	
	@Then("validate the response for POST")
	public void validate_response_Post() {
		response.then().assertThat().statusCode(201);
		response.prettyPrint();
	}
	
	@Then("validate the response for QP as String")
	public void validate_the_response_for_QP_as_String() {
		
		//response.then().assertThat().body("urgency", Matchers.containsString("3"));
		response.then().assertThat().statusCode(200);
		response.prettyPrint();
		

	}
	
	@Then("validate the response for send data in datatable")
	public void validate_the_response_for_send_data_in_datatable() {
		
		//response.then().assertThat().body("urgency", Matchers.containsString("3"));
		response.then().assertThat().statusCode(200);
		response.prettyPrint();
		

	}
	
	@Then("validate the response for GET as {int}")
	public void validate_response_dynamically(int code) {
		
	response.then().log().all().assertThat().statusCode(code);

	}
	
	@Then("validate status code as {int} for A5") 
		public void validate_status_code_int (int code) {
		
		response.then().log().all().assertThat().statusCode(code);
	}
	
	@Then("validate length of task_number")
		public void validateLength() {
		
		response.then().log().all().assertThat().body("result.task_effective_number.size()", Matchers.is(10));
		
	}
	
	@Then("validate description for 6 digit Alphanumeric")
	public void validateAlphanumeric() {
	
	response.then().log().all().assertThat().body("result.description.size()", Matchers.is(6));
	//response.then().log().all().assertThat().body("result.description", Matchers.equalTo(description));
	
	}
	


	@Then("validate the status code as {int}")
	public void validate_the_status_code(int code) {
		
		response.then().log().all().assertThat().statusCode(code);

	}

	@Then("Validate if the incident is deleted")
	public void validate_if_the_incident_is_deleted() {
		
		response.then().log().all().assertThat().body("result.sys_id", Matchers.not("bdeafe6397012110b5c3bbc3f153af9c"));

	}

	
	
}



