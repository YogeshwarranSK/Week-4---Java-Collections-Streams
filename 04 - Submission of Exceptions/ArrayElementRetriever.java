package Day20;
import java.util.Scanner;

public class ArrayElementRetriever {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = null;
        try {
            System.out.print("Enter the size of the array: ");
            int size = scanner.nextInt();
            if (size > 0) {
                arr = new int[size];
                for (int i = 0; i < size; i++) {
                    System.out.print("Enter element " + i + ": ");
                    arr[i] = scanner.nextInt();
                }
            }
            System.out.print("Enter the index to retrieve: ");
            int index = scanner.nextInt();
            System.out.println("Value at index " + index + ": " + arr[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index!");
        } catch (NullPointerException e) {
            System.out.println("Array is not initialized!");
        } finally {
            scanner.close();
        }
    }
}
