package Objects;

import objects.User;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Users {

    public static final User ADMIN = User.builder()
            .id(1)
            .username("admin")
            .firstName("firstname1")
            .lastName("lastname1")
            .email("email1@gmail.com")
            .password("adminpass")
            .phone("111111111")
            .userStatus(1)
            .build();

    public static final User USER1 = User.builder()
            .id(10)
            .username("AS_username11")
            .firstName("AS_firstname1")
            .lastName("AS_lastname1")
            .email("email1@gmail.com")
            .password("AS_password1")
            .phone("111111111")
            .userStatus(1)
            .build();

    public static final User USER2 = User.builder()
            .id(2)
            .username("AS_username2")
            .firstName("AS_firstname2")
            .lastName("AS_lastname2")
            .email("email2@gmail.com")
            .password("AS_password2")
            .phone("2222222")
            .userStatus(2)
            .build();

    public static final User USER3 = User.builder()
            .id(3)
            .username("AS_username3")
            .firstName("AS_firstname3")
            .lastName("AS_lastname3")
            .email("email3@gmail.com")
            .password("AS_password3")
            .phone("111111111")
            .userStatus(3)
            .build();

    public static final User USER_FOR_UPDATING = User.builder()
            .id(3434)
            .username("upd")
            .firstName("firstName_for_upd")
            .lastName("lastname_for_upd")
            .email("emailForUpd@gmail.com")
            .password("password_for_upd")
            .phone("1123456789")
            .userStatus(1)
            .build();

    public static final User UPDATED_USER = User.builder()
            .id(3434)
            .username("upd")
            .firstName("firstName_for_updated")
            .lastName("lastname_for_upd")
            .email("emailForUpd@gmail.com")
            .password("password_for_upd")
            .phone("1123456789")
            .userStatus(1)
            .build();

    public static final User INVALID_USER = User.builder()
            .id(10)
            .username("username1")
            .build();

    public static final User INVALID_USER_FOR_UPDATING = User.builder()
            .id(10)
            .username("upd")
            .build();

    public static final List<User> EMPTY_USERS_LIST = Collections.emptyList();
    public static final List<User> USERS_LIST_WITH_ONE_USER = Collections.singletonList(USER1);
    public static final List<User> USERS_LIST_WITH_TWO_USERS = Arrays.asList(USER1,USER2);

    public static final User[] USERS_ARRAY_WITH_TWO_USERS = {USER1,USER2};
    public static final User[] EMPTY_USERS_ARRAY = {};
}
