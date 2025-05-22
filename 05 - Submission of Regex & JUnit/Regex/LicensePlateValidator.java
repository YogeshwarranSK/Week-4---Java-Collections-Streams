package Day21;
import java.util.Scanner;
import java.util.regex.Pattern;

public class LicensePlateValidator {
    private static final String PLATE_PATTERN = "^[A-Z]{2}[0-9]{4}$";
    public static boolean isValidPlate(String plate) {
        return Pattern.matches(PLATE_PATTERN, plate);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a license plate number: ");
        String input = scanner.nextLine();
        if (isValidPlate(input)) {
            System.out.println("Valid license plate");
        } else {
            System.out.println("Invalid license plate");
        }
        scanner.close();
    }
}

