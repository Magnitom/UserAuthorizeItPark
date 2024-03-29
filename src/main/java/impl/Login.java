package impl;

import java.util.List;
import java.util.Scanner;

import static app.app.userList;

public class Login {

    public void userSelection(){
        User userInSystem = userLogin(userList);
        if (userInSystem == null) return;
        if (userInSystem.getPermission().equals("SUPER")) {
            UserSuper superUser = new UserSuper();
            superUser.UserInWork(userInSystem);
        }
        if (userInSystem.getPermission().equals("ADMIN")) {
            UserAdmin adminUser = new UserAdmin();
            adminUser.UserInWork(userInSystem);
        }
        if (userInSystem.getPermission().equals("AIB")) {
            UserAIB aibUser = new UserAIB();
            aibUser.UserInWork(userInSystem);
        }
        if (userInSystem.getPermission().equals("USER")) {
            UserUser userUser = new UserUser();
            userUser.UserInWork(userInSystem);
        }
    }

    public User userLogin(List<User> userList) {
        Scanner sc = new Scanner(System.in);
        int numberUserList = 0;
        for (int j = 2; j >= 0; j--) {
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
                System.out.println("Пользователь с таким логином не существует, повтороите ввод снова. У вас осталость " + j + " попытки на ввод");
            } else break;
            if (j == 0){
                return null;
            }
        }
        for (int i = 2; i >= 0; i--) {
            System.out.println("Введите пароль:");
            String userInputPass = sc.nextLine();
            if (userList.get(numberUserList).getPass().equals(userInputPass)) {
                System.out.println("Добро пожаловать!");
                break;
            } else {
                System.out.println("Введён не верный пароль! У вас осталость " + i + " попытки на ввод");
            }
            if (i == 0){
                return null;
            }
        }
        return userList.get(numberUserList);
    }

    public void registrationUser(){
        System.out.println("Придумайте логин");
        Scanner sc = new Scanner(System.in);
        String newLoginUser = checkLogin();
        System.out.println("Придумайте пароль");
        String newPassUser = sc.nextLine();
        System.out.println("Ваше Имя");
        String newName = sc.nextLine();
        System.out.println("Ваша Фамилия");
        String newSecondName = sc.nextLine();
        System.out.println("Ваше Отчество");
        String newThirdName = sc.nextLine();
        Integer newAge;
        do {
            try {
                System.out.println("Введите ваш возраст");
                newAge = Integer.parseInt(sc.nextLine());
                break;
            }catch (Exception ex){
                System.out.println("Введено не верное значение, попробуйте снова");
            }
        }while (true);
        userList.add(new User(newLoginUser, newPassUser, newSecondName, newName, newThirdName, newAge, "USER"));
        System.out.println("Вы успешно зарегистрировались в системе.\n");
    }

    private String checkLogin() {
        Scanner sc = new Scanner(System.in);
        String login;
        boolean quit;
        do {
            quit = true;
            login = sc.nextLine();
            for (User i : userList) {
                if (i.getLogin().equals(login)) {
                    System.out.println("Данный логин уже есть в системе, выберите другой.");
                    quit = false;
                }
            }
        }while (!quit);
        return login;
    }
}