package app;

import api.UserApi;
import impl.Login;
import impl.UserAIB;
import impl.UserAdmin;
import impl.UserSuper;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class app {

    public static List<UserApi> userList = new ArrayList<>();

    public static void main(String[] args) {
        UserSuper superUserSuper = new UserSuper("SUPER", "SUPER", "SUPER");
        userList.add(superUserSuper);
        Login login = new Login();
        do {

            UserApi userInSystem = login.userLogin(userList);
            if (userInSystem.getPermission().equals("SUPER")) {
                UserSuper.UserInWork();
            }
            if (userInSystem.getPermission().equals("ADMIN"))
                UserAdmin.UserInWork();
        }while (true);
    }


}
