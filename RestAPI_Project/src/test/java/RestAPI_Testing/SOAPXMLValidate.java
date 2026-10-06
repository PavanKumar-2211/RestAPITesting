package RestAPI_Testing;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import static org.hamcrest.Matchers.equalTo;;

public class SOAPXMLValidate {
	
	@Test
	public void soapxmlvalidate() throws IOException {
		
		File file = new File("./SoapFiles/Add.xml");
		
		if(file.exists()) {
			
			System.out.println("  >> file exists.....");
		}
		
		FileInputStream fileinput = new FileInputStream(file);
		
		String reqbody = IOUtils.toString(fileinput, "UTF-8");
		
		baseURI = "http://www.dneonline.com/";
		
		given().
		contentType("text/xml").accept(ContentType.XML).
		body(reqbody).
		when().
			post("calculator.asmx").
		then().
			statusCode(200).log().all()
			.and().body("//*:AddResult.text()", equalTo("5"));
	}

}
