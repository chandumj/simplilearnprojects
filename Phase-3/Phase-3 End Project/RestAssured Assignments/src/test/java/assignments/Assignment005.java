package assignments;


import org.hamcrest.Matchers;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Assignment005 {

	
		@Parameters("status")
		@Test
		public void assignment005_Status(String status)
		{
			String url = "https://petstore.swagger.io/v2/pet/findByStatus";
			RestAssured.given()
			.baseUri(url)
			.queryParam("status", status)
			.when().get()
			.then().statusCode(200)
			.body("status[0]", Matchers.equalTo(status))
			.log().all();
				
		}

}
