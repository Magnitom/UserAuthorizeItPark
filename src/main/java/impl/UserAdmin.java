package impl;

import api.UserPerm;

import java.util.ArrayList;
import java.util.List;

import static app.app.userList;

public class UserAdmin extends UserPerm {

    public void UserInWork(User user) {
        boolean quit = false;
        do {
            System.out.println("Вы вошли с правами ADMIN");
            if (user.isFirstLogin()) {
                System.out.println("Вы вошли в первый раз, укажите вашу Фамилию, Имя и Отчество, а так же поменяйте пароль.");
                setPass(user);
                setFIO(user);
                user.setFirstLogin(false);
                System.out.println();
            }
            System.out.println("Выберите доступные Вам функции:\n1 - Поменять данные у пользователя USER\n" +
                    "2 - Просмотреть всех пользователей с правами USER\n9 - Выйти");
            String action = sc.nextLine();
            switch (action) {
                case "1":
                    if (user.isAdminPerm()) {
                        changeUser();
                    } else {
                        System.out.println("У вас не хватает прав для этого действия, обратитесь к пользователю с правами AIB\n");
                    }
                    break;
                case "2":
                    viewUsers("USER");
                    break;
                case "9":
                    quit = true;
                    break;
                default:
                    System.out.println(incorrectInput);
            }
        } while (!quit);

    }

    private void changeUser() {
        System.out.println("Выберите пользователя по ID, у которого вы хотите поменять данные.");
        List<Integer> listIdUsers = viewUsers("USER");
        User user = pickUser(listIdUsers);
        boolean quit = false;
        do {
            if (user == null) break;
            System.out.println("Выберите данные которые вы хотите изменить у пользователя с ID '" + user.getID() + "'");
            System.out.println("1 - Фамилия\n2 - Имя\n3 - Отчество\n4 - Возраст\n5 - Выйти в меню ADMIN");
            switch (sc.nextLine()) {
                case "1":
                    System.out.println("Введите новую фамилию");
                    user.setSecondName(sc.nextLine());
                    break;
                case "2":
                    System.out.println("Введите новое имя");
                    user.setName(sc.nextLine());
                    break;
                case "3":
                    System.out.println("Введите новое отчество");
                    user.setThirdName(sc.nextLine());
                    break;
                case "4":
                    do {
                        try {
                            System.out.println("Введите новый возраст");
                            user.setAge(Integer.parseInt(sc.nextLine()));
                            break;
                        } catch (Exception ex) {
                            System.out.println(incorrectInput);
                        }
                    }while (true);
                    break;
                case "5":
                    quit = true;
                    break;
                default:
                    System.out.println(incorrectInput);
            }
        } while (!quit);
    }
}
