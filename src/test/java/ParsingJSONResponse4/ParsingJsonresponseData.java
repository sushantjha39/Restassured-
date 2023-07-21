package ParsingJSONResponse4;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class ParsingJsonresponseData {
	/*	@Test(priority = 1)
	void testJsonResponse() {
		
		//approach 1
		//Can be used when less data is available in response
		given()
			.contentType("ContentType.JSON")
		.when()
			.get("https://reqres.in/api/users?page=2")
		
		.then()
			.statusCode(200)
			.header("Content-Type","application/json; charset=utf-8")
			.body("data[5].last_name",equalTo("Howell"));
	}*/
		//Approach 2
	@Test
void testentireResponse() {
		
		Response res = given()
			.contentType(ContentType.JSON)
		.when()
			.get("https://reqres.in/api/users?page=2");
		Assert.assertEquals(res.getStatusCode(),200 ); //validation 1
		Assert.assertEquals(res.header("Content-Type"),"application/json; charset=utf-8");
		
		String firstname = res.jsonPath().get("data[4].first_name").toString();
		Assert.assertEquals(firstname,"George");
	}
	
	//different validatsions
	
	@Test
	void diffTestResponse() {
			
			Response res = given()
				.contentType(ContentType.JSON)
			.when()
				.get("https://reqres.in/api/users?page=2");
			
			//JSONObject (jo) --> JSONArray(Name of array i.e data --> JSONObjects by indexing we are extracting mail id
			JSONObject jo = new JSONObject(res.asString());
			
			for (int i=0;i<jo.getJSONArray("data").length();i++)
			{
				//in this we are getting data from data array and going to 0 json object to get email and coverting them to string
				String Personemail = jo.getJSONArray("data").getJSONObject(i).get("email").toString();
				System.out.println(Personemail);
			}
	}
}
