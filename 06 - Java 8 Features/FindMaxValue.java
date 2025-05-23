package Day22;
import java.util.*;

public class FindMaxValue {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 25, 5, 30, 15);

        Optional<Integer> max = numbers.stream()
                .max(Integer::compareTo);

        max.ifPresentOrElse(
                value -> System.out.println("Maximum value: " + value),
                () -> System.out.println("List is empty, no maximum value.")
        );
    }
}

