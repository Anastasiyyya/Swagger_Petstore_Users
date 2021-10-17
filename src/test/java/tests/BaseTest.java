package tests;

import Objects.Users;
import org.testng.annotations.BeforeMethod;
import specs.Specifications;

public class BaseTest {

    Specifications specifications;


    @BeforeMethod
    public void logOutLogIn(){
        initPages();

        specifications.logout();
        specifications.logUserIntoTheSystem(Users.USER1.getUsername(),Users.USER1.getPassword());

        specifications.deleteUser(Users.USER1.getUsername());
        specifications.deleteUser(Users.USER2.getUsername());
        specifications.deleteUser(Users.USER3.getUsername());
        specifications.deleteUser(Users.USER1_UPDATE.getUsername());
        specifications.deleteUser(Users.INVALID_USER.getUsername());
    }

    public void initPages() {
        specifications = new Specifications();

    }
}
