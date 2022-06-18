package impl;

import api.UserPerm;

import java.util.ArrayList;
import java.util.List;

import static app.app.userList;

public class UserSuper extends UserPerm {

    public void UserInWork() {
        boolean quit = false;
        do {
            System.out.println("Вы вошли с правами SUPER\nВыберите доступные функции:");
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
                    createUser();
                    break;
                case "2":
                    changePermUser();
                    break;
                case "3":
                    changeLoginUser();
                    break;
                case "4":
                    resetPassToDefault();
                    break;
                case "5":
                    deleteUserAibAdmin();
                    break;
                case "6":
                    viewAllUsers();
                    break;
                case "9":
                    quit = true;
                    break;
                default:
                    System.out.println("Введено не верное значение, попробуйте снова");
                    break;
            }
            if (quit) break;
        } while (!quit);

    }

    private void viewAllUsers() {
        System.out.println("\nСписок пользователей, зарегистрированных в системе:");
        for (User i : userList) {
            System.out.println(i);
        }
        System.out.println();
    }

    private List<Integer> viewAdminAibUsers() {
        System.out.println("\nСписок пользователей, зарегистрированных в системе c правами ADMIN и AIB:");
        List<Integer> listAdminAib = new ArrayList<>();
        for (User i : userList) {
            if (i.getPermission().equals("ADMIN") || i.getPermission().equals("AIB")) {
                System.out.println(i);
                listAdminAib.add(i.getID());
            }
        }
        System.out.println();
        return listAdminAib;
    }

    private User pickUser() {
        List<Integer> listAdminAib = viewAdminAibUsers();
        int pickUserChange = 0;
        do {
            pickUserChange = sc.nextInt();
            sc.nextLine();
            if (listAdminAib.contains(pickUserChange)) {
                break;
            } else {
                System.out.println("Введено не верное значение, попробуйте снова");
            }
        } while (true);
        return userList.get(pickUserChange-1);
    }

    private void createUser() {
        System.out.println("Придумайте логин пользователю");
        String login = sc.nextLine();
        System.out.println("Придумайте пароль пользовтелю");
        String pass = sc.nextLine();
        userList.add(new User(login, pass));
        System.out.println("Создание пользователя с правами " + userList.get(userList.size() - 1).getPermission() + " успешно завершено\n");
    }

    private void changePermUser() {
        System.out.println("Выберите пользователя по ID, у которого вы хотите поменять права.");
        User user = pickUser();
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
                    System.out.println("Введено не верное значение, попробуйте снова");
                    break;
            }
        } while (!quit);
        System.out.println("Права доступа у пользователя с ID '" + user.getID() + "' успешно изменены на " +
                user.getPermission() + "\n");
    }

    private void changeLoginUser() {
        System.out.println("Выберите пользователя по ID, у которого вы хотите поменять логин.");
        User user = pickUser();
        System.out.println("Текущий логин у пользователя с ID '" + user.getID() + "' - '" + user.getLogin() + '\'');
        System.out.println("Напишите логин, на который нужно изменить:");
        user.setLogin(sc.nextLine());
        System.out.println("Логин успешно изменён\n");
    }

    private void resetPassToDefault() {
        System.out.println("Выберите пользователя по ID, у которого вы хотите сбросить пароль.");
        User user = pickUser();
        user.setPass(user.getDefaultPass());
        System.out.println("Пароль успешно сброшен у пользователя с ID '" + user.getID() + "\'\n");
    }

    private void deleteUserAibAdmin() {
        System.out.println("Выберите пользователя по ID, которого вы хотите удалить");
        User user = pickUser();
        userList.remove(user);
        System.out.println("Пользователь с ID '" + user.getID() + "\' удалён.\n");
    }


}
