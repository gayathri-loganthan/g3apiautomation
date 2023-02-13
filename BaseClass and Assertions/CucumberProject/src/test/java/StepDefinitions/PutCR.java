package StepDefinitions;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class PutCR extends baseclass {
	
	@Test(dependsOnMethods = {"StepDefinitions.PostCR.Post_CR"})
	public void Put_CR() {
	
	inputRequest = RestAssured.given()
					.contentType("application/JSON")
					.queryParam("sysparm_fields", "description,short_description,sys_id,task_effective_number")
					.when().body("{\r\n"
			+ "    \"description\": \"Update new desc with REST\",\r\n"
			+ "    \"test_plan\":\"Plan update2\"\r\n"
			+ "}");
	
	response = inputRequest.put("/change_request/"+sys_id);
	response.then().assertThat().statusCode(200);
	response.then().assertThat().body("result.description", Matchers.equalTo("Update new desc with REST"));
	
}

}