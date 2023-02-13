package StepDefinitions;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class baseclass {
	
	static RequestSpecification inputRequest;
	static Response response;
	static String sys_id;
	static String task_number;

	
	@BeforeMethod
	public void BeforeMethod() {
		
		RestAssured.baseURI = "https://dev89356.service-now.com/api/now/table";
        
        RestAssured.authentication=RestAssured.basic("admin","Soft2007!@");
        
        inputRequest = RestAssured.given().contentType("application/JSON").accept("application/JSON")
        				.queryParam("sysparm_fields", "description,short_description,sys_id,task_effective_number");       
        
	}
	
	@AfterMethod
	public void After_Method() {
		
		response.then().log().all();
        
	}
	

}
