package impl;

import api.UserPerm;

import java.util.ArrayList;
import java.util.List;

import static app.app.userList;

public class UserSuper extends UserPerm {

    public void UserInWork(User user) {
        boolean quit = false;
        do {
            System.out.println("Вы вошли с правами SUPER\nВыберите доступные Вам функции:");
            System.out.println("1 - Создать пользователя c правами ADMIN или AIB.\n" +
                    "2 - Поменять роль у пользователя c правами ADMIN или AIB.\n" +
                    "3 - Поменять логин у пользователя c правами ADMIN или AIB.\n" +
                    "4 - Cбросить пароль на пароль по-умолчанию  у пользователей с ролями ADMIN и AIB.\n" +
                    "5 - Удалить пользователя с ролью ADMIN и AIB.\n" +
                    "6 - Просматреть всех пользователей, которые зарегистрированы в системе.\n" +
                    "9 - Выйти");
            String action = sc.nextLine();
            switch (action) {
                case "1":
                    System.out.println();
                    createUser();
                    break;
                case "2":
                    System.out.println();
                    changePermUser();
                    break;
                case "3":
                    System.out.println();
                    changeLoginUser();
                    break;
                case "4":
                    System.out.println();
                    resetPassToDefault();
                    break;
                case "5":
                    System.out.println();
                    deleteUserAibAdmin();
                    break;
                case "6":
                    System.out.println();
                    viewAllUsers();
                    break;
                case "9":
                    System.out.println();
                    quit = true;
                    break;
                default:
                    System.out.println(incorrectInput);
                    break;
            }
        } while (!quit);

    }

    private void viewAllUsers() {
        System.out.println("\nСписок пользователей, зарегистрированных в системе:");
        for (int i = 0; i < userList.size(); i++) {
            System.out.println(i + " - " + userList.get(i));
        }
        System.out.println();
    }

    private void createUser() {
        System.out.println("Придумайте логин пользователю");
        String login = checkLogin();
        System.out.println("Придумайте пароль пользовтелю");
        String pass = sc.nextLine();
        userList.add(new User(login, pass));
        System.out.println("Создание пользователя с правами " + userList.get(userList.size() - 1).getPermission() + " успешно завершено\n");
    }

    private void changePermUser() {
        System.out.println("Выберите пользователя, у которого вы хотите поменять права.");
        List<Integer> listAdminAib = viewUsers("ADMIN", "AIB");
        if (listAdminAib.isEmpty()) return;
        User user = pickUser(listAdminAib);
        System.out.println("Выберите требуемы права доступа для пользователя:\n" +
                "1 - ADMIN\n" +
                "2 - AIB\n" +
                "3 - USER");
        boolean quit = false;
        do {
            switch (sc.nextLine()) {
                case "1":
                    user.setPermission("ADMIN");
                    quit = true;
                    break;
                case "2":
                    user.setPermission("AIB");
                    quit = true;
                    break;
                case "3":
                    user.setPermission("USER");
                    quit = true;
                    break;
                default:
                    System.out.println(incorrectInput);
                    break;
            }
        } while (!quit);
        System.out.println("Права доступа у пользователя с ID '" + user.getID() + "' успешно изменены на " +
                user.getPermission() + "\n");
    }

    private void changeLoginUser() {
        System.out.println("Выберите пользователя, у которого вы хотите поменять логин.");
        List<Integer> listAdminAib = viewUsers("ADMIN", "AIB");
        if (listAdminAib.isEmpty()) return;
        User user = pickUser(listAdminAib);
        System.out.println("Текущий логин у пользователя с ID '" + user.getID() + "' - '" + user.getLogin() + '\'');
        System.out.println("Напишите логин, на который нужно изменить:");
        user.setLogin(checkLogin());
        System.out.println("Логин успешно изменён\n");
    }

    private void resetPassToDefault() {
        System.out.println("Выберите пользователя, у которого вы хотите сбросить пароль.");
        List<Integer> listAdminAib = viewUsers("ADMIN", "AIB");
        if (listAdminAib.isEmpty()) return;
        User user = pickUser(listAdminAib);
        user.setPass(user.getDefaultPass());
        System.out.println("Пароль успешно сброшен у пользователя с ID '" + user.getID() + "\'\n");
    }

    private void deleteUserAibAdmin() {
        System.out.println("Выберите пользователя, которого вы хотите удалить");
        List<Integer> listAdminAib = viewUsers("ADMIN", "AIB");
        if (listAdminAib.isEmpty()) return;
        User user = pickUser(listAdminAib);
        userList.remove(user);
        System.out.println("Пользователь с ID '" + user.getID() + "\' удалён.\n");
    }


}
