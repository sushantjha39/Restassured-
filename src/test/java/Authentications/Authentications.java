package Authentications;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;

import groovy.util.logging.Log;
import io.restassured.internal.support.FileReader;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.json.JSONObject;
import org.json.JSONTokener;
public class Authentications {
//	@Test
//	void testBasicAuthentication() {
//		given()
//			.auth().basic("postman","password")
//		.when()
//			.get("https://postman-echo.com/basic-auth")
//		.then()
//			.statusCode(200)
//			.body("authenticated",equalTo(true))
//			.log().all();
//	}
//	@Test
//	void testDigestAuthentication() {
//		given()
//			.auth().digest("postman","password")
//		.when()
//			.get("https://postman-echo.com/basic-auth")
//		.then()
//			.statusCode(200)
//			.body("authenticated",equalTo(true))
//			.log().all();
//	}
//	@Test
//	void testPreemptiveAuthentication() {
//		given()
//			.auth().preemptive().basic("postman","password")
//		.when()
//			.get("https://postman-echo.com/basic-auth")
//		.then()
//			.statusCode(200)
//			.body("authenticated",equalTo(true))
//			.log().all();
//	}
	@Test
	void testBearerTokenAuthentication()
	{	
		HashMap data = new HashMap();
     
        data.put("customerId", "John");
        data.put("customerName","Ambuja cement");
        data.put("email","asdf45@gmail.com");
        data.put("password", "Asdf345@");
        data.put("roles", "\"roleId\": 2");
        data.put("kfComm2cEnabled","false");
        data.put("opcEnabled","true");
		String bearerToken = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJkZW1vQHJlcGxpZ2VuLmNvbSIsImF1dGgiOiJST0xFX0FETUlOIiwidXNlck5hbWUiOiJTdXBlciBBZG1pbiIsInVzZXJJZCI6MSwiaXNWZXJpZmllZCI6dHJ1ZX0.XaH0AJUMPlwpV0RpOddgmAHdvaa5Y3dWymu-ThRGyOs";
		given()
			.header("Authorization","Bearer" + bearerToken)
		.when()
			.post("http://142.93.218.164:8092/spectrum/admin")
		.then()
			.statusCode(200)
			.log().all();
	}
	void OAuth1Authentication() {
		
		given()
			.auth().oauth("consumerKey","consumerSecrat","accessToken","tokenSecrate")
			.when()
			.get("url")
			.then()
			.statusCode(200).log().all();
		
	}
void OAuth2Authentication() {
		
		given()
			.auth().oauth2("Accestoken is passed here")
			.when()
			.get("url")
			.then()
			.statusCode(200).log().all();
		
	}
void apiKeyAuthentication() {
//	Method 1
//	given()
//		.queryParam("appid","value")//appid is API Key
//		.when()
//			.get("https://api.openweathermap.org/data/2.5/forecast/daily?q=Delhi&units=metric&cnt-7")
//			.then().statusCode(200);
	//Method 2
	given()
	.queryParam("appid","value")
	.pathParam("mypath","data/2.5/forecast/daily")
	.queryParam("q" ,"Delhi")
	.queryParam("units","metric")
	.queryParam("units","metric")
	.when()
	.get("https://api.openweathermap.org/{mypath}")
	.then();
}

}


