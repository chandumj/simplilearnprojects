package assignments;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Assignment003 {

		@Test
		public void assignment003()
		{
			
			String url = "https://petstore.swagger.io/v2/user/Uname001";
			RestAssured.given()
			.baseUri(url)
			.when().get()
			.then().statusCode(200)
			.log().all()
			.body("username", Matchers.equalTo("Uname001"))
			.body("email", Matchers.equalTo("Positive@Attitude.com"))
			.body("userStatus",Matchers.equalTo(1));
			
		}

}
