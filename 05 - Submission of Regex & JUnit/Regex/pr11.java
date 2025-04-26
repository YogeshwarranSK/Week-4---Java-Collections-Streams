package Day21;
import java.util.Scanner;
import java.util.regex.Pattern;

public class pr11 {
    private static final String VISA_PATTERN = "^4\\d{15}$";
    private static final String MASTERCARD_PATTERN = "^5\\d{15}$";

    public static boolean isValidCard(String cardNumber) {
        return Pattern.matches(VISA_PATTERN, cardNumber) || Pattern.matches(MASTERCARD_PATTERN, cardNumber);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a credit card number: ");
        String input = scanner.nextLine();
        if (isValidCard(input)) {
            System.out.println("Valid credit card number");
        } else {
            System.out.println("Invalid credit card number");
        }
        scanner.close();
    }
}
