package tests;

import java.util.HashMap;

import org.hamcrest.core.IsEqual;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

public class TestsExamples {
	
	@Test
	public void test_1() {
		Response output = get("https://reqres.in/api/users?page=2");
		System.out.println("output : "+output.statusCode());
		System.out.println("Response : "+output.getBody().asString());
		
		int statusCode = output.getStatusCode();
		
		Assert.assertEquals(statusCode, 200);
	}
	
	@Test
	public void test_2() {
		given().
			get("https://reqres.in/api/users?page=2").
		then().
			statusCode(200).
			body("data.last_name[1]", equalTo("Ferguson"));
		
	}

}
