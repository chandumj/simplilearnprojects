package assignments;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Assignment001 {

	Logger logger = LogManager.getLogger(Assignment001.class);

	/*
	 * @DataProvider(name = "testData") public Object[][] testData() { String
	 * csvFile = "resources/PhaseEndData.csv"; // Replace with your actual CSV file
	 * path
	 * 
	 * try { // Create a CSVReader and read data from the CSV file CSVReader reader
	 * = new CSVReader(new FileReader(csvFile)); List<String[]> data =
	 * reader.readAll();
	 * 
	 * // Convert the List of String arrays to a two-dimensional array Object[][]
	 * dataArray = new Object[data.size()][]; for (int i = 0; i < data.size(); i++)
	 * { dataArray[i] = data.get(i); }
	 * 
	 * return dataArray; } catch (Exception e) { e.printStackTrace(); return null; }
	 * 
	 * }
	 */

	@Parameters({ "id", "name" })
	@Test(priority = 1)
	public void postRequest(int id, String name) throws IOException {
		String filePath = "resources/PhaseEndassignment001Jsonbody.json"; // Replace with your actual JSON file path

		// Read the content of the JSON file into a string
		String jsonContent = new String(Files.readAllBytes(Paths.get(filePath)));

		// Create a JSONObject from the JSON file content
		JSONObject jsonObject = new JSONObject(jsonContent);

		jsonObject.put("id", id);
		jsonObject.put("name", name);

		logger.info(" pahse End project - Assignment001- Post Request");

		// File file=new File("resources/PhaseEndassignment001Jsonbody.json");

		int id2 = RestAssured.given().baseUri("https://petstore.swagger.io/v2/pet").contentType(ContentType.JSON)
				.body(jsonObject.toString(2)).when().post().then().statusCode(200).log().all()
				.body("name", Matchers.equalTo(name)).extract().path("id");

		logger.debug(" The status code is checked");

		System.out.println(id2);
		logger.info("Id has been captured and printed.");

	}

	@Parameters("id")
	@Test(priority = '2', dependsOnMethods = { "postRequest" })
	public void getRequest(int id) {
		String url = "https://petstore.swagger.io/v2/pet/"+id;
		RestAssured.given().baseUri(url).when().get().then().statusCode(200).log().all()
				.body("status", Matchers.equalTo("available")).body("id", Matchers.equalTo(id));

	}
	@Parameters("id")
	@Test(priority = '3', dependsOnMethods = { "postRequest" })
	public void deleteRequest(int id) {
		String url = "https://petstore.swagger.io/v2/pet/"+id;
		RestAssured.given().baseUri(url).when().delete().then().statusCode(200).log().all()
				.body("code", Matchers.equalTo(200)).body("message", Matchers.equalTo(id+""));

	}

}
