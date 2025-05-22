package Day21;
import java.util.Scanner;
import java.util.regex.Pattern;

public class UsernameValidator {
    private static final String USERNAME_PATTERN = "^[a-zA-Z][a-zA-Z0-9_]{4,14}$";
    public static boolean isValidUsername(String username) {
        return Pattern.matches(USERNAME_PATTERN, username);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a username: ");
        String input = scanner.nextLine();
        if (isValidUsername(input)) {
            System.out.println("Valid username");
        } else {
            System.out.println("Invalid username");
        }
        scanner.close();
    }
}

