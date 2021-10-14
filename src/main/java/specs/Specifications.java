package specs;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.DecoderConfig;
import io.restassured.config.EncoderConfig;
import io.restassured.config.ObjectMapperConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import objects.User;

import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.mapper.ObjectMapperType.GSON;

public class Specifications {

    public static final String BASE_URL = "https://petstore.swagger.io/v2/";

    private static final RestAssuredConfig CONFIG = RestAssuredConfig.config()
            .decoderConfig(new DecoderConfig("UTF-8"))
            .encoderConfig(new EncoderConfig("UTF-8","UTF-8"))
            .objectMapperConfig(new ObjectMapperConfig(GSON));

    public static RequestSpecification SPEC = new RequestSpecBuilder()
            .setBaseUri(BASE_URL)
            .setContentType(ContentType.JSON)
            .setAccept(ContentType.JSON)
            .setConfig(CONFIG)
            .build();

    //POST
    public ValidatableResponse createUser(User user) {
        return given().spec(SPEC)
                .body(user)
                .when()
                .post("user")
                .then().log().all();
    }

    public ValidatableResponse createWithArray(List<User> users) {
        return given().spec(SPEC)
                .body(users)
                .when()
                .post("createWithArray")
                .then()
                .log().all();
    }

    public ValidatableResponse createWithList(List<User> users) {
        return given().spec(SPEC)
                .body(users)
                .when()
                .contentType(ContentType.JSON)
                .post("user/createWithList")
                .then()
                .log().all();
    }


    //GET
    public ValidatableResponse getUserByUsername(String username) {
        return given().spec(SPEC)
                .when()
                .body(username)
                .get("user/" + username)
                .then()
                .log().all();
    }

    public ValidatableResponse logUserIntoTheSystem(String username, String password) {
        return given().spec(SPEC)
                .body(username)
                .when()
                .get("user/" + "login?username=" + username + "&password=" + password)
                .then()
                .log().all();
    }

    public ValidatableResponse logout() {
        return given().spec(SPEC)
                .when()
                .get("user/logout")
                .then()
                .log().all();
    }

    //PUT
    public ValidatableResponse updateUser(String username, User newUser) {
        return given().spec(SPEC)
                .body(username)
                .body(newUser)
                .when()
                .put("user/" + username)
                .then()
                .log().all();
    }

    //DELETE
    public ValidatableResponse deleteUser(String username) {
        return given().spec(SPEC)
                .body(username)
                .when()
                .delete("user/" + username)
                .then()
                .log().all();
    }
}
