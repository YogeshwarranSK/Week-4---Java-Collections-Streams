package Day21;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class pr5 {
    private static final String WORD_PATTERN = "\\b[A-Z][a-zA-Z]*\\b";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String input = scanner.nextLine();
        Pattern pattern = Pattern.compile(WORD_PATTERN);
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
        scanner.close();
    }
}
