package impl;

import java.util.Scanner;

public class User {


    final private String defaultPass = "password";
    private String login;
    private String pass;
    private String secondName;
    private String name;
    private String thirdName;
    private static int numOfUsers = 0;
    private int ID;
    private int age;
    private String permission;
    private boolean adminPerm = true;
    private boolean firstLogin = true;

    public User(String login, String pass, String permission) {
        numOfUsers++;
        this.ID = numOfUsers;
        this.login = login;
        this.pass = pass;
        this.permission = permission;
    }

    public User(String login, String pass) {
        numOfUsers++;
        this.ID = numOfUsers;
        this.login = login;
        this.pass = pass;
        System.out.println("Выберите права доступа у пользователя:\n1 - ADMIN\n2 - AIB");
        Scanner sc = new Scanner(System.in);
        boolean outDo = false;
        do {
            String permChoose = sc.nextLine();
            switch (permChoose) {
                case "1":
                    this.permission = "ADMIN";
                    outDo = true;
                    break;
                case "2":
                    this.permission = "AIB";
                    outDo = true;
                    break;
                default:
                    System.out.println("Введено не верное значение, попробуйте снова");
                    break;
            }
        } while (!outDo);
    }

    @Override
    public String toString() {
        return "ID='" + ID + '\'' +
                ", Имя='" + name + '\'' +
                ", Фамилия='" + secondName + '\'' +
                ", Права доступа='" + permission + "'";
    }

    public boolean isAdminPerm() {
        return adminPerm;
    }



    public boolean isFirstLogin() {
        return firstLogin;
    }

    public void setFirstLogin(boolean firstLogin) {
        this.firstLogin = firstLogin;
    }

    public void setAdminPerm(boolean adminPerm) {
        this.adminPerm = adminPerm;
    }

    public String getPermission() {
        return permission;
    }

    public String getLogin() {
        return login;
    }

    public String getPass() {
        return pass;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setThirdName(String thirdName) {
        this.thirdName = thirdName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getName() {
        return name;
    }

    public String getThirdName() {
        return thirdName;
    }

    public int getAge() {
        return age;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public int getID() {
        return ID;
    }

    public static int getNumOfUsers() {
        return numOfUsers;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getDefaultPass() {
        return defaultPass;
    }
}
