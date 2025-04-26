package Day21;
import java.util.Scanner;

public class pr8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String input = scanner.nextLine();
        String output = input.replaceAll("\\s+", " ");
        System.out.println(output);
        scanner.close();
    }
}

