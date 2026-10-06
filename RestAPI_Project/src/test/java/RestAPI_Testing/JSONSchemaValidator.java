package RestAPI_Testing;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import org.testng.annotations.Test;


public class JSONSchemaValidator {
	
	@Test
	public void getreq() {
		
		baseURI = "https://reqres.in/api";
		given().
			get("/users?page=2").
		then().
			assertThat().body(matchesJsonSchemaInClasspath("Schema.json")).
			statusCode(200);
	}
	

}
