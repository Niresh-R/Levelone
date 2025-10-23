package testcases;
import static io.restassured.RestAssured.*;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;

public class CaseOne {
	

	@Test (priority = 1)
	void get() {
		
		when()
		    .get("https://api.restful-api.dev/objects/7")
		    
		.then()
		     .statusCode(200)
		     .assertThat()
		     .body(JsonSchemaValidator.matchesJsonSchema(new File("src/test/resources/schema/singleObject.json")))
		     .log().all();
		
	}

}
