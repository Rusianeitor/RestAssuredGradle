import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;

import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

public class ReqResTests {

    @BeforeEach
    public void setup(){
        RestAssured.baseURI="https://reqres.in";
        RestAssured.basePath="/api";
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        RestAssured.requestSpecification=new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .build();
    }

    @Test
    public void loginTest(){
        given()
                .body("{\"email\": \"eve.holt@reqres.in\",\"password\": \"cityslicka\"}")
                .post("login")
                .then()
                .statusCode(200)
                .body("token",notNullValue());
    }

    @Test
    public void getSingleUserTest(){
        given()
                .get("users/2")
                .then()
                .statusCode(HttpStatus.SC_OK) //Revisar cada uno, SC_OK es 200
                .body("data.id",equalTo(2));
    }

    @Test
    public void deleteUserTest(){
        given()
                .delete("users/2")
                .then()
                .statusCode(HttpStatus.SC_NO_CONTENT);
    }

    @Test
    public void patchUserTest(){
        given()
                .body("{\"name\": \"jeff\",\"job\": \"zion resident\"}")
                .patch("user/2")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body("name",containsString("jeff"));
    }

    @Test
    public void putUserTest(){
        String nameUpdated = given()
                .body("{\"name\": \"jeff\",\"job\": \"qa\"}")
                .put("users/2")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body("name",equalTo("jeff"))
                .extract()
                .jsonPath()
                .getString("name");

        assertThat(nameUpdated,equalTo("jeff"));
    }
}
