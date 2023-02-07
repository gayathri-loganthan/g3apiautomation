package JIRAProject;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteJIRAIssue {

	@Test
	public void Delete_JIRA_Issue( ) {
	
	RestAssured.baseURI = "https://g3restapi2023.atlassian.net/rest/api/2";
	
	RestAssured.authentication = RestAssured.preemptive().basic("gdevi.g3@gmail.com","E9EihJZorPKhkJp5dcml153B");
	
	RequestSpecification inputRequest = RestAssured.given().contentType("application/json");
	
	Response response = inputRequest.delete("/issue/10038");
	System.out.println(response.statusCode());
	
	response.prettyPrint();
	
	
	
}
}
