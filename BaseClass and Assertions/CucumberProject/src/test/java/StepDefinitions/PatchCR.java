package StepDefinitions;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class PatchCR extends baseclass {
	
	@Test(dependsOnMethods = "StepDefinitions.PutCR.Put_CR")
	public void Patch_CR() {
		
		inputRequest = RestAssured.given()
				.contentType("application/JSON")
				.queryParam("sysparm_fields", "description,short_description,sys_id,task_effective_number")
				.when().body("{\r\n"
		+ "    \"description\": \"Patch update desc with REST\",\r\n"
		+ "    \"test_plan\":\"Plan update2\"\r\n"
		+ "}");
		
		response = inputRequest.patch("/change_request/"+sys_id);
		response.then().assertThat().statusCode(200);
		response.then().assertThat().body("result.description", Matchers.containsString("Patch"));
		response.then().assertThat().body("result.task_effective_number", Matchers.equalTo(task_number));		
		
		
	}

}
