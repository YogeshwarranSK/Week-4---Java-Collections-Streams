package Day22;
import java.util.*;
import java.util.function.Consumer;

public class upperCasePrinter {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("alice", "bob", "charlie");

        Consumer<String> printUpperCase = s -> System.out.println(s.toUpperCase());

        names.forEach(printUpperCase);
    }
}

