package hooks;


import io.cucumber.java.Before;
import io.restassured.RestAssured;

public class hooksclass {
	
	@Before
	public void base_setup() {	
			RestAssured.baseURI = "https://dev89356.service-now.com/api/now/table";
			RestAssured.authentication=RestAssured.basic("admin","Soft2007!@");
	}
	

}
