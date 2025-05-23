package Day22;
@FunctionalInterface
interface SumOperation {
    int sum(int a, int b);
}

public class SumExample {
    public static void main(String[] args) {
        SumOperation sumOperation = Integer::sum;
        int result = sumOperation.sum(5, 7);
        System.out.println("The sum of 5 and 7 is: " + result);
    }
}

