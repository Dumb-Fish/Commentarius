package commentarius;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Scanner;

public abstract class User {
    Scanner an = new Scanner(System.in);
    private HashMap<String, String> listOfUsers;
    private String username;
    private String password;

    User(HashMap<String, String> listOfUsers) {
        this.listOfUsers = listOfUsers;
        Scanner an = new Scanner(System.in);
        System.out.println("""
                whats u gonna do?
                1. sign up
                2. login in""");
        int action = an.nextInt();
        System.out.println("enter username");
        this.username = an.next().strip();
        System.out.println("enter password");
        this.password = an.next().strip();
        switch (action) {
            case 1:
                creatingAccount();
                break;
            case 2:
                if (getVerification()) System.out.println("you have successfully logged in to your account");
                else System.out.println("username or password entered incorrectly");
                break;
            default:
                System.out.println("incorrect input");
                System.exit(0);
        }
        if (action == 1) {
            System.out.println("Hello " + username + ", welcome to your account!");
        }
    }

    public HashMap<String, String> getListOfUsers() {
        return listOfUsers;
    }

    private void creatingAccount() {
        listOfUsers.put(username, encryption(password));
    }

    private boolean getVerification() {
        return listOfUsers.containsKey(this.username.strip()) && listOfUsers.containsValue(encryption(password));
    }

    private String encryption(String password) {
        this.password = password;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = md.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            System.out.println("something wrong...");
            return null;
        }
    }

    protected void editAccount(int action) {
        switch (action) {
            case 1:
                String value = listOfUsers.remove(username);
                System.out.println("enter new username");
                listOfUsers.put(this.username = an.next(), value);
                System.out.println("your account has been updated");
                break;
            case 2:
                System.out.println("enter new password");
                listOfUsers.put(username, encryption(an.next()));
                System.out.println("your account has been updated");
                break;
            case 3:
                break;
            default:
                System.out.println("incorrect input");
        }
    }
}
