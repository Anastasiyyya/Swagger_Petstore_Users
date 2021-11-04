package tests;

import Objects.Users;
import objects.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;

public class UpdateUserAndCreateUserTests extends BaseTest{

    @Test
    public void updateNonExistentUserTest() {

        specifications.logUserIntoTheSystem(Users.ADMIN.getUsername(),Users.ADMIN.getPassword());

        specifications.updateUser("nonExistentUser",Users.UPDATED_USER)
                .body("type", equalTo("unknown"))
                .statusCode(404);
    }

    @Test
    public void updateUserWithExistsUsernameTest() {

        specifications.createWithList(Users.USERS_LIST_WITH_ONE_USER)
                .body("type", equalTo("unknown"),
                        "message", equalTo("ok"))
                .statusCode(200);

        specifications.logUserIntoTheSystem(Users.ADMIN.getUsername(),Users.ADMIN.getPassword());

        specifications.updateUser(Users.USER_FOR_UPDATING.getUsername(),Users.UPDATED_USER)
                .body("type", equalTo("unknown"),
                        "message",  equalTo(String.valueOf(Users.UPDATED_USER.getId())))
                .statusCode(200);

        User updatedUser = specifications.getUserByUsername(Users.UPDATED_USER.getUsername()).extract().body().as(User.class);

        //specifications.getUserByUsername(Users.USER1_UPDATE.getUsername());
        Assert.assertEquals(updatedUser, Users.UPDATED_USER);

    }

    @Test
    public void updateLogOutUserTest() {

        specifications.logout();

        specifications.createWithList(Users.USERS_LIST_WITH_ONE_USER)
                .body("type", equalTo("unknown"),
                        "message", equalTo("ok"))
                .statusCode(200);

        specifications.updateUser(Users.USER_FOR_UPDATING.getUsername(),Users.UPDATED_USER)
                .body("type", equalTo("unknown"),
                        "message",  equalTo(String.valueOf(Users.UPDATED_USER.getId())))
                .statusCode(404);

    }

    @Test
    public void updateUserWithEmptyUsernameTest() {

        specifications.logUserIntoTheSystem(Users.ADMIN.getUsername(),Users.ADMIN.getPassword());

        specifications.updateUser("",Users.UPDATED_USER)
                .body("type", equalTo("unknown"))
                .statusCode(400);

    }

    @Test
    public void updateUserWithExistsUsernameAndInvalidDataTest() {

        specifications.createWithList(Users.USERS_LIST_WITH_ONE_USER)
                        .statusCode(200);

        specifications.logUserIntoTheSystem(Users.ADMIN.getUsername(),Users.ADMIN.getPassword());

        specifications.updateUser(Users.USER_FOR_UPDATING.getUsername(),Users.INVALID_USER_FOR_UPDATING)
                .body("type", equalTo("unknown"),
                        "message", equalTo(String.valueOf(Users.INVALID_USER.getId())));

        User updatedUser = specifications.getUserByUsername(Users.INVALID_USER_FOR_UPDATING.getUsername()).extract().body().as(User.class);

        Assert.assertEquals(updatedUser, Users.INVALID_USER_FOR_UPDATING);
    }
}
