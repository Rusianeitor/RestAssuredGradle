package users;

import io.restassured.response.Response;
import restUtils.RestUtils;
import users.pojos.User;

import java.util.Map;

public class ReqResAPIs {

    public Response createUser(Map<String, Object> createUserPayload){
        String endPoint = (String) Base.dataFromJsonFile.get("createUsersEndpoint");
        return  RestUtils.performPost(endPoint, createUserPayload);
    }

    public Response createUser(User createUserPayload){
        String endPoint = (String) Base.dataFromJsonFile.get("createUsersEndpoint");
        return  RestUtils.performPost(endPoint, createUserPayload);
    }
}
