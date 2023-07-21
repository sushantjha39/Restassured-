package Postrequest2;

import org.testng.annotations.Test;

import com.google.gson.JsonObject;

import groovy.util.logging.Log;
import io.restassured.internal.support.FileReader;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;

public class DifferentPostRequest {
//	@Test(priority = 1)
//	void testPostusingHashMap() {
////Mostly used for small data
//		HashMap data = new HashMap();
//		data.put("name", "morpheus");
//		data.put("job", "zion resident");
//
//		// i n case of array
//		// String courseArr[] ={ "c","c++"};
//		// data.put("courses",courseArr);
//		given().contentType("application/json").body(data).when().post("https://reqres.in/api/users").then()
//				.statusCode(201).body("name", equalTo("morpheus")).body("job", equalTo("zion resident"))
//				.header("Content-Type", "application/json; charset=utf-8").log().all();
//		// in case array
//		// .body("courses[0]",equalTo("c"))
//		// .body("courses[1]",equalTo("c++"))
//	}
//
//	// deleting Record
//	@Test(priority = 2)
//	void testDelete() {
//		given().when().delete("https://reqres.in/api/users/1").then().statusCode(204);
//
//	}
//
//	// 2Post request using org.json
//	@Test(priority = 1)
//	void testPostusingJsonLibrary() {
//		JSONObject data = new JSONObject();
//		data.put("name", "morpheus");
//		data.put("job", "zion resident");
//
//		// in case of array
//		// String courseArr[] ={ "c","c++"};
//		// data.put("courses",courseArr);
//
//		given().contentType("application/json").body(data.toString()) // in this case need to convert data into string.
//				.when().post("https://reqres.in/api/users").then().statusCode(201).body("name", equalTo("morpheus"))
//				.body("job", equalTo("zion resident")).header("Content-Type", "application/json; charset=utf-8").log()
//				.all();
//	}
//
//	@Test(priority = 2)
//	void delete() {
//		given().when().delete("https://reqres.in/api/users/1").then().statusCode(204);
//	}

//	// 3Post request body using POJO class
//	//@Test(priority = 1)
//	void testPostusingPOJO() {
//		Pojo_PostRequest data = new Pojo_PostRequest();
//		data.setName("morpheus");
//		data.setJob("zion resident");
//		given().contentType("application/json").body(data) 
//				.when().post("https://reqres.in/api/users").then().statusCode(201).body("name", equalTo("morpheus"))
//				.body("job", equalTo("zion resident")).header("Content-Type", "application/json; charset=utf-8")
//				.log().all();
//	}
//
//	//@Test(priority = 2)
//	void deletes() {
//		given().when().delete("https://reqres.in/api/users/1").then().statusCode(204);
//	}
	
	// 4Post request body using External json files class
		@Test(priority = 1)
		void testPostusingExternalJsonFile() throws FileNotFoundException {
			File f = new File(".\\Body.json");
			//file reader
			java.io.FileReader fr = new java.io.FileReader(f);
			JSONTokener jt = new JSONTokener(fr);
			JSONObject data = new JSONObject(jt);
			//convert to string 
			given()
				.contentType("application/json").body(data.toString()) 
					.when().post("https://reqres.in/api/users")
					.then().statusCode(201).body("name", equalTo("morpheus"))
					.body("job", equalTo("zion resident")).header("Content-Type", "application/json; charset=utf-8")
					.log().all();
		}

		@Test(priority = 2)
		void deleted() {
			given().when().delete("https://reqres.in/api/users/1").then().statusCode(204);
		}

}
