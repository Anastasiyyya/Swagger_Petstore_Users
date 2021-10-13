package data;

import com.google.gson.annotations.Expose;
import lombok.Builder;
import lombok.Data;
import objects.User;

import java.util.ArrayList;

@Data
@Builder
public class UsersList {
    @Expose
    ArrayList<User> data;
}
