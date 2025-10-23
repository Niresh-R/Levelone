package client;

import io.restassured.response.Response;
import pojo.PostCall;

import java.util.HashMap;
import java.util.Map;

public class UserClient extends BaseClient {

    public UserClient(String baseUrl) {
        super(baseUrl);
    }

    public Response getObject(int userId) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", userId);
        return get("/objects/" + userId,params);
    }
    public Response getById(int userId){
        return get("/objects/" + userId,null);
    }

    public Response postNewProduct(PostCall userBody){
        return post("/objects" , userBody);
    }

    public Response updateProduct(String userId, PostCall userBody){
        return put("/objects/"  + userId , userBody);
    }

    public Response patchProduct(String userId, PostCall userBody){
        return patch("/objects/{id}", userBody, userId);
    }

    public Response deleteUser(String userId) {
        return delete("/users/" + userId);
    }

}
