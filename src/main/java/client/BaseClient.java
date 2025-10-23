package client;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


import java.util.Map;

public class BaseClient {

    private String baseUrl;

    public BaseClient(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public Response get(String endPoint, Map<String, ?> params) {
        RequestSpecification request = RestAssured
                .given()
                .baseUri(baseUrl)
                .header("Content-type", "application/json");
        if (params != null &&!params.isEmpty()) {
            request.queryParams(params);
        }
        return request.get(endPoint);

    }

    public Response post(String endpoint, Object body){
        RequestSpecification request = RestAssured
                .given()
                .baseUri(baseUrl)
                .header("Content-type","application/json")
                .body(body);
        return request.post (endpoint);

    }

    public Response put(String endpoint, Object body){
        RequestSpecification request = RestAssured
                .given()
                .baseUri(baseUrl)
                .header("Content-type","application/json")
                .body(body);
        return request.put(endpoint);

    }

    public Response patch(String endpoint, Object body ,Object param) {
        RequestSpecification request = RestAssured
                .given()
                .baseUri(baseUrl)
                .header("Content-type", "application/json")
                .body(body);
        return request.patch(endpoint,param);
    }

    public Response delete(String endpoint){
        RequestSpecification request = RestAssured
                .given()
                .baseUri(baseUrl);
        return request.delete(endpoint);
    }


}

