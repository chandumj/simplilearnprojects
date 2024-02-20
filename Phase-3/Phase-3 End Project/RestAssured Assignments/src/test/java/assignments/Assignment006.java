package assignments;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Assignment006 {



	@Test
	public void assignment006()
	{
		String url = "https://petstore.swagger.io/v2/user/logout";
		RestAssured.given()
		.baseUri(url)
		.when().get()
		.then().statusCode(200)
		.body("message", Matchers.equalTo("ok"))
		.log().all();
		
		
	}
	

}
