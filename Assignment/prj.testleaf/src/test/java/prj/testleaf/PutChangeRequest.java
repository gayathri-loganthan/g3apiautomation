package prj.testleaf;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PutChangeRequest {
	
	@Test 
	
	public void Put_Change_Request( ) {
		
		RestAssured.baseURI = "https://dev89356.service-now.com/api/now/table";
				
	    RestAssured.authentication = RestAssured.basic("admin", "Soft2007!@");
		
	    RequestSpecification inputRequest = RestAssured.given().contentType("application/json")
	    		                            .accept("application/xml")
	    									.queryParam("sysparm_fields", "description,sys_id,short_description")
	    									.when()
	    									.body("{\"description\":\"update CR\","
	    											+ "\"short_description\":\"update CR short desc\"}");
	    
	    Response response = inputRequest.put("/change_request/8d86c2b297702110b5c3bbc3f153afc9");
        System.out.println(response.getStatusCode());
        response.prettyPrint();
	    	
}

}
