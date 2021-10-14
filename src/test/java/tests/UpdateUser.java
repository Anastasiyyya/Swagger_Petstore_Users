package tests;

import Objects.Users;
import objects.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;

public class UpdateUser extends BaseTest{

    @Test(description = "")
    public void updateNonExistentUserTest() {

        specifications.updateUser("user3000",Users.USER1_UPDATE)
                .body("type", equalTo("unknown"))
                .statusCode(200);

    }

    @Test(description = "")
    public void updateUserWithExistsUsernameTest() {

        specifications.createWithList(Users.USERS_LIST_WITH_ONE_USER)
                .body("type", equalTo("unknown"),
                        "message", equalTo("ok"))
                .statusCode(200);

        specifications.updateUser(Users.USER1.getUsername(),Users.USER1_UPDATE)
                .body("type", equalTo("unknown"),
                        "message",  equalTo(String.valueOf(Users.USER1_UPDATE.getId())))
                .statusCode(200);

        User updatedUser = specifications.getUserByUsername(Users.USER1_UPDATE.getUsername()).extract().body().as(User.class);

        Assert.assertEquals(updatedUser, Users.USER1_UPDATE);

    }

    @Test(description = "")
    public void updateUserWithEmptyUsernameTest() {

        specifications.updateUser("",Users.USER1_UPDATE)
                .body("type", equalTo("unknown"))
                .statusCode(405);

    }

    @Test(description = "")
    public void updateUserWithExistsUsernameAndInvalidDataTest() {

        specifications.updateUser(Users.USER1.getUsername(),Users.INVALID_USER)
                .body("type", equalTo("unknown"),
                        "message", equalTo(String.valueOf(Users.INVALID_USER.getId())))
                .statusCode(200);

        User updatedUser = specifications.getUserByUsername(Users.USER1_UPDATE.getUsername()).extract().body().as(User.class);

        Assert.assertEquals(updatedUser, Users.INVALID_USER);
    }
}
