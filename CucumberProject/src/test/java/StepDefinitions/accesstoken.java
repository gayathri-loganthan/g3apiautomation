package StepDefinitions;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@Test

public class accesstoken {
	
	public void getAccessToken() {
		
		String url = "https://login.salesforce.com/services/oauth2/token";
		
		RequestSpecification http_req = RestAssured.given()
				
				.queryParam("grant_type", "password")
				.queryParam("client_id", "3MVG9DREgiBqN9WlUgrL9xmAS10fHfFznRfYob21ViNmxI9TQxE17VCBnMuuumZb.aDk4qcYyMDhxk2uiwGBL")
				.queryParam("client_secret", "F6823BC4F1B4B2558975D024531E23BACFC6239E42A2B98B2BAF7955F90496E7")
				.queryParam("username", "gdevi.g3@sales.sandbox")
				.queryParam("password", "Soft2007!@")
				
				.header("Content-Type", "application/JSON");
		
		Response response = http_req.post(url);
		
		int status_code = response.getStatusCode();
		String response_body = response.asString();
		
		System.out.println("----status_code-----" +status_code);
		System.out.println("----response_body-----" +response_body);
	}

}
