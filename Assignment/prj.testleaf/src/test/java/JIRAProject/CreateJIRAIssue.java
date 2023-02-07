package JIRAProject;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateJIRAIssue {

	@Test
	public void Create_JIRA_Issue( ) {
	
	RestAssured.baseURI = "https://g3restapi2023.atlassian.net/rest/api/2";
	
	RestAssured.authentication = RestAssured.preemptive().basic("gdevi.g3@gmail.com","E9EihJZorPKhkJp5dcml153B");
	
	RequestSpecification inputRequest = RestAssured.given().contentType("application/json")
										.when().body("{\r\n"
												+ "    \"fields\": {\r\n"
												+ "        \"project\": {\r\n"
												+ "            \"key\": \"G3TS\"\r\n"
												+ "        },\r\n"
												+ "        \"summary\": \"create issue in G3 Project\",\r\n"
												+ "        \"description\": \"Creating of an issue using project keys and issue type names using the POSTMAN\",\r\n"
												+ "        \"issuetype\": {\r\n"
												+ "            \"name\": \"Bug\"\r\n"
												+ "        }\r\n"
												+ "    }\r\n"
												+ "}");
	
	Response response = inputRequest.post("/issue");
	System.out.println(response.statusCode());
	
	response.prettyPrint();
	
	
	
}
}
