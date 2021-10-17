package tests;

import Objects.Users;
import org.testng.annotations.Test;

public class CreateUserTest extends BaseTest {

    @Test
    public void createUserWithoutLogIntoTheSystemTest() {

        specifications.logout();

        specifications.createUser(Users.USER1)
                .statusCode(200);

        specifications.getUserByUsername(Users.USER1.getUsername())
                .statusCode(404);
        //'create user' shows 200 but 'get user method' doesn't work.
    }
}
