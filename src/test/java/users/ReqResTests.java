package users;

import io.restassured.internal.http.HTTPBuilder;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import restUtils.RestUtils;
import users.pojos.User;
import utils.JsonUtils;

import java.io.IOException;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

public class ReqResTests extends ReqResAPIs {

    /*@BeforeEach
    public void setup() {
        RestAssured.baseURI = "https://reqres.in";
        RestAssured.basePath = "/api";
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .build();
    }*/

    @Test
    public void loginTest() {
        given()
                .body("{\"email\": \"eve.holt@reqres.in\",\"password\": \"cityslicka\"}")
                .post("login")
                .then()
                .statusCode(200)
                .body("token", notNullValue());
    }

    @Test
    public void getSingleUserTest() {
        given()
                .get("users/2")
                .then()
                .statusCode(HttpStatus.SC_OK) //Revisar cada uno, SC_OK es 200
                .body("data.id", equalTo(2));
    }

    @Test
    public void createUserTest() throws IOException {
        //Map<String, Object> payload = Payloads.getCreateUserPayloadFromMap();
        User payload = Payloads.getCreateUserPaloadFromPojo();
        Response response = createUser(payload);
        Assertions.assertEquals(response.statusCode(), HttpStatus.SC_CREATED);
    }

    @Test
    public void deleteUserTest() {
        given()
                .delete("users/2")
                .then()
                .statusCode(HttpStatus.SC_NO_CONTENT);
    }

    @Test
    public void patchUserTest() {
        given()
                .body("{\"name\": \"jeff\",\"job\": \"zion resident\"}")
                .patch("user/2")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body("name", containsString("jeff"));
    }

    @Test
    public void putUserTest() {
        String nameUpdated = given()
                .body("{\"name\": \"jeff\",\"job\": \"qa\"}")
                .put("users/2")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body("name", equalTo("jeff"))
                .extract()
                .jsonPath()
                .getString("name");

        assertThat(nameUpdated, equalTo("jeff"));
    }
}
