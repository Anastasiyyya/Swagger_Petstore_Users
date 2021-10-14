package tests;

import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;

public class GetUserByUserName extends BaseTest{

    @Test(description = "")
    public void getUserInvalidUsernameTest() {

        specifications.getUserByUsername("!!!")
                .body("type", equalTo("error"),
                        "message", equalTo("User not found"),
                        "code", equalTo(1))
                .statusCode(404);

    }

    @Test(description = "")
    public void getUserWithNonExistentUsernameTest() {

        specifications.getUserByUsername("user3000")
                .body("type", equalTo("error"),
                        "message", equalTo("User not found"),
                        "code", equalTo(1))
                .statusCode(404);

    }

    @Test(description = "")
    public void putInUsernameFieldEmptyStringTest() {

        specifications.getUserByUsername("")
                .body("type", equalTo("unknown"))
                .statusCode(405);

    }
}
