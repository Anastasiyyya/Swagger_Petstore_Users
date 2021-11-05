package tests;

import Objects.Users;
import objects.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;

public class CreateWithArrayTests extends BaseTest{

    @Test
    public void twoUsersWithCorrectDataTest() {

        specifications.logout();

        specifications.createWithArray(Users.USERS_ARRAY_WITH_TWO_USERS)
                .body("type", equalTo("unknown"),
                        "message", equalTo("ok"))
                .statusCode(200);

        User user1 = specifications.getUserByUsername(Users.USERS_LIST_WITH_TWO_USERS.get(0).getUsername()).extract().body().as(User.class);

        Assert.assertEquals(user1, Users.USERS_LIST_WITH_TWO_USERS.get(0));
    }

    @Test
    public void emptyUsersListTest() {

        specifications.logout();

        specifications.createWithArray(Users.EMPTY_USERS_ARRAY)
                .statusCode(400);
    }
}
