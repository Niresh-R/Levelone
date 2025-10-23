package testcases;

import io.qameta.allure.testng.AllureTestNg;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pojo.DataObject;
import pojo.PostCall;
import utils.dataGenerator.TestData;
import client.UserClient;
import utils.jsonUtills.JsonUtils;
import utils.responceValidator.ResponseValidator;

@Listeners({io.qameta.allure.testng.AllureTestNg.class})
public class TestCases {

     UserClient client = new UserClient("https://api.restful-api.dev");
    @Test
    void CaseOne(){
        Response response =  client.getById(7);
        Assert.assertEquals(response.statusCode(),200);
        Assert.assertEquals(response.jsonPath().getString("name"),"Apple MacBook Pro 16");
        System.out.println(response.getBody().asString());
    }

    @Test
    void CaseTwo(){
        DataObject requestData = new DataObject();
        requestData.setYear(2027);
        requestData.setPrice(1200000.89);
        requestData.setHarddisksize("10 TB");
        requestData.setCPUmodel("Intel Core i17");

        PostCall request = new PostCall();
        request.setName("Apple MacBook Pro 27");
        request.setData(requestData);

        Response response =  client.postNewProduct(request);
        ResponseValidator.validateStatsCode(response);
        Assert.assertEquals(response.jsonPath().getString("name"),"Apple MacBook Pro 27");

    }

    @Test
    void Casethree(){
        DataObject requestData = new DataObject();
        requestData.setYear(2019);
        requestData.setPrice(TestData.getRandomPrice());
        requestData.setHarddisksize("1 TB");
        requestData.setCPUmodel("Intel Core i9");
        requestData.setColor("Red");

        PostCall request = new PostCall();
        request.setName("Apple MacBook Pro 16");
        request.setData(requestData);

        Response response =  client.updateProduct("ff8081819782e69e0199e28981013c5e",request);
        Assert.assertEquals(response.statusCode(),200);
        Assert.assertEquals(response.jsonPath().getString("name"),"Apple MacBook Pro 16");

    }
    @Test
    void Casefour(){

        PostCall request = new PostCall();
        request.setName("Apple MacBook Pro 16 (Updated Name)");

        Response response =  client.patchProduct("ff8081819782e69e0199e28981013c5e",request);
        Assert.assertEquals(response.statusCode(),200);
        Assert.assertEquals(response.jsonPath().getString("name"),"Apple MacBook Pro 16 (Updated Name)");

    }

    @Test
    void CaseFive(){
        Response response = client.postNewProduct(JsonUtils.readJsonFile("src/test/resources/testdata/productCreation.json", PostCall.class));
        Assert.assertEquals(response.statusCode(),200);
        Assert.assertEquals(response.jsonPath().getString("name"),"Apple MacBook Pro 16");
    }


}
