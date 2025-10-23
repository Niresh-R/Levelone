package testcases;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;
import pojo.DataObject;
import pojo.PostCall;

public class CaseThree {
	
	@Test (priority = 1)
	void createObject() {
		
		
		
		DataObject requestData = new DataObject();
		requestData.setYear(2019);
		requestData.setPrice(2049.99);
		requestData.setHarddisksize("1 TB");
		requestData.setCPUmodel("Intel Core i9");
		requestData.setColor("Red");
		
		PostCall request = new PostCall();
		request.setName("Apple MacBook Pro 16");
		request.setData(requestData);

		given()
		    .header("Content-type","application/json")
		    .body(request)
  
		.when()
		    .put("https://api.restful-api.dev/objects/ff8081819782e69e0199e28981013c5e")
		    
		 .then()
		 
		      .statusCode(200)
		     .assertThat().body(JsonSchemaValidator.matchesJsonSchema(new File("src/test/resources/schema/update.json")));
	}

}
