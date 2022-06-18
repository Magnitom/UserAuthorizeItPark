package app;

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
        Scanner sc = new Scanner(System.in);
        boolean quit = false;
        do {
            System.out.println("Добро пожаловать в систему. Выберите требуемое действие\n" +
                    "1 - Войти в систему.\n2 - Зарегистрироваться в системе.\n3 - Выйти из программы.");
            switch (sc.nextLine()) {
                case "1":
                    login.userSelection();
                    break;
                case "2":
                    login.registrationUser();
                    break;
                case "3":
                    System.out.println("Досвидания.");
                    quit = true;
                    break;
                default:
                    System.out.println("Введено не верное значение, попробуйте снова");
            }
        }while (!quit);
    }
}
