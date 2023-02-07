package prj.testleaf;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetAllCR {

	@Test
	public void getChangeReq() {
		
	RestAssured.baseURI = "https://dev89356.service-now.com/api/now/table";
    
    RestAssured.authentication=RestAssured.basic("admin","Soft2007!@");
    
    RequestSpecification inputRequest = RestAssured.given().accept("application/json")
    									.queryParam("sysparm_fields", "description,sys_id,short_description")
    									.queryParam("sysparm_limit", "5");
    
    Response response = inputRequest.get("/change_request");
    
    System.out.println(response.getStatusCode());
    
    response.prettyPrint();
}
}