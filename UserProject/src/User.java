import java.io.Serializable;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
public class User implements Serializable {

    private String name;
    private String fmaily;
    private String phone_number;
    private String user_name;
    private String password;
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFmaily() {
        return fmaily;
    }

    public void setFmaily(String fmaily) {
        this.fmaily = fmaily;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        if (isValidPhoneNumber(phone_number)) {
            this.phone_number = phone_number;
        } else {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Invalid phone number format");
            System.out.println("please enter again : ");
            setPhone_number(scanner.nextLine());
        }
    }

    private boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumber.matches("[0-9\\-]+");
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (isValidEmail(email)) {
            this.email = email;
        } else {
            System.out.println("Invalid email address");
        }
    }
    private boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
