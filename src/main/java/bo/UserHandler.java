package bo;

import ui.UserInfo;

public class UserHandler {

    public static UserInfo getUser(String username, String password){
        User user = User.getUser(username);
        if(user.getPassword().equals(password)){
            return new UserInfo(user.getUsername(), user.getPassword());
        }
        return null;
    }
}
