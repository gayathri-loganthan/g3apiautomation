package JIRAProject;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateJIRAIssue {

	@Test
	public void Update_JIRA_Issue( ) {
	
	RestAssured.baseURI = "https://g3restapi2023.atlassian.net/rest/api/2";
	
	RestAssured.authentication = RestAssured.preemptive().basic("gdevi.g3@gmail.com","E9EihJZorPKhkJp5dcml153B");
	
	RequestSpecification inputRequest = RestAssured.given().contentType("application/json")
										.when().body("{\r\n"
												+ "    \"fields\": {\r\n"
												+ "\r\n"
												+ "        \"description\": \"Updated issue id 10040\"\r\n"
												+ "    }\r\n"
												+ "}");
	
	Response response = inputRequest.put("/issue/10040");
	System.out.println(response.statusCode());
	
	response.prettyPrint();
	
	
	
}
}
