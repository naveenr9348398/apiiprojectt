package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.gmapsresponsebody;
import pojo.location;

public class addplaceresources {
	
	public gmapsresponsebody addplace(String string,String string2,String string3,String name,String phonenum,String address,String type1,String type2,String website,String language) {
		
		gmapsresponsebody		 gm = new gmapsresponsebody();
		location l = new location();
		l.setLat(string);
		l.setLng(string2);
		gm.setLocation(l);
		gm.setAccuracy(string3);
		gm.setName(name);
		gm.setPhone_number(phonenum);
		gm.setAddress(address);
		List<String> mylist = new ArrayList<String>();
		mylist.add(type1);
		mylist.add(type2);
		gm.setTypes(mylist);
		gm.setWebsite(website);
		gm.setLanguage(language);
		return gm;
	}


	public String getdeleteplacebody(String placeid) {
		return "{\r\n"
				+ "    \"place_id\":\""+placeid+"\"\r\n"
				+ "}";
	}

}
