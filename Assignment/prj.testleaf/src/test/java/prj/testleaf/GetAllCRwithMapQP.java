package prj.testleaf;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetAllCRwithMapQP {

	@Test
	public void getChangeReq() {
		
	RestAssured.baseURI = "https://dev89356.service-now.com/api/now/table";
    
    RestAssured.authentication=RestAssured.basic("admin","Soft2007!@");
    
    Map<String,String> multipleQP=new HashMap<String,String>();
    multipleQP.put("sysparm_fields", "description,sys_id,short_description");
    multipleQP.put("sysparm_limit", "1");
    
    
    RequestSpecification inputRequest = RestAssured.given().accept("application/json")
    									.queryParams(multipleQP);
    									//.queryParam("sysparm_fields", "description,sys_id,short_description")
    									//.queryParam("sysparm_limit", "5");
    
    Response response = inputRequest.get("/change_request");
    
    System.out.println(response.getStatusCode());
    
    response.prettyPrint();
}
}