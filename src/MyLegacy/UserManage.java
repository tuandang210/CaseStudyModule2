package MyLegacy;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserManage extends FilmManage implements Serializable {
    public static final String USER_DATA = "src\\Data\\UserData.txt";
    public static final String PASSWORDS_REGEX = "Passwords must be at least 6 characters";
    public static final String USERNAME_REGEX = "Username must be at least 6 characters";
    int index;
    List<Film> favor = new ArrayList<>();

    List<User> account = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public void deleteAcc() throws Exception{
        account = readAccFromFile();
        int checked = checkUsername();
        if (checked != -1) {
            if(checked == 0){
                System.err.println("CAN NOT DELETE MAIN ADMIN");
                return;
            }
            if (account.get(checked).getRole().equals("User")) {
                deleteFavoriteFile(checked);
            }
            account.remove(checked);
        } else {
            System.err.println("This username isn't exists");
        }
        System.out.println("Success!");
        System.out.println(account);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(USER_DATA));
        oos.writeObject(account);
        oos.close();
    }

    public void deleteFavoriteFile(int checked) {
        try {
            File file = new File(checked + ".txt");
            if (file.delete()) {
                System.out.println();
            } else {
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println();
        }
    }

    public int checkUsername() {
        int checkUn = -1;
        System.out.println("Enter username that you want to delete: ");
        sc.nextLine();
        String un = sc.next();
        for (int i = 0; i < account.size(); i++) {
            if (un.equals(account.get(i).getUsername())) {
                return i;
            }
        }
        return checkUn;
    }

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
                case 10:
                    updateFavoriteList();
                    break;
                case 11:
                    removeFilmOnFavoriteList();
                    break;
                case 12:
                    showFavoriteList();
                    break;
            }
        }
        while (choice != 0);
    }

    public void showFavoriteList() {
        System.out.println("Your favorite list:");
        List<Film> x = readDataFavor();
        showDataFavor(x);
    }

    public void removeFilmOnFavoriteList() throws IOException {
        List<Film> xyz = readDataFavor();
        removeFavor(xyz);
        writeDataFavor(xyz);
    }

    public void updateFavoriteList() throws Exception {
        creatFile();
        favor = readDataFavor();
        checkFilmFavor(favor);
        writeDataFavor(favor);
    }

    public void creatFile() throws Exception {
        File file = new File(index + ".txt");
        if (file.createNewFile()) {
            System.out.println();
        } else {
            System.out.println();
        }
    }

    public void removeFavor(List<Film> xyz) {
        int count = checkFavorToDelete(xyz);
        if (count != -1) {
            xyz.remove(count);
            System.out.println("The list updated");
        } else {
            System.out.println("This movie isn't on your list");
        }
    }

    public int checkFavorToDelete(List<Film> favor) {
        int op = checkIdException();
        int count = -1;
        for (int i = 0; i < favor.size(); i++) {
            if (favor.get(i).getId() == op) {
                return i;
            }
        }
        return count;
    }

    public void writeDataFavor(List<Film> favor) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(index + ".txt"));
        oos.writeObject(favor);
        oos.close();
    }

    public void checkFilmFavor(List<Film> favor) {
        int x = demoCheckFilmFavor();
        if (x != -1) {
            favor.add(filmList.get(x));
        } else {
            System.err.println("This film isn't exists");
            checkFilmFavor(favor);
        }
    }

    public int demoCheckFilmFavor() {
        int checkFavor = -1;
        int favorFilm = checkIdException();
        for (int i = 0; i < filmList.size(); i++) {
            if (filmList.get(i).getId() == favorFilm) {
                return i;
            }
        }
        return checkFavor;
    }

    public void showDataFavor(List<Film> x) {
        for (Film a : x) {
            System.out.println(a);
        }
    }

    public List<Film> readDataFavor() {
        List<Film> x = new ArrayList<>();
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(index + ".txt"));
            x = (List<Film>) ois.readObject();
            ois.close();
        } catch (Exception e) {
            System.out.println();
        }
        return x;
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
                case 13:
                    deleteAcc();
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
                        index = i;
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
        System.out.println(".________________.");
        System.out.println("|  Admin | User  |");
        System.out.println("|________________|");
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
            System.out.println(".________________.");
            System.out.println("| 1: Log in      |");
            System.out.println("| 2: Register    |");
            System.out.println("| 0: Exit        |");
            System.out.println("|________________|");
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
