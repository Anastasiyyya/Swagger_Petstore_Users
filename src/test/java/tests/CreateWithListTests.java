package tests;

import Objects.Users;
import org.testng.annotations.Test;
import specs.Specifications;
import static org.hamcrest.Matchers.equalTo;

public class CreateWithListTests {
    
    @Test(description = "Checks status code and value of 'type' and 'message' keys")
    public void oneUserWithCorrectDataTest() {

        Specifications specifications = new Specifications();

        specifications.createWithList(Users.USERS_LIST_WITH_ONE_USER)
                .body("type", equalTo("unknown"),
                        "message", equalTo("ok"))
                .statusCode(200);

    }

    @Test(description = "Checks status code and value of 'type' and 'message' keys")
    public void twoUsersWithCorrectDataTest() {

        Specifications specifications = new Specifications();

        specifications.createWithList(Users.USERS_LIST_WITH_TWO_USERS)
                .body("type", equalTo("unknown"),
                        "message", equalTo("ok"))
                .statusCode(200);
    }

    @Test(description = "Checks status code")
    public void emptyUsersListTest() {

        Specifications specifications = new Specifications();

        specifications.createWithList(Users.EMPTY_USERS_LIST)
                .statusCode(400);
    }
}
