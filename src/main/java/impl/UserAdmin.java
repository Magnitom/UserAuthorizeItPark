package impl;

import api.UserPerm;

import java.util.ArrayList;
import java.util.LinkedList;
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
            }
            System.out.println("Выберите доступные Вам функции:\n1 - Поменять данные у пользователя USER\n" +
                    "2 - Просмотреть всех пользователей с правами USER\n9 - Выйти");
            String action = sc.nextLine();
            switch (action) {
                case "1":
                    if (user.isAdminPerm()) {
                        changeUser();
                    } else {
                        System.out.println("У вас не хватате прав для этого действия, обратитесь к пользователю с правами AIB\n");
                    }
                    break;
                case "2":
                    viewAllUserUsers();
                    break;
                case "9":
                    quit = true;
                    break;
                default:
                    System.out.println("Введено не верное значение, попробуйте снова");
            }
        } while (!quit);

    }

    private void setFIO(User user) {
        System.out.print("Фамилия: ");
        String secName = sc.nextLine();
        user.setSecondName(secName);
        System.out.print("\nИмя: ");
        String firstName = sc.nextLine();
        user.setName(firstName);
        System.out.print("\nОтчество: ");
        String thirdName = sc.nextLine();
        user.setThirdName(thirdName);
    }

    private void setPass(User user) {
        System.out.print("\nНовый пароль: ");
        String newPass = sc.nextLine();
        user.setPass(newPass);
    }

    private void changeUser() {
        System.out.println("Выберите пользователя по ID, у которого вы хотите поменять данные.");
        List<Integer> listIdUsers = viewAllUserUsers();
        int pickUserChange = 0;
        do {
            pickUserChange = sc.nextInt();
            sc.nextLine();
            if (listIdUsers.contains(pickUserChange)) {
                break;
            } else {
                System.out.println("Введено не верное значение, попробуйте снова");
            }
        } while (true);
        User user = userList.get(pickUserChange);
        boolean quit = false;
        do {
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
                    System.out.println("Введите новый возраст");
                    user.setAge(Integer.parseInt(sc.nextLine()));
                    break;
                case "5":
                    quit = true;
                    break;
                default:
                    System.out.println("Введено не верное значение, попробуйте снова");
            }
        } while (!quit);
    }

    private List<Integer> viewAllUserUsers() {
        List<Integer> listIdUsers = new ArrayList<>();
        System.out.println("\nСписок пользователей, зарегистрированных в системе c правами USER:");
        for (User i : userList) {
            if (i.getPermission().equals("USER")) {
                System.out.println(i);
                listIdUsers.add(i.getID());
            }
        }
        System.out.println();
        return listIdUsers;
    }
}
