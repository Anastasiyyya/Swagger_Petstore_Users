package data;

import objects.User;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class UserData {

    private static final List<User> users = new ArrayList<>();

}
