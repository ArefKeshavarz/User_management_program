import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class UserManagement implements Serializable {
    private ArrayList<User> users;
    static Scanner scanner = new Scanner(System.in);

    public static void create(ArrayList<User> users) {
        User user = new User();
        System.out.println("---- Create ----");
        // for receive information :
        System.out.print("Enter your name: ");
        user.setName(scanner.nextLine());

        System.out.print("Enter your family name: ");
        user.setFmaily(scanner.nextLine());

        System.out.print("Enter your phone number: ");
        user.setPhone_number(scanner.nextLine());

        System.out.print("Enter your username: ");
        user.setUser_name(scanner.nextLine());

        System.out.print("Enter your password: ");
        user.setPassword(scanner.nextLine());

        System.out.print("Enter your email address: ");
        user.setEmail(scanner.nextLine());

        // for add user :
        boolean repetitious = false;
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()) {
            User user1 = iterator.next();
            if (user.getUser_name().equals(user1.getUser_name()) || user.getEmail().equals(user1.getEmail())) {
                System.out.println("username or email is Repetitious ");
                repetitious = true;
                break;
            }
        }
        if (!repetitious) {
            users.add(user);
            repetitious = false;
        }
        Main.writing_to_the_file(users);
    }

    public static void read(ArrayList<User> users) {
        System.out.println("---- Read ----");
        System.out.println("information of all users is : ");
        for (User user : users) {
            System.out.println("\n- - - - - - - - - - - ");
            System.out.println("username : " + user.getUser_name());
            System.out.println("name : " + user.getName());
            System.out.println("family : " + user.getFmaily());
            System.out.println("phone number : " + user.getPhone_number());
            System.out.println("email: " + user.getEmail());
        }
    }

    public static void update(ArrayList<User> users) {
        System.out.println("---- Update ----");
        System.out.println("please enter username of user that you want update : ");
        String input_username = scanner.nextLine();
        for (User user : users) {
            if (user.getUser_name().equals(input_username)) {
                System.out.println("Which feature do you want to modify? ");
                System.out.println("1. Name");
                System.out.println("2. Family");
                System.out.println("3. Phone Number");
                System.out.println("4. Email");
                System.out.println("5. Password");
                System.out.print(" >>> Enter your choice: ");
                int choice = scanner.nextInt();
                System.out.println();
                switch (choice) {
                    case 1:
                        System.out.print("Enter new name: ");
                        scanner.nextLine();
                        user.setName(scanner.nextLine());
                        System.out.println("Name updated successfully.");
                        break;
                    case 2:
                        System.out.print("Enter new family: ");
                        user.setFmaily(scanner.nextLine());
                        System.out.println("Family updated successfully.");
                        break;
                    case 3:
                        System.out.print("Enter new phone number: ");
                        user.setPhone_number(scanner.nextLine());
                        System.out.println("Phone number updated successfully.");
                        break;
                    case 4:
                        System.out.print("Enter new email: ");
                        user.setEmail(scanner.nextLine());
                        System.out.println("Email updated successfully.");
                        break;
                    case 5:
                        System.out.print("Enter new password: ");
                        user.setPassword(scanner.nextLine());
                        System.out.println("Password updated successfully.");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            }
        }
        Main.writing_to_the_file(users);
    }

    public static void delete(ArrayList<User> users) {
        System.out.println("---- Delete ---- ");
        System.out.println("please enter username of user that you want update : ");
        String input_username = scanner.nextLine();
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            if (user.getUser_name().equals(input_username)) {
                iterator.remove();
            }
        }
        Main.writing_to_the_file(users);
    }
}
