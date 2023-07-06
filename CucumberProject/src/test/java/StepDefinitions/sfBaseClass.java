package StepDefinitions;
	
	import org.testng.annotations.Test;

	import io.restassured.RestAssured;
	import io.restassured.response.Response;
	import io.restassured.specification.RequestSpecification;

	public class sfBaseClass {
	    
	    @Test
	    public void Bearermethod() 
	    {
	        
	        RestAssured.baseURI = "https://login.salesforce.com/services/oauth2/token";
	        //RestAssured.authentication=RestAssured.basic("admin","1t+ReKZ2woG*");
	        
	        RequestSpecification request = RestAssured.given()
	                .contentType("application/JSON").when()
	                .body("{\r\n"
	                + "        \"grant_type\": \"password\",\r\n"
	                + "        \"client_id\": \"3MVG9X12xD2kqQmbjLOAubPzm0LHnt6_0jFrGpLGMRNiMHzKDpuijSZ9gZySo5MWOKMmJ0RsDeEBlKltmhgA6\",\r\n"
	                + "        \"client_secret\": \"F31751608AD837E794EDE6CBA0991249686C7E011F23731262C036987E811B45\",\r\n"
	                + "        \"username\": \"mrajmona@yahoo.com\",\r\n"
	                + "        \"password\": \"Jumbo@123\"\r\n"
	                + "}");
	                
	        Response response = request.body("access_token").post();
	        
	        //System.out.println("response.access_token");
	        
	        response.prettyPrint();

	}
}

