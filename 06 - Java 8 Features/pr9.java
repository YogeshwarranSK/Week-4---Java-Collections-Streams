package Day22;
@FunctionalInterface
interface SquareCalculator {
    int square(int number);

    default void printResult(int number) {
        int result = square(number);
        System.out.println("The square of " + number + " is: " + result);
    }
}

public class pr9 {
    public static void main(String[] args) {
        SquareCalculator calculator = n -> n * n;

        calculator.printResult(7);
    }
}

