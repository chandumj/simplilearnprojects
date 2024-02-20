package assignments;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Assignment002 {
	Logger logger =  LogManager.getLogger(Assignment002.class);
    
    public String testData(String env) {
        Map<String, String> testdata=new HashMap<String, String>();
        testdata.put("DEV", "available_DEV");
        testdata.put("QA", "available_QA");
        testdata.put("PROD", "available_PROD");
       
        String data= testdata.get(env);
        return data;
    }
	
    @Parameters("Env")
	@Test
	public void putRequest(String Env) throws IOException {
    	 String filePath = "resources/Assignment002.json"; // Replace with your actual JSON file path

	        
	            // Read the content of the JSON file into a string
	            String jsonContent = new String(Files.readAllBytes(Paths.get(filePath)));

	            // Create a JSONObject from the JSON file content
	            JSONObject jsonObject = new JSONObject(jsonContent);
		
		
		jsonObject.put("status", testData(Env));
		
		
logger.info(" pahse End project - Assignment002- PUT Request");
		
		//File file=new File("resources/PhaseEndassignment001Jsonbody.json");
		int id=20021;
		 RestAssured.given()
				.baseUri("https://petstore.swagger.io/v2/pet")
				.contentType(ContentType.JSON)
				.body(jsonObject.toString(2))
				.when().put()
				.then().statusCode(200)
				.log().all()
				.body("category.id", Matchers.equalTo(id),"status",Matchers.equalTo(testData(Env)));
				
				logger.debug(" The status code is checked");
				
				System.out.println(testData(Env));
				logger.info("Id has been captured and printed.");
	}
}
