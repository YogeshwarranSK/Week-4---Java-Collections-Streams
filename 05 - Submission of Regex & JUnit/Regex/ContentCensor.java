package Day21;
import java.util.Scanner;

public class ContentCensor {
    private static final String[] BAD_WORDS = {"damn", "stupid"};

    public static String censor(String input) {
        for (String word : BAD_WORDS) {
            input = input.replaceAll("(?i)\\b" + word + "\\b", "****");
        }
        return input;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String input = scanner.nextLine();
        String censored = censor(input);
        System.out.println(censored);
        scanner.close();
    }
}
