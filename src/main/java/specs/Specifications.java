package specs;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import objects.User;

import static io.restassured.RestAssured.given;

public class Specifications {

    public static final String BASE_URL = "https://petstore.swagger.io/v2/";

    public static RequestSpecification SPEC = new RequestSpecBuilder()
            .setBaseUri(BASE_URL)
            .setContentType(ContentType.JSON)
            .setAccept(ContentType.JSON)
            .build();

    public ValidatableResponse createUser(User user) {
        return given().spec(SPEC)
                .when().body(user)
                .post(BASE_URL + "user")
                .then().log().all();
    }
}
