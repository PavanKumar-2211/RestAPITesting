package RestAPI_Testing;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;

public class GetPostPutPatchDelete {
	
	@Test
	public void reqget() {
		
		baseURI = "https://jsonplaceholder.typicode.com/";
		given().
			get("/posts").
		then().statusCode(200).log().all();
		
	}
	
	@Test
	public void reqpost() {
		baseURI = "https://jsonplaceholder.typicode.com/";
		
		JSONObject req = new JSONObject();
		req.put("title", "Hello pavan kumar");
		req.put("body", "Your a good body in the world");
		
		given().
			body(req.toJSONString()).
		when().
			post("/posts").
		then().
			statusCode(201).log().all();
		
	}
	
	@Test
	public void reqput() {
		baseURI = "https://jsonplaceholder.typicode.com/";
		
		JSONObject req = new JSONObject();
		req.put("title", "Hello pavan kumar");
		req.put("body", "Your a good body in the world");
		
		given().
			body(req.toJSONString()).
		when().
			put("/posts/1").
		then().
			statusCode(200).log().all();
		
	}
	
	@Test
	public void reqpatch() {
		baseURI = "https://jsonplaceholder.typicode.com/";
		
		JSONObject req = new JSONObject();
		req.put("title", "Hello pavan kumar");
		req.put("body", "Your a good body in the world");
		
		given().
			body(req.toJSONString()).
		when().
			patch("/posts/1").
		then().
			statusCode(200).log().all();
		
	}
	
	@Test
	public void reqdelete() {
		baseURI = "https://jsonplaceholder.typicode.com/";
		
		when().
			patch("/posts/1").
		then().
			statusCode(200).log().all();
		
	}
	

}
