package StepDefinitions;

//import java.io.File;

import org.testng.annotations.Test;

//import io.restassured.RestAssured;

public class PostCR extends baseclass {
	
	@Test
	public void Post_CR() {
		
		//File file = new File(".src/test/resources/data/DataFileJs.JSON");
		

		response = inputRequest.post("/change_request");
		//System.out.println(response.getStatusCode());
		response.then().assertThat().statusCode(201);
		
		sys_id = response.jsonPath().get("result.sys_id");
		task_number = response.jsonPath().get("result.task_effective_number");
		
	}

}
