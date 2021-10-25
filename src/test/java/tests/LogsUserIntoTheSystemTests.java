package tests;

import Objects.Users;
import objects.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class LogsUserIntoTheSystemTests extends BaseTest {

    @Test
    public void logInWithCorrectUsernamePasswordTest() {

        specifications.logout()
                .body("type", equalTo("unknown"),
                        "message", containsString("ok"))
                .statusCode(200);

        specifications.logUserIntoTheSystem(Users.USER2.getUsername(),Users.USER2.getPassword())
                .body("type", equalTo("unknown"),
                        "message", containsString("logged in user session"))
                .statusCode(200);

        specifications.deleteUser(Users.USER3.getUsername());

        specifications.createUser(Users.USER3)
                .body("type", equalTo("unknown"),
                        "message", containsString(String.valueOf(Users.USER3.getUserStatus())))
                .statusCode(200);

        User createdUser = specifications.getUserByUsername(Users.USER3.getUsername()).extract().body().as(User.class);

        Assert.assertEquals(createdUser, Users.USER3);
    }

    @Test
    public void logInWithIncorrectPasswordTest() {
        specifications.logout()
                .body("type", equalTo("unknown"),
                        "message", containsString("ok"))
                .statusCode(200);

        specifications.logUserIntoTheSystem(Users.USER2.getUsername(),"IncorrectPSW")
                .body("type", equalTo("unknown"),
                        "message", containsString("logged in user session"))
                .statusCode(400);
    }

    @Test
    public void logInWithEmptyPasswordFieldTest() {
        specifications.logout()
                .body("type", equalTo("unknown"),
                        "message", containsString("ok"))
                .statusCode(200);

        specifications.logUserIntoTheSystem(Users.USER2.getUsername(),"")
                .body("type", equalTo("unknown"),
                        "message", containsString("logged in user session"))
                .statusCode(400);

        specifications.createUser(Users.USER3)
                .body("type", equalTo("unknown"),
                        "message", containsString(String.valueOf(Users.USER3.getUserStatus())))
                .statusCode(200);

        User createdUser = specifications.getUserByUsername(Users.USER3.getUsername()).extract().body().as(User.class);

        Assert.assertEquals(createdUser, Users.USER3);
    }

    @Test
    public void logInWithEmptyUsernameFieldTest() {
        specifications.logout()
                .body("type", equalTo("unknown"),
                        "message", containsString("ok"))
                .statusCode(200);

        specifications.logUserIntoTheSystem("",Users.USER2.getPassword())
                .body("type", equalTo("unknown"),
                        "message", containsString("logged in user session"))
                .statusCode(400);

        specifications.createUser(Users.USER3)
                .body("type", equalTo("unknown"),
                        "message", containsString(String.valueOf(Users.USER3.getUserStatus())))
                .statusCode(200);

        User createdUser = specifications.getUserByUsername(Users.USER3.getUsername()).extract().body().as(User.class);

        Assert.assertEquals(createdUser, Users.USER3);
    }

    @Test
    public void logInWithEmptyFieldsTest() {
        specifications.logout()
                .body("type", equalTo("unknown"),
                        "message", containsString("ok"))
                .statusCode(200);

        specifications.logUserIntoTheSystem("","")
                .body("type", equalTo("unknown"),
                        "message", containsString("logged in user session"))
                .statusCode(400);

        specifications.createUser(Users.USER3)
                .body("type", equalTo("unknown"),
                        "message", containsString(String.valueOf(Users.USER3.getUserStatus())))
                .statusCode(200);

        User createdUser = specifications.getUserByUsername(Users.USER3.getUsername()).extract().body().as(User.class);

        Assert.assertEquals(createdUser, Users.USER3);
    }
}
