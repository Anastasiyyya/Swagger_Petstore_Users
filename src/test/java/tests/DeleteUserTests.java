package tests;

import Objects.Users;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;

public class DeleteUserTests extends BaseTest {

    @Test
    public void deleteUserWithExistUsernameTest() {

        specifications.logUserIntoTheSystem(Users.ADMIN.getUsername(),Users.ADMIN.getPassword());

        specifications.createWithList(Users.USERS_LIST_WITH_ONE_USER)
                .body("type", equalTo("unknown"),
                        "message", equalTo("ok"))
                .statusCode(200);

        specifications.getUserByUsername(Users.USERS_LIST_WITH_ONE_USER.get(0).getUsername())
                        .statusCode(200);

        specifications.deleteUser(Users.USERS_LIST_WITH_ONE_USER.get(0).getUsername())
                .body("type", equalTo("unknown"),
                        "message", equalTo(Users.USERS_LIST_WITH_ONE_USER.get(0).getUsername()))
                .statusCode(200);

        specifications.getUserByUsername(Users.USERS_LIST_WITH_ONE_USER.get(0).getUsername())
                .body("type", equalTo("error"),
                        "message", equalTo("User not found"))
                .statusCode(404);
    }

    @Test
    public void deleteUserWithoutLogIntoTheSystemTest() {

        specifications.logout();

        specifications.createWithList(Users.USERS_LIST_WITH_TWO_USERS)
                .body("type", equalTo("unknown"),
                        "message", equalTo("ok"))
                .statusCode(200);

        specifications.getUserByUsername(Users.USERS_LIST_WITH_TWO_USERS.get(0).getUsername())
                .statusCode(200);

        specifications.deleteUser(Users.USERS_LIST_WITH_TWO_USERS.get(0).getUsername())
                .body("type", equalTo("unknown"),
                        "message", equalTo(Users.USERS_LIST_WITH_TWO_USERS.get(0).getUsername()))
                .statusCode(404);
    }

    @Test
    public void deleteUserWithNonExistentUsernameTest() {

        specifications.logUserIntoTheSystem(Users.ADMIN.getUsername(),Users.ADMIN.getPassword());

        specifications.deleteUser("UserWithNonExistentUsername")
                .statusCode(404);
    }

    @Test
    public void deleteUserWithEmptyUsernameTest() {

        specifications.logUserIntoTheSystem(Users.ADMIN.getUsername(),Users.ADMIN.getPassword());

        specifications.deleteUser("")
                .body("type", equalTo("unknown"))
                .statusCode(400);
    }
}
