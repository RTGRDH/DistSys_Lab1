package bo;

import ui.UserInfo;

public class UserHandler {

    public static UserInfo getUser(String username){
        User user = User.getUser(username);
        return new UserInfo(user.getUsername(), user.getPassword());
    }

}
