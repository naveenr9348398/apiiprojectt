package pojo;

import java.util.List;

public class gmapsresponsebody {

	private location location;
	private String accuracy;
	private String name;
	private String phone_number;
	private String address;
	private List <String> types;
	private String website;
	private String language;
	
	public location getLocation() {
		return location;
	}
	public void setLocation(location location) {
		this.location = location;
	}
	public String getAccuracy() {
		return accuracy;
	}
	public void setAccuracy(String string3) {
		this.accuracy = string3;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<String> getTypes() {
		return types;
	}
	public void setTypes(List<String> types) {
		this.types = types;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}

	
	
	
	
	
	
	
	
	
	
	
}