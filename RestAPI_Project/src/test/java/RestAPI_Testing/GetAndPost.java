package RestAPI_Testing;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;

import static io.restassured.RestAssured.*;
public class GetAndPost {
	
	/*@Test
	public void getreq() {
		
		baseURI = "https://reqres.in/api";
		given().
			get("/users?page=2").
		then().
			body("data[4].first_name" , equalTo("George")).
			body("data.first_name" , hasItems("Lindsay", "Tobias"));
	}*/
	
	@Test
	public void postreq() {
		
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
			post("/users").
		then().
			statusCode(201).and().log().all();
		
	}

}
