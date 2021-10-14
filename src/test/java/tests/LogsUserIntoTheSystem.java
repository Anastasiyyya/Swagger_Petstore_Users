package tests;

import Objects.Users;
import objects.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class LogsUserIntoTheSystem extends BaseTest {

    @Test(description = "Checks status code and value of 'type' and 'message' keys")
    public void logInWithCorrectUsernamePasswordTest() {

        specifications.logUserIntoTheSystem(Users.USER2.getUsername(),Users.USER2.getPassword())
                .body("type", equalTo("unknown"),
                        "message", containsString("logged in user session"))
                .statusCode(200);

        specifications.createUser(Users.USER3)
                .body("type", equalTo("unknown"),
                        "message", containsString(String.valueOf(Users.USER3.getUserStatus())))
                .statusCode(200);

        User createdUser = specifications.getUserByUsername(Users.USER3.getUsername()).extract().body().as(User.class);

        Assert.assertEquals(createdUser, Users.USER3);
    }
}
