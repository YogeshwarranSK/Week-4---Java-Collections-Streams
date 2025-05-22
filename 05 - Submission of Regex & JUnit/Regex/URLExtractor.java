package Day21;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class URLExtractor {
    private static final String URL_PATTERN = "\\bhttps?://[\\w.-]+(?:\\.[a-z]{2,})+\\S*\\b";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String input = scanner.nextLine();
        Pattern pattern = Pattern.compile(URL_PATTERN, Pattern.CASE_INSENSITIVE);
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

