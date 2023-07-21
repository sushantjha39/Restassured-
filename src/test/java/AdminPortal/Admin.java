 package AdminPortal;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.Random;
import com.github.javafaker.Faker;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;



public class Admin {
	 String bearerToken = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJkZW1vQHJlcGxpZ2VuLmNvbSIsImF1dGgiOiJST0xFX0FETUlOIiwidXNlck5hbWUiOiJTdXBlciBBZG1pbiIsInVzZXJJZCI6MSwiaXNWZXJpZmllZCI6dHJ1ZX0.XaH0AJUMPlwpV0RpOddgmAHdvaa5Y3dWymu-ThRGyOs";
	 int custId;
    @Test(priority = 1)
    void createCustomer() {
    	Faker faker = new Faker();
     String customerId =   faker.name().username();
    String email =  faker.internet().safeEmailAddress();
  
    	HashMap<String, Object> data = new HashMap<String, Object>();
    	data.put("customerId", customerId);
        data.put("customerName", "Ambuja cement");
        data.put("email", email);
        data.put("password", "Asdf345@");

        JSONArray rolesArray = new JSONArray();
        JSONObject roleObject = new JSONObject();
        roleObject.put("roleId", 2);
        rolesArray.put(roleObject);
        data.put("roles", rolesArray);
        data.put("kfComm2cEnabled", false);
        data.put("opcEnabled", true);

        JSONObject requestBody = new JSONObject(data);
 custId =given()
            .contentType("application/json")
            .header("Authorization", "Bearer " + bearerToken)
            .body(requestBody.toString())
        .when()
            .post("http://142.93.218.164:8092/spectrum/admin")
       
        .then()
         	.statusCode(200)
         	.log().all()
         	.extract().path("custId");
       System.out.println(custId);
    }
    @Test(priority = 2,dependsOnMethods = "createCustomer")
    void addKey() {
    	given().contentType("application/json")
        .header("Authorization", "Bearer " + bearerToken)
        .when()
    		.post("http://142.93.218.164:8092/spectrum/admin/license/" + custId +"/type/2")
    		.then().statusCode(201).log().all();
    }
}
