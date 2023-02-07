package prj.testleaf;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateCR {
  
	    @Test
	    
	    public void CreateChangeReq() {
	        
	        RestAssured.baseURI = "https://dev89356.service-now.com/api/now/table";
	        
	        RestAssured.authentication=RestAssured.basic("admin","Soft2007!@");
	        
	        RequestSpecification inputRequest = RestAssured.given()
	                .contentType("application/JSON")
	                .queryParam("sysparm_fields","sys_id,short_description,description")
	                .when().body("{\r\n"
	                        + "    \"short_description\": \"Test Short Assignment des\",\r\n"
	                        + "        \"description\": \"Test Assignment description created\"\r\n"
	                        + "}");
	    
	        
	        Response response = inputRequest.post("/change_request");
	                System.out.println(response.getStatusCode());
	        response.prettyPrint();
	                

	        
	    }
	}

	
