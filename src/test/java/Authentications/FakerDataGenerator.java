package Authentications;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class FakerDataGenerator {
	
	@Test
	void testGenerateDummyData() {
		Faker faker = new Faker();
		String fullname = faker.name().fullName();
		String firstname= faker.name().firstName();
		faker.name().lastName();
		faker.name().username();
		faker.internet().password();
		faker.phoneNumber().cellPhone();
		faker.internet().safeEmailAddress();
		faker.idNumber();System.out.println(fullname);;
	}
}
