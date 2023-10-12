import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("welcome to my program :) ");
        ArrayList<User> users = new ArrayList<>();
        User user = new User();
        users = reading_from_file(users);
        main_menu(user, users);

    }

    public static void main_menu(User user, ArrayList<User> users) {
        System.out.println(" ---- menu ---- ");
        System.out.println(" 1. create user ");
        System.out.println(" 2. update information of user ");
        System.out.println(" 3. read all users ");
        System.out.println(" 4. delete user ");
        System.out.println(" 5. exit ");
        System.out.println(" >>> your choice : ");
        int choice = scanner.nextInt();
        while (choice <= 0 || choice >= 6) {
            System.out.println("input is wrong");
            System.out.println(" >>> your choice : ");
            choice = scanner.nextInt();
        }
        switch (choice) {
            case 1:
                UserManagement.create( users);
                System.out.println("\n\n **** finish Create **** ");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                main_menu(user, users);
                break;
            case 2:
                UserManagement.update(users);
                System.out.println("\n\n **** finish Update **** ");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                main_menu(user, users);
                break;
            case 3:
                UserManagement.read(users);
                System.out.println("\n\n **** finish Read **** ");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                main_menu(user, users);
                break;
            case 4:
                UserManagement.delete(users);
                System.out.println("\n\n **** finish Delete **** ");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                main_menu(user, users);
                break;
            case 5:
                System.exit(1);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                main_menu(user, users);
                break;
        }
    }

    public static void writing_to_the_file(ArrayList<User> users) {
        String filePath = "users.dat";
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(filePath);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(users);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<User> reading_from_file(ArrayList<User> users) {
        String filePath = "users.dat";

        try (FileInputStream fileInputStream = new FileInputStream(filePath);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {

            users = (ArrayList<User>) objectInputStream.readObject();


        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return users;
    }
}