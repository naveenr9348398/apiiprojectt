package resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {
public static RequestSpecification req;
	
	public RequestSpecification reqspe() throws IOException {
		
		if(req==null)
		{
		PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
		  req = new RequestSpecBuilder()
				.setBaseUri(getglobaluri("globaluri"))
				.setContentType(ContentType.JSON)
				.addFilter(RequestLoggingFilter.logRequestTo(log))
				.addFilter(ResponseLoggingFilter.logResponseTo(log))
				.addQueryParam("key", "qaclick123").build();
	             return req;
		}
		return req;
	}
	
	
	public static String getglobaluri(String key) throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\navee\\eclipse-workspace\\cucumberapiframework\\src\\test\\java\\resources\\globalurl.properties");
		prop.load(fis);
	return	prop.getProperty(key);
	}
	
	public String getjsonpath(Response response,String key) {
		 String resp =	    response.asString();
	     JsonPath js = new JsonPath(resp);
	 return    js.get(key).toString();
	}
	
	
	
	
	
	

}
