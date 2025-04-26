package Day22;
import java.util.*;
import java.util.stream.Collectors;

public class pr2 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Andrew", "Charlie", "Angela", "David");

        List<String> filteredNames = names.stream().filter(name -> !name.startsWith("A")).toList();

        System.out.println("Filtered names: " + filteredNames);
    }
}
