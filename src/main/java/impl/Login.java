package impl;

import java.util.List;
import java.util.Scanner;

import static app.app.userList;

public class Login {

    public void userSelection(){
        User userInSystem = userLogin(userList);
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
    }

    public User userLogin(List<User> userList) {
        Scanner sc = new Scanner(System.in);
        int numberUserList = 0;
        do {
            System.out.println("Введите логин:");
            String userInputLogin = sc.nextLine();
            boolean userFind = false;
            for (int i = 0; i < userList.size(); i++) {
                if (userList.get(i).getLogin().equals(userInputLogin)) {
                    numberUserList = i;
                    userFind = true;
                    break;
                }
            }
            if (!userFind) {
                System.out.println("Пользователь с таким логином не существует, повтороите ввод снова.");
            } else break;
        } while (true);
        do {
            System.out.println("Введите пароль:");
            String userInputPass = sc.nextLine();
            if (userList.get(numberUserList).getPass().equals(userInputPass)) {
                System.out.println("Добро пожаловать!");
                break;
            } else {
                System.out.println("Введён не верный пароль!");
            }
        }while (true);
        return userList.get(numberUserList);
    }

    public void registrationUser(){
        System.out.println("Придумайте логин");
        Scanner sc = new Scanner(System.in);
        String newLoginUser = sc.nextLine();
        System.out.println("Придумайте пароль");
        String newPassUser = sc.nextLine();
        userList.add(new User(newLoginUser, newPassUser, "USER"));
        System.out.println("Вы успешно зарегистрировались в системе.\n");
    }
}
