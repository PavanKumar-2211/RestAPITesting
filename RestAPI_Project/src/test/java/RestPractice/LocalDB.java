package RestPractice;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;


public class LocalDB {
	
	//@Test
	public void get() {
		
		baseURI = "http://localhost:3000";
		
		given().
			get("/users").
		then().
			statusCode(200);
	}
	
	//@Test
	public void post() {
		
		JSONObject req = new JSONObject();
		req.put("name", "Harish");
		req.put("email", "harish@gmail.com");
		
		baseURI = "http://localhost:3000";
		
		given().
			accept(ContentType.JSON).
			body(req.toJSONString()).
		when().
			post("/users").
		then().
			statusCode(201).log().all();
	}
	
	//@Test
	public void put() {
		
		JSONObject req = new JSONObject();
		req.put("name", "Vennela");
		req.put("email", "Vennela@gmail.com");
		
		baseURI = "http://localhost:3000";
		
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(req.toJSONString()).
		when().
			post("/users").
		then().
			statusCode(200).log().all();
	}
	
	//@Test
	public void patch() {
		
		JSONObject req = new JSONObject();
		//req.put("name", "Vennela");
		req.put("email", "Vennela123@gmail.com");
		
		baseURI = "http://localhost:3000";
		
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(req.toJSONString()).
		when().
			patch("/users/KDXuZKISGvE").
		then().
			statusCode(200).log().all();
	}
	
	@Test
	public void delete() {
		
		baseURI = "http://localhost:3000";
		when().delete("/users/f6lVovRHOTA").then().statusCode(200).log().all();
	}
	
	

}
