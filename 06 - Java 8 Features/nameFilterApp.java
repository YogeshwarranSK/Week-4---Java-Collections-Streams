package Day22;
import java.util.*;

public class nameFilterApp {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Andrew", "Charlie", "Angela", "David");

        List<String> filteredNames = names.stream().filter(name -> !name.startsWith("A")).toList();

        System.out.println("Filtered names: " + filteredNames);
    }
}
