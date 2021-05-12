package MyLegacy;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserManage extends FilmManage implements Serializable {
    public static final String USER_DATA = "src\\Data\\UserData.txt";
    public static final String PASSWORDS_REGEX = "Passwords must be at least 6 characters";
    public static final String USERNAME_REGEX = "Username must be at least 6 characters";
    List<User> account = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public void userMainToy() throws Exception {
        int choice = -1;
        filmList = readData();
        do {
            userMenu();
            choice = checkChoice();

            switch (choice) {
                case 1:
                    displayFilmInformation();
                    break;
                case 2:
                    selectionSortByImdbRate();
                    break;
                case 3:
                    selectionSortByName();
                    break;
                case 4:
                    selectionSortByReleaseYear();
                    break;
                case 5:
                    showFilmById();
                    break;
                case 6:
                    showBestMovieByMoney();
                    break;
                case 7:
                    showTelevisionSeriesByTheMostSeasons();
                    break;
                case 8:
                    top10WeekBoxOfficeMojo();
                    break;
                case 9:
                    top20AllTimeWorldWide();
                    break;
            }
        }
        while (choice != 0);
    }

    public void mainToy() throws Exception {
        int choice = -1;
        filmList = readData();
        do {
            myMenu();
            choice = checkChoice();
            switch (choice) {
                case 1:
                    inputInformation();
                    break;
                case 2:
                    displayFilmInformation();
                    break;
                case 3:
                    replaceFilmById();
                    break;
                case 4:
                    deleteFilmById();
                    break;
                case 5:
                    selectionSortByImdbRate();
                    break;
                case 6:
                    selectionSortByName();
                    break;
                case 7:
                    selectionSortByReleaseYear();
                    break;
                case 8:
                    showFilmById();
                    break;
                case 9:
                    showBestMovieByMoney();
                    break;
                case 10:
                    showTelevisionSeriesByTheMostSeasons();
                    break;
                case 11:
                    writeDataToFile();
                    break;
                case 12:
                    ShowDataFromReadFile();
                    break;
            }
        }
        while (choice != 0);
    }

    public int getOrder() {
        int order;
        try {
            System.out.println("Enter");
            order = sc.nextInt();
        } catch (Exception e) {
            System.err.println("Wrong type order");
            sc.nextLine();
            return getOrder();
        }
        return order;
    }

    public void logIn(List<User> account) throws Exception {
        System.out.println("LOG IN");
        System.out.println("Input username: ");
        String accountName = sc.next();
        for (int i = 0; i < account.size(); i++) {
            if (accountName.equals(account.get(i).getUsername())) {
                System.out.println("Input password: ");
                String password = sc.next();
                if (password.equals(account.get(i).getPassword())) {
                    if (account.get(i).getRole().equals("Admin")) {
                        mainToy();
                    } else if (account.get(i).getRole().equals("User")) {
                        userMainToy();
                    }
                } else {
                    System.err.println("Wrong password");
                }
            }
        }
    }

    public void writeAccToFile() throws IOException {
        account = readAccFromFile();
        account.add(inputAccount());
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(USER_DATA));
        oos.writeObject(account);
        oos.close();
    }

    public List<User> readAccFromFile() {
        List<User> y = new ArrayList<>();
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(USER_DATA));
            y = (List<User>) objectInputStream.readObject();
            objectInputStream.close();
        } catch (Exception ignored) {
        }
        return y;
    }

    public User inputAccount() {
        List<User> acc = readAccFromFile();
        System.out.println("New Account");
        String username = inputUserName(acc);
        String password = inputPassword();
        String role = inputRole();
        return new User(username, password, role);
    }

    public String inputRole() {
        System.out.println("Admin or User");
        System.out.println("Input role: ");
        String role = sc.next();
        if (role.equals("Admin") || role.equals("User")) {
            return role;
        } else {
            System.err.println("Wrong role");
            return inputRole();
        }
    }

    public void mainMenu() throws Exception {
        int order = -1;
        do {
            System.out.println();
            System.out.println("1: Log in");
            System.out.println("2: Register");
            System.out.println("0: System exit");
            System.out.println("______________");
            order = getOrder();

            switch (order) {
                case 1:
                    logIn(readAccFromFile());
                    break;
                case 2:
                    writeAccToFile();
                    break;
                case 0:
                    System.exit(0);
            }
        } while (order != 1 || order != 2);
    }

    public String inputPassword() {
        System.out.println("Input password: ");
        String password = sc.next();
        sc.nextLine();
        if (password.matches("^\\w{6,20}$")) {
            return password;
        } else {
            System.err.println(PASSWORDS_REGEX);
            return inputPassword();
        }
    }

    public String inputUserName(List<User> acc) {
        System.out.println("Input new username: ");
        String username = sc.next();
        if (username.matches("^\\w{6,20}$")) {
            for (User user : acc) {
                if (user.getUsername().equals(username)) {
                    System.err.println("This username already exists");
                    return inputUserName(acc);
                }
            }
        } else {
            System.err.println(USERNAME_REGEX);
            return inputUserName(acc);
        }
        return username;
    }
}
