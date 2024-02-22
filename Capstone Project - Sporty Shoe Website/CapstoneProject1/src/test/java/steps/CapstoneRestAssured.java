package steps;

import org.hamcrest.Matchers;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;

public class CapstoneRestAssured {

	@Given("User sends a get request to get product details")
	public void user_sends_a_get_request_to_get_product_details() {

		RestAssured.given().baseUri("http://localhost:8100").basePath("/get-shoes").when().get().then().statusCode(200)
				.log().body();
	}

	@Given("User sends get request to list user details")
	public void user_sends_get_request_to_list_user_details() {
		RestAssured.given().baseUri("http://localhost:8100").basePath("/get-users").when().get().then().statusCode(200)
				.log().body();

	}

	@When("User gives new product details, add the product")
	public void user_gives_new_product_details_add_the_product() {

		RestAssured.given().baseUri("http://localhost:8100").basePath("/add-shoe").queryParams("id", "1003")
				.queryParam("image", "img.png").queryParam("name", "Addidas").queryParam("category", "Running")
				.queryParam("sizes", "9").queryParam("price", "1000").when().post().then()
				.body("shoe", Matchers.hasEntry("id", 1003));

	}

	@When("User gives product id, delete the product")
	public void user_gives_product_id_delete_the_product() {

		RestAssured.given().baseUri("http://localhost:8100").basePath("/delete-shoe").queryParam("id", "1003").when()
				.delete().then().log().all();

	}

	@When("User gives product id and update data, update the product")
	public void user_gives_product_id_and_update_data_update_the_product() {

		RestAssured.given().baseUri("http://localhost:8100").basePath("/update-shoe").queryParams("id", "101")
				.queryParam("image", "img2.png").queryParam("name", "Sketchers").queryParam("category", "Walking")
				.queryParam("sizes", "9").queryParam("price", "5000").when().put().then()
				.body("shoe", Matchers.hasEntry("name", "Sketchers"));

	}

}
