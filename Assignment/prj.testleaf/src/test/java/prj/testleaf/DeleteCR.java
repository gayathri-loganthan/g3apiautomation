package prj.testleaf;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class DeleteCR {
	
	@Test
	
	public void Delete_CR( ) {
		
		RestAssured.baseURI = "https://dev89356.service-now.com/api/now/table/";
		RestAssured.authentication = RestAssured.basic("admin", "Soft2007!@");
		RequestSpecification inputRequest = RestAssured.given().contentType("application/json");
		
		Response response = inputRequest.delete("/change_request/a4efb9be97302110b5c3bbc3f153af44");
		
		ValidatableResponse statusCode = response.then().assertThat().statusCode(204);
		
		System.out.println(response.getStatusCode());
		response.prettyPrint();						
	}

	

}
