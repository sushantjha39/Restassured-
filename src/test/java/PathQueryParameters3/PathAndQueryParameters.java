package PathQueryParameters3;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;
public class PathAndQueryParameters {
	@Test
	void testQueryAndPathParameters() {
		//https://reqres.in/api/users?page=2&id=5
		given()
		.pathParam("mypath1","api")
		.pathParam("mypath2","users") //path parameters
		.queryParam("page",2) //query parameter 1 no need to put it in the link
		.queryParam("id",5)//query parameter 2
		.when()
			.get("https://reqres.in/{mypath1}/{mypath2}") //my path is already declared under path parameter
		.then()
		.statusCode(200)
		.log().all();
		
	}
}
