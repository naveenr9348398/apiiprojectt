package resources;

public enum Apiresourcess {
	
	
	addplaceapi ("maps/api/place/add/json"),
	getplaceapi  ("maps/api/place/get/json"),
	deleteplaceapi ("maps/api/place/delete/json");
	private String resources;
	
	Apiresourcess(String resources){
		this.resources = resources;
	}
	
	public String getresources() {
		return resources;
	}
}
