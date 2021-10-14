package tests;

import Objects.Users;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

public class DeleteUser extends BaseTest {

    @Test(description = "")
    public void deleteUserWithExistUsernameTest() {

        specifications.createWithList(Users.USERS_LIST_WITH_TWO_USERS)
                .body("type", equalTo("unknown"),
                        "message", equalTo("ok"))
                .statusCode(200);

        specifications.getUserByUsername(Users.USERS_LIST_WITH_TWO_USERS.get(0).getUsername())
                        .statusCode(200);

        specifications.deleteUser(Users.USERS_LIST_WITH_TWO_USERS.get(0).getUsername())
                .body("type", equalTo("unknown"),
                        "message", equalTo(Users.USERS_LIST_WITH_TWO_USERS.get(0).getUsername()))
                .statusCode(200);

        specifications.getUserByUsername(Users.USERS_LIST_WITH_TWO_USERS.get(0).getUsername())
                .body("type", equalTo("error"),
                        "message", equalTo("User not found"))
                .statusCode(404);
    }

    @Test(description = "")
    public void deleteUserWithNonExistentUsernameTest() {

        specifications.deleteUser("UserWithNonExistentUsername")
                .statusCode(404);

    }

    @Test(description = "")
    public void deleteUserWithEmptyUsernameTest() {

        specifications.deleteUser("")
                .body("type", equalTo("unknown"))
                .statusCode(405);

    }


}
