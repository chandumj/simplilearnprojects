package steps;

import java.io.File;
import static io.restassured.RestAssured.*;
import io.cucumber.java.en.Given;
import io.restassured.http.ContentType;

public class LessonEndProject {
	@Given("User sends a POST request to create a user and validate the repsonse")
	public void user_sends_a_post_request_to_create_a_user_and_validate_the_repsonse() {
		
	   File file = new File("resources/lessonenddata.json");
	   given().baseUri("https://reqres.in")
	   .basePath("/api/users")
	   .contentType(ContentType.JSON)
	   .body(file)
	   .when().post()
	   .then().statusCode(201).log().all();
		
	  
	}
	@Given("User sends a GET request to get user details and validate the repsonse")
	public void user_sends_a_get_request_to_get_user_details_and_validate_the_repsonse() {
	
		given().baseUri("https://reqres.in")
		   .basePath("/api/users/6")
		   .when().get()
		   .then().log().all();
		
	}
	@Given("User sends a Delete request to delete user details and validate the repsonse")
	public void user_sends_a_delete_request_to_delete_user_details_and_validate_the_repsonse() {
		
		given().baseUri("https://reqres.in")
		   .basePath("/api/users/2")
		   .when().delete()
		   .then().statusCode(204).log().all();
		
	
	}

}
