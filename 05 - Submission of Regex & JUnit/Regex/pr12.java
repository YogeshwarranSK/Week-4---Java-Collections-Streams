package Day21;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class pr12 {
    private static final String LANGUAGES = "\\b(Java|Python|JavaScript|Go|C|C\\+\\+|Ruby|Swift|PHP|Kotlin)\\b";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String input = scanner.nextLine();
        Pattern pattern = Pattern.compile(LANGUAGES);
        Matcher matcher = pattern.matcher(input);
        boolean found = false;
        while (matcher.find()) {
            if (found) System.out.print(", ");
            System.out.print(matcher.group());
            found = true;
        }
        scanner.close();
    }
}
