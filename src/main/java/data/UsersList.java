package data;

import objects.User;
import lombok.Builder;
import lombok.Data;
import java.util.ArrayList;

@Data
@Builder
public class UsersList {

    ArrayList<User> data;

}
