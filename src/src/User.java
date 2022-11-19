package src;

import javax.xml.bind.SchemaOutputResolver;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class User {


    //getters
    public String getFullName() {
        return fullName;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public String getEmail() {
        return email;
    }
    public static Set<String> getUsers() {
        return users;
    }
    //setters
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public static void setUsers(Set<String> users) {
        User.users = users;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    private String fullName,username,email,password;
    public static Set<String> users = new HashSet<>();
    // constructor pentru User
    public User(String fullName,String email) {
        this.fullName = fullName;
        this.username= generateUsername(8);
        if (verifyEmail(email)) {
            this.email = email;
        } else {
            throw new InvalidEmailException();
        }

    }

    // metoda verificare email adress valid
    public boolean verifyEmail(String emailAdress) {
        String emailRegex = "^[\\w.*\\-]+@gmail\\.com$";
        Pattern emailPattern = Pattern.compile(emailRegex);
        Matcher matcher = emailPattern.matcher(emailAdress);
        return matcher.find();
    }


    // metoda de generat user automat
    public static String generateUsername(int len) {
        String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijk";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(chars.charAt(rnd.nextInt(chars.length())));
        System.out.println("Numele de utilizator este " +sb);
        return sb.toString();
    }

    public abstract String getClassUser();

    @Override
    public String toString() {
        return "User{" +
                "fullName='" + fullName + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}