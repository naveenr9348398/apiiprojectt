package stepdefinitions;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.gmapsresponsebody;
import pojo.location;
import resources.Apiresourcess;
import resources.Utils;
import resources.addplaceresources;

public class stepdefinations extends Utils {
	
	ResponseSpecification resspec;
	RequestSpecification request;
	Response res;
	addplaceresources ap = new addplaceresources();
public static String placeid;
	
	@Given("User needs to Add the Add place payload with {string} {string} {string} {string} {string} {string} {string} {string} {string} {string}")
	public void user_needs_to_add_the_add_place_payload_with(String lat, String longitude, String accuracy, String name, String phone, String address, String type1, String type2, String website, String language) throws IOException {

		
 resspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();		
		
request =		given()
		.spec(reqspe()).body(ap.addplace(lat,longitude,accuracy,name,phone,address,type1,type2,website,language));
	}
	@When("User needs to uset the {string} with using {string} http request")
	public void user_needs_to_uset_the_with_using_http_request(String resource, String httpmethod){
     Apiresourcess methods =		Apiresourcess.valueOf(resource);
     System.out.println(methods.getresources());
     
        if(httpmethod.equalsIgnoreCase("POST")) {
      
		res =		request.when().post(methods.getresources());
        }
        else if(httpmethod.equalsIgnoreCase("GET")) {
        	res =		request.when().get(methods.getresources());
        }
	}
	@Then("User needs to check if the status code is {int}")
	public void user_needs_to_check_if_the_status_code_is(Integer int1) {
	assertEquals(res.getStatusCode(),200);
	}
	
	@Then("User needs to check if {string} the response body is {string}")
	public void user_needs_to_check_if_the_response_body_is(String key, String value) {
    
     assertEquals(getjsonpath(res, key),value);
	  }
	
	@Then("User needs to verify {string} using {string}")
	public void user_needs_to_verify_using(String expectedname, String resource) throws IOException {
        placeid = getjsonpath(res, "place_id");
	
		request =		given().spec(reqspe()).queryParam("place_id", placeid);
		user_needs_to_uset_the_with_using_http_request(resource, "GET");
		String actualname = getjsonpath(res, "name");
		assertEquals(expectedname,actualname);
	  
	}
	
	@Given("User needs to Add the Delete place payload")
	public void user_needs_to_add_the_delete_place_payload() throws IOException {
		request =		given().spec(reqspe()).body(ap.getdeleteplacebody(placeid));
	}
	
	
	

}
