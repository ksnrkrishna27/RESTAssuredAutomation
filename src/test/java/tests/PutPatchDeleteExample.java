package tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class PutPatchDeleteExample {
	JSONObject reqBody;
	
	
	public PutPatchDeleteExample() {
		baseURI = "https://reqres.in/api";
		
		reqBody = new JSONObject();
		
		reqBody.put("name", "morpheus");
		reqBody.put("job","zion resident");
	}
	
	@Test
	public void putTest() {
		
		given().
			header("x-api-key","reqres-free-v1").
			body(reqBody.toJSONString()).
		when().
			put("/users/2").
		then().
			statusCode(200).
			log().all();
		
	}
	
	@Test
	public void patchTest() {
		given().
			header("x-api-key","reqres-free-v1").
			body(reqBody.toString()).
		when().
			patch("/users/2").
		then().
			statusCode(200).
			log().all();
		
	}
	
	@Test
	public void deleteTest() {
		given().
			header("x-api-key","reqres-free-v1").
		when().
			delete("/users/2").
		then().
			statusCode(204);
	}

}
