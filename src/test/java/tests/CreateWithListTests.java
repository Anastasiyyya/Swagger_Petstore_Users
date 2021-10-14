package tests;

import Objects.Users;
import objects.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;

public class CreateWithListTests extends BaseTest{


    @Test(description = "Checks status code and value of 'type' and 'message' keys")
    public void twoUsersWithCorrectDataTest() {

        specifications.createWithList(Users.USERS_LIST_WITH_TWO_USERS)
                .body("type", equalTo("unknown"),
                        "message", equalTo("ok"))
                .statusCode(200);

        User user1 = specifications.getUserByUsername(Users.USERS_LIST_WITH_TWO_USERS.get(0).getUsername()).extract().body().as(User.class);
        User user2 = specifications.getUserByUsername(Users.USERS_LIST_WITH_TWO_USERS.get(1).getUsername()).extract().body().as(User.class);

        Assert.assertEquals(user1, Users.USERS_LIST_WITH_TWO_USERS.get(0));
        Assert.assertEquals(user2, Users.USERS_LIST_WITH_TWO_USERS.get(1));
    }


    @Test(description = "Checks status code")
    public void emptyUsersListTest() {

        specifications.createWithList(Users.EMPTY_USERS_LIST)
                .statusCode(400);
    }

}
