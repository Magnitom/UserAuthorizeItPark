package impl;

import java.util.List;
import java.util.Scanner;

public class Login {

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
}
