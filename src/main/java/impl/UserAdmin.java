package impl;

import api.UserApi;

public class UserAdmin extends UserApi{


    public UserAdmin(String login, String pass, String permission) {
        super(login, pass, permission);
    }

    static public void UserInWork() {
        System.out.println("Вы вошли под ADMIN");

    }
}
