package RestAPI_Testing;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PutPatchAnd {
	
	@Test
	public void put() {
		
		JSONObject posreq = new JSONObject();
		
		posreq.put("name", "Pavan");
		posreq.put("job", "QA Engineer");
		
		System.out.println(posreq);
		
		baseURI = "https://reqres.in/api";
		given().
			header("Content-Type", "application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(posreq.toJSONString()).
		when().
			put("/users/2").
		then().
			statusCode(200).and().log().all();
		
	}
	
	
	@Test
	public void patch() {
		
		JSONObject posreq = new JSONObject();
		
		posreq.put("name", "Pavan");
		posreq.put("job", "QA Engineer");
		
		System.out.println(posreq);
		
		baseURI = "https://reqres.in";
		given().
			header("Content-Type", "application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(posreq.toJSONString()).
		when().
			patch("/api/users/2").
		then().
			statusCode(200).and().log().all();
		
	}
	
	
	@Test
	public void delete() {
		
		baseURI = "https://reqres.in/api";
		
		when().
			delete("/users/2").
		then().
			statusCode(204).and().log().all();
		
	}

}
