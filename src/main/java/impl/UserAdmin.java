package impl;

import api.UserPerm;

public class UserAdmin extends UserPerm {

    public void UserInWork() {
        boolean quit = false;
        do {
            System.out.println("Вы вошли с правами ADMIN\nВыберите доступные функции:");
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
}
