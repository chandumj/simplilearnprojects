package assignments;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Assignment004 {

		@Test
		public void assignment004()
		{
			
			String url = "https://petstore.swagger.io/v2/user/login";
			RestAssured.given()
			.baseUri(url)
			.auth().preemptive().basic("Uname001", "@tt!tude")
			.when().get()
			.then().statusCode(200)
			.log().all()
			.body("message", Matchers.anything("logged in user session:1708422936501"));
			
		}
		

}
