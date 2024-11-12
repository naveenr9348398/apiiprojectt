package stepdefinitions;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {

	@Before("@Deleteplace")
	public void getdeleteplace() throws IOException {
		
		
		stepdefinations s = new stepdefinations();
		if(stepdefinations.placeid==null) {
		s.user_needs_to_add_the_add_place_payload_with("-54.5959","-54.5950","50","naveen","phone","address","type1","type2","website","language");
	    s.user_needs_to_uset_the_with_using_http_request("addplaceapi", "POST");
	    s.user_needs_to_verify_using("naveen", "getplaceapi");
		}
	
	}
}
