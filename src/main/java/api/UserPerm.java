package api;

import impl.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static app.app.userList;

public abstract class UserPerm {

    protected String incorrectInput = "Введено не верное значение, попробуйте снова";

    protected Scanner sc = new Scanner(System.in);

    abstract protected void UserInWork(User user);

    protected User pickUser(List<Integer> listUserID) {
        if (listUserID.isEmpty()) return null;
        int pickUserChange = 0;
        do {
            try {
                pickUserChange = Integer.parseInt(sc.nextLine());
                if (listUserID.contains(pickUserChange)) {
                    break;
                } else {
                    System.out.println(incorrectInput);
                }
            }catch (Exception ex){
                System.out.println(incorrectInput);
            }
        } while (true);

        return userList.get(pickUserChange);
    }

    protected List<Integer> viewUsers(String... permissions) {
        List<Integer> listId = new ArrayList<>();
        System.out.println("Список пользователей, зарегистрированных в системе c правами " + Arrays.toString(permissions) + " :");
        for (int i = 0; i < userList.size(); i++)  {
            if (permissions.length == 2) {
                if (userList.get(i).getPermission().equals(permissions[0]) || userList.get(i).getPermission().equals(permissions[1])) {
                    System.out.println(i + " - " + userList.get(i));
                    listId.add(i);
                }
            } else {
                if (userList.get(i).getPermission().equals(permissions[0])) {
                    System.out.println(i + " - " + userList.get(i));
                    listId.add(i);
                }
            }
        }
        if (listId.isEmpty()) System.out.println("Пользователей с правами " +  Arrays.toString(permissions) + " нет в системе");
        return listId;
    }

    protected String checkLogin() {
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

    protected void setFIO(User user) {
        System.out.print("Фамилия: ");
        String secName = sc.nextLine();
        user.setSecondName(secName);
        System.out.print("Имя: ");
        String firstName = sc.nextLine();
        user.setName(firstName);
        System.out.print("Отчество: ");
        String thirdName = sc.nextLine();
        user.setThirdName(thirdName);
    }

    protected void setPass(User user) {
        System.out.print("Новый пароль: ");
        String newPass = sc.nextLine();
        user.setPass(newPass);
    }
}
