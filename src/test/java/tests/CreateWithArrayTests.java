package tests;

import Objects.Users;
import data.UsersList;
import objects.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;

public class CreateWithArrayTests extends BaseTest{

    @Test
    public void twoUsersWithCorrectDataTest() {

        specifications.logout();

        specifications.createWithArray(Users.USERS_ARRAY_WITH_TWO_USERS)
                .body("type", equalTo("unknown"),
                        "message", equalTo("ok"))
                .statusCode(200);

        List<User> user1 = specifications.getUserByUsername(Arrays.stream(Users.USERS_ARRAY_WITH_TWO_USERS)
                .findFirst().get().getUsername()).extract().body().jsonPath().getList(".", User.class);

        Assert.assertEquals(Arrays.stream(Users.USERS_ARRAY_WITH_TWO_USERS).findFirst(), user1.stream().findFirst());
    }

    @Test
    public void emptyUsersListTest() {

        specifications.logout();

        specifications.createWithArray(Users.EMPTY_USERS_ARRAY)
                .statusCode(400);
    }
}
