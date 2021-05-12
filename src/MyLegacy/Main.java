package MyLegacy;

import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {

        UserManage userManage = new UserManage();

        List<User> account = userManage.readAccFromFile();
        System.out.println("Registered accounts");
        System.out.println(account);

        userManage.mainMenu();
    }
}