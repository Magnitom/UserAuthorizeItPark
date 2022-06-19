package impl;

import api.UserPerm;

public class UserUser extends UserPerm {

    public void UserInWork(User user) {
        boolean quit = false;
        do {
            System.out.println("'" + user.getName() + "' вы вошли с правами USER");
            System.out.println("Выберите доступные вам функции:\n1 Выйти");
            String action = sc.nextLine();
            switch (action) {
                case "1":
                    quit = true;
                    break;
                default:
                    System.out.println(incorrectInput);
            }
        }while (!quit);
    }
}
