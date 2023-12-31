package restUtils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import users.pojos.User;

import java.util.Map;

public class RestUtils {
    public static Response performPost(String endPoint, String requestPayload, Map<String, String> headers){
        return RestAssured
                .given().log().all()
                .baseUri(endPoint)
                .headers(headers)
                .contentType(ContentType.JSON)
                .body(requestPayload)
                .post()
                .then().log().all()
                .extract().response();
    }

    public static Response performPost(String endPoint, String requestPayload){
        return RestAssured
                .given().log().all()
                .baseUri(endPoint)
                .contentType(ContentType.JSON)
                .body(requestPayload)
                .post()
                .then().log().all()
                .extract().response();
    }

    public static Response performPost(String endPoint, Map<String, Object> requestPayload){
        return RestAssured
                .given().log().all()
                .baseUri(endPoint)
                .contentType(ContentType.JSON)
                .body(requestPayload)
                .post()
                .then().log().all()
                .extract().response();
    }

    public static Response performPost(String endPoint, Object requestPayload){
        return RestAssured
                .given().log().all()
                .baseUri(endPoint)
                .contentType(ContentType.JSON)
                .body(requestPayload)
                .post()
                .then().log().all()
                .extract().response();
    }
}
