package Day21;
import java.util.Scanner;
import java.util.regex.Pattern;

public class pr3 {
    private static final String HEX_PATTERN = "^#[0-9a-fA-F]{6}$";
    public static boolean isValidHex(String hex) {
        return Pattern.matches(HEX_PATTERN, hex);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a hex color code: ");
        String input = scanner.nextLine();
        if (isValidHex(input)) {
            System.out.println("Valid hex color code");
        } else {
            System.out.println("Invalid hex color code");
        }
        scanner.close();
    }
}

