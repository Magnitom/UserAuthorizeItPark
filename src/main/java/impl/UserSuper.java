package impl;

import api.UserApi;

import java.util.Scanner;

import static app.app.userList;

public class UserSuper extends UserApi {


    public UserSuper(String login, String pass, String permission) {
        super(login, pass, permission);
    }

    static public void UserInWork() {
        do {
            System.out.println("Вы вошли с правами SUPER\nВыберите доступные функции:");
            System.out.println("1 - Создать пользователя ADMIN\n2 - Создать пользователя AIB \n3 - Поменять роль у пользователя");
            System.out.println("4 - Выйти");
            Scanner sc = new Scanner(System.in);
            int action = sc.nextInt();
            boolean quit = false;
            switch (action) {
                case 1:
                    createUserAdmin();
                    break;
                case 4:
                    quit = true;
                    break;
            }
            if (quit) break;
        } while (true);

    }

    private static void createUserAdmin() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Вы созадете пользователя с правами ADMIN\nПридумайте логин пользователю");
        String login = sc.nextLine();
        System.out.println("Придумайте пароль пользовтелю");
        String pass = sc.nextLine();
        userList.add(new UserAdmin(login, pass, "ADMIN"));
    }

}
