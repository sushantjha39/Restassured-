package PathQueryParameters3;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;
public class LoggingDemo {
	@Test(priority = 1)
	void testLogs() 
	{
		given()
		.when()
			.get("https://www.google.co.in")
		.then()
		//can get each element separately
		.log().cookies();
		//.log().headers();
		//.log().body();
			//.log().all();
	}
}
