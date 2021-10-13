package objects;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {

    int id;
    String username;
    String firstName;
    String lastName;
    String email;
    String password;
    String phone;
    int userStatus;
}
