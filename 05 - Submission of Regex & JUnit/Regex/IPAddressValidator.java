package Day21;
import java.util.Scanner;
import java.util.regex.Pattern;

public class IPAddressValidator {
    private static final String IP_PATTERN = "^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";

    public static boolean isValidIP(String ip) {
        return Pattern.matches(IP_PATTERN, ip);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an IP address: ");
        String input = scanner.nextLine();
        if (isValidIP(input)) {
            System.out.println("Valid IP address");
        } else {
            System.out.println("Invalid IP address");
        }
        scanner.close();
    }
}
