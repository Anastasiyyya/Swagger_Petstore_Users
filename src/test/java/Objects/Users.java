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
            .username("username1")
            .firstName("firstname1")
            .lastName("lastname1")
            .email("email1@gmail.com")
            .password("password1")
            .phone("111111111")
            .userStatus(1)
            .build();

    public static final User USER1_UPDATE = User.builder()
            .id(2222)
            .username("username1")
            .firstName("newFirstname1")
            .lastName("newLastname1")
            .email("newEmail1@gmail.com")
            .password("newPassword1")
            .phone("111111111")
            .userStatus(1)
            .build();

    public static final User INVALID_USER = User.builder()
            .id(10)
            .username("username1")
            .build();

    public static final User USER2 = User.builder()
            .id(2)
            .username("username2")
            .firstName("firstname2")
            .lastName("lastname2")
            .email("email2@gmail.com")
            .password("password2")
            .phone("2222222")
            .userStatus(2)
            .build();

    public static final User USER3 = User.builder()
            .id(3)
            .username("username3")
            .firstName("firstname3")
            .lastName("lastname3")
            .email("email3@gmail.com")
            .password("password3")
            .phone("111111111")
            .userStatus(3)
            .build();

    public static final List<User> EMPTY_USERS_LIST = Collections.emptyList();
    public static final List<User> USERS_LIST_WITH_ONE_USER = Collections.singletonList(USER1);
    public static final List<User> USERS_LIST_WITH_TWO_USERS = Arrays.asList(USER1,USER2);

    public static final User[] USERS_ARRAY_WITH_TWO_USERS = {USER1,USER2};
    public static final User[] EMPTY_USERS_ARRAY = {};
}
