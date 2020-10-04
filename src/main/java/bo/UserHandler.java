package bo;

import ui.UserInfo;

import java.sql.SQLException;

public class UserHandler {

    public static UserInfo getUser(String username, String password){
        User user = User.getUser(username);
        if(user.getPassword().equals(password)){
            return new UserInfo(user.getUsername(), user.getPassword());
        }
        return null;
    }

    public static void createUser(UserInfo user) throws SQLException {
        User.createUser(user.getUsername(), user.getPassword());
    }
}
