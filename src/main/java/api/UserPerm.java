package api;

import impl.User;

import java.util.Scanner;

public abstract class UserPerm {

    protected Scanner sc = new Scanner(System.in);

    abstract protected void UserInWork(User user);
}
