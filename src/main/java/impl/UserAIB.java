package impl;

import api.UserPerm;

import java.util.List;

import static app.app.userList;

public class UserAIB extends UserPerm {


    public void UserInWork(User user) {
        boolean quit = false;
        do {
            System.out.println("Вы вошли с правами AIB");
            if (user.isFirstLogin()) {
                System.out.println("Вы вошли первый раз, укажите вашу Фамилию, Имя и Отчество, а также замените пароль по-умолчанию.");
                setPass(user);
                setFIO(user);
                user.setFirstLogin(false);
                System.out.println();
            }
            System.out.println("Выберите доступные вам функции:\n1 - Разрешить пользователю с правами ADMIN изменять данные пользователя с ролью USER\n" +
                    "2 - Поменять данные у пользователя с правами USER\n" +
                    "3 - Удалить данные у пользователя с правами USER\n" +
                    "4 - Просмотреть всех пользователей с ролью ADMIN\n9 - Выйти");
            String action = sc.nextLine();
            switch (action) {
                case "1":
                    System.out.println();
                    givePermissionAdmins();
                    break;
                case "2":
                    System.out.println();
                    changeUser();
                    break;
                case "3":
                    System.out.println();
                    delUser();
                case "4":
                    System.out.println();
                    viewUsers("ADMIN");
                    break;
                case "9":
                    quit = true;
                    break;
                default:
                    System.out.println(incorrectInput);
            }
        }while (!quit);
    }

    private void givePermissionAdmins() {
        System.out.println("Выберите пользователя по ID, которму хотите дать разрешение на изменение данных пользователя USER.");
        List<Integer> listIdUsers = viewUsers("ADMIN");
        if (listIdUsers.isEmpty()) return;
        User user = pickUser(listIdUsers);
        user.setAdminPerm(true);
        System.out.println("Права доступа на изменение данных USER, успешно предоставлены пользователю с ID " + user.getID());
    }

    private void changeUser() {
        System.out.println("Выберите пользователя по ID, у которого вы хотите поменять данные.");
        List<Integer> listIdUsers = viewUsers("USER");
        if (listIdUsers.isEmpty()) return;
        User user = pickUser(listIdUsers);
        boolean quit = false;
        do {
            if (user == null) break;
            System.out.println("Выберите данные, которые вы хотите изменить у пользователя с ID '" + user.getID() + "'");
            System.out.println("1 - Логин\n2 - Пароль\n3 - Выйти в меню AIB");
            switch (sc.nextLine()) {
                case "1":
                    System.out.println("Введите новый логин");
                    user.setLogin(sc.nextLine());
                    break;
                case "2":
                    System.out.println("Введите новый пароль");
                    user.setPass(sc.nextLine());
                case "3":
                    quit = true;
                    break;
                default:
                    System.out.println(incorrectInput);
            }
        }while (!quit);
    }

    private void delUser() {
        System.out.println("Выберите пользователя по ID, которого вы хотите удалить.");
        List<Integer> listIdUsers = viewUsers("USER");
        if (listIdUsers.isEmpty()) return;
        User user = pickUser(listIdUsers);
        userList.remove(user);
        System.out.println("Пользователь с ID '" + user.getID() + "\' удален.\n");
    }

}

