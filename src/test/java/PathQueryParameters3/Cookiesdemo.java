package PathQueryParameters3;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import java.util.Map;

public class Cookiesdemo {
	@Test(priority = 1)
	void testCookies()
	{
		given()
		
		.when()
			.get("https://www.google.com")
		.then()
		.cookie("AEC","Ad49MVFU5VAP9b5XU49RztrwlgDrZ6V5Ysh6j-Qifgq7nslJr6MYhL902A")// cookies validation
			.log().all();
	}
	
	//capture all cookies name
	@Test(priority = 2)
	void getCookiesInfo()
	{
		Response res = given()
		
		.when()
			.get("https://www.google.com");
		//get single cookies info
		
//		String cookie_value = res.getCookie("AEC");
//		System.out.println("value of cookie is "+ cookie_value);
		
		//get all cookies info
		Map<String,String> cookies_values= res.getCookies();
		System.out.println(cookies_values.keySet()); // getting all keys info
		
		for(String k:cookies_values.keySet())
		{
			String cookie_value = res.getCookie(k);
			System.out.println(k+"    "+cookie_value);
		}
	}
}
