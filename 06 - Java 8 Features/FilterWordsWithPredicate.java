package Day22;
import java.util.*;
import java.util.function.Predicate;

public class FilterWordsWithPredicate {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("hello", "worldwide", "apple", "banana", "wonderful", "hi");

        Predicate<String> lengthGreaterThan5 = s -> s.length() > 5;
        Predicate<String> containsSub = s -> s.contains("wo");

        Predicate<String> combinedPredicate = lengthGreaterThan5.and(containsSub);

        List<String> filteredWords = words.stream().filter(combinedPredicate).toList();

        System.out.println("Filtered words: " + filteredWords);
    }
}
