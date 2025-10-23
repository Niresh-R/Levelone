package testcases;
import static io.restassured.RestAssured.*;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;
import pojo.DataObject;
import pojo.PostCall;

public class CaseTwo {
	
	@Test (priority = 1)
	void createObject() {

		DataObject requestData = new DataObject();
		requestData.setYear(2027);
		requestData.setPrice(1200000.89);
		requestData.setHarddisksize("10 TB");
		requestData.setCPUmodel("Intel Core i17");
		
		PostCall request = new PostCall();
		request.setName("Apple MacBook Pro 27");
		request.setData(requestData);

		given()
		    .header("Content-type","application/json")
		    .body(request)

		.when()
		    .post("https://api.restful-api.dev/objects")
		    
		 .then()
		      .statusCode(200)
		     .assertThat().body(JsonSchemaValidator.matchesJsonSchema(new File("src/test/resources/schema/productCreation.json")))
		     .log().all();
	}

}
