package tests;

import Objects.Users;
import org.testng.annotations.Test;

public class CreateUserTests extends BaseTest {

    @Test
    public void createUserWithLogIntoTheSystemTest() {

        specifications.deleteUser(Users.USER1.getUsername());

        specifications.createUser(Users.USER1)
                .statusCode(200);

        specifications.getUserByUsername(Users.USER1.getUsername())
                .statusCode(200);
    }

    @Test
    public void createUserWithoutLogIntoTheSystemTest() {

        specifications.deleteUser(Users.USER1.getUsername());

        specifications.logout();

        specifications.createUser(Users.USER1)
                .statusCode(200);

        specifications.getUserByUsername(Users.USER1.getUsername())
                .statusCode(200);
    }

    @Test
    public void createUserWithGivenBadRequestTest() {

        specifications.deleteUser(Users.INVALID_USER.getUsername());

        specifications.logout();

        specifications.createUser(Users.INVALID_USER)
                .statusCode(400);
    }
}
