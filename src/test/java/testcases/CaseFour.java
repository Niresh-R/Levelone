package testcases;

import static io.restassured.RestAssured.given;
import java.io.File;
import org.testng.annotations.Test;
import io.restassured.module.jsv.JsonSchemaValidator;
import pojo.PostCall;

public class CaseFour {
	
	@Test (priority = 1)
	void createObject() {
		
		PostCall request = new PostCall();
		request.setName("Apple MacBook Pro 16 (Updated Name)");

		
		given()
		    .header("Content-type","application/json")
		    .body(request)
		    
		.when()
		    .patch("https://api.restful-api.dev/objects/ff8081819782e69e0199e28981013c5e")
		    
		 .then()
		      .statusCode(200)
		      .assertThat().body(JsonSchemaValidator.matchesJsonSchema(new File("src/test/resources/schema/patch.json")));

	}
}
