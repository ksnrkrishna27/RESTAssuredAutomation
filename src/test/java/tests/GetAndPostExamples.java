package tests;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;
import org.junit.runner.Request;

public class GetAndPostExamples {
	
//	@Test
	public void testGet() {
		baseURI = "https://reqres.in/api";
		
		given().
			get("users?page=2").
		then().
			statusCode(200).
			body("data[2].first_name", equalTo("Tobias")).
			body("data.first_name",hasItems("Lindsay","Byron"));
		
	}
	
	@Test
	public void testPost() {
		baseURI = "https://reqres.in/api";
		
		JSONObject req = new JSONObject();
		
		req.put("name", "Rama");
		req.put("job", "Tester");
		
		System.out.println(">>>>>>>>>>> : "+req);
		
		
		
		given().
			header("x-api-key","reqres-free-v1").
			body(req.toJSONString()).
		when().
			post("/users").
		then().
			statusCode(201).
			log().all();
		
		
	}

}
