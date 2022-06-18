package app;

import api.UserPerm;
import impl.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class app {

    public static List<User> userList = new ArrayList<>();

    public static void main(String[] args) {
        User superUserSuper = new User("SUPER", "SUPER", "SUPER");
        userList.add(superUserSuper);
        Login login = new Login();
        do {
            User userInSystem = login.userLogin(userList);
            if (userInSystem.getPermission().equals("SUPER")) {
                UserSuper superUser = new UserSuper();
                superUser.UserInWork();
            }
            if (userInSystem.getPermission().equals("ADMIN")) {
                UserAdmin adminUser = new UserAdmin();
                adminUser.UserInWork();
            }
            if (userInSystem.getPermission().equals("AIB")) {
                UserAIB aibUser = new UserAIB();
                aibUser.UserInWork();
            }
            if (userInSystem.getPermission().equals("USER")) {
                UserUser UserUser = new UserUser();
                UserUser.UserInWork();
            }
        }while (true);
    }


}
