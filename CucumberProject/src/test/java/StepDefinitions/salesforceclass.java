package StepDefinitions;

import java.util.Map;
import java.util.Map.Entry;

import org.hamcrest.Matchers;

import io.cucumber.datatable.DataTable;

//import com.sun.tools.classfile.CharacterRangeTable_attribute.Entry;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class salesforceclass {
	
	static RequestSpecification request;
	static Response response;
	static String ID;
	static String Name;
	static String SF_Lead_ID;
	static String LeadName;
	static String accesstoken;
	
	@Given("Send the SalesForce URI")
	public void send_the_sales_force_uri() {
	   RestAssured.baseURI = "https://firstabudhabibank-dev-ed.develop.my.salesforce.com/services/data/v22.0/sobjects";
	}
	
	
	@Given("Enter the URL for access token generation")
	public void Enter_the_URL_for_access_token_generation() {
		
	   RestAssured.baseURI = "https://login.salesforce.com/services/oauth2/token";
	}
	
	
	
	@Given("Enter the grant type {string} and {string} and {string} and {string} and {string} and generate access token")
	public void enter_the_grant_type(String grant, String client_id, String client_secret, String username, String password) {
		
		RequestSpecification request = RestAssured.given()
				
				.queryParam("grant_type", "password")
				.queryParam("client_id", "3MVG9DREgiBqN9WlUgrL9xmAS10fHfFznRfYob21ViNmxI9TQxE17VCBnMuuumZb.aDk4qcYyMDhxk2uiwGBL")
				.queryParam("client_secret", "F6823BC4F1B4B2558975D024531E23BACFC6239E42A2B98B2BAF7955F90496E7")
				.queryParam("username", "gdevi.g3@sales.sandbox")
				.queryParam("password", "Soft2007!@")
				
				.header("Content-Type", "application/JSON");
		
		Response response = request.post();
		
		//int status_code = response.getStatusCode();
		//String response_body = response.asString();
		
		response.prettyPrint();
		
		accesstoken = response.jsonPath().get("access_token");
		System.out.println(accesstoken);
		
		//System.out.println("----status_code-----" +status_code);
		//System.out.println("----response_body-----" +response_body);
		
		
	}
	
	@And("Pass the access token")
	public void Pass_the_access_token() {
	
		RestAssured.authentication = RestAssured.oauth2(accesstoken);
}
	
	
	//@And("Pass the SalesForce auth")
	//public void pass_the_sales_force_auth() {
			
		//RestAssured.authentication = RestAssured.oauth2("00D8d000009qHuE!AQcAQJS0tHnXxbClFW9RFdczVTxE2e4fVnN8TmK1cXhFsvCXkGd8WmV3H885uiW_LgfV2DtcjtaV3Crp6VM1wEXGIOcEI4ib");
			
	//}
	
	@When("Enter the {string} and {string}")
	public void enter_the_and(String FirstName, String LastName) {
		request = RestAssured.given().contentType("application/JSON").when()
				.body("{\r\n"
				+ "    \"FirstName\": \""+FirstName+"\",\r\n"
				+ "    \"LastName\": \""+LastName+"\"\r\n"
				+ "}");
		response = request.post("/Contact");
		ID = response.jsonPath().get("recentItems[0].Id");
		Name = response.jsonPath().get("recentItems[0].Name");
	}
	
	@Then("Validate first name contains firstname")
	public void validate_first_name_contains_firstname() {
		
		response.then().log().all().body("recentItems[0].Name", Matchers.containsString("Gayathri"));
			
		}
	
	@When("Modify mailing status")
	public void modify_mailing_status() {
		
		request = RestAssured.given().contentType("application/JSON").when().body("{\r\n"
				+ "    \"MailingState\": \"Update\"\r\n"
				+ "}");
		response = request.patch("/Contact/id/"+ID);
	}
	
	

	@Given("Get all the ID")
	public void get_all_the_id() {
		request = RestAssured.given().contentType("application/JSON");
		response = request.get("/Contact");
		
		ID = response.jsonPath().get("recentItems[0].Id");
		System.out.println(ID);
		
	}
	
	@Then("Validate status code {int}")
	public void validate_status_code(Integer code) {
		
		response.then().log().all().assertThat().statusCode(code);

	}
	
	//Lead 

	
	@When("Enter the {string} and {string} and {string}")
	public void enter_the_and(String LeadFirstName, String LeadLastName, String Company) {
		request = RestAssured.given().contentType("application/JSON").when()
					.body("{\r\n"
							+ "    \"FirstName\": \""+LeadFirstName+"\",\r\n"
							+ "    \"LastName\": \""+LeadLastName+"\",\r\n"
							+ "    \"Company\": \""+Company+"\"\r\n"
							+ "}");
		response = request.accept("application/JSON").post("/Lead");
		SF_Lead_ID = response.jsonPath().get("recentItems[0].Id");
		//LeadName = response.jsonPath().get("recentItems[0].Name");
		
	}
	

	
	@When("Delete Lead")
	public void delete_lead() {
		request = RestAssured.given();
		
		response = request.delete("/Lead/Id/"+SF_Lead_ID);
	}

	
	@Given("Get all the Lead")
	public void get_all_the_lead() {
		request = RestAssured.given().contentType("application/JSON");
		response = request.accept("application/JSON").get("/Lead");
		SF_Lead_ID = response.jsonPath().get("recentItems[0].Id");
		System.out.println(SF_Lead_ID);
	}


	@When("Update Company Name")
	public void update_company_name() {
		
		request = RestAssured.given().contentType("application/JSON").when()
					.body("{\r\n"
							+ "    \"Company\": \"TD\"\r\n"
							+ "}");
		
		response = request.patch("/Lead/Id/"+SF_Lead_ID);

	}
	
	@Then("Validate if the lead is deleted")
	public void validate_if_the_lead_is_deleted() {
		request = RestAssured.given().contentType("application/JSON");
		response = request.accept("application/JSON").get("/Lead");
		
		response.then().log().all().assertThat().body("result.id", Matchers.not(SF_Lead_ID));
		
		System.out.println(SF_Lead_ID + " deleted");
	}


}
