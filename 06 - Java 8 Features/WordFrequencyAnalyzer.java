package Day22;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WordFrequencyAnalyzer {
    public static void main(String[] args) {
        String text = "Java is a popular programming language. Java is widely used in web development. " +
                "Java has many libraries. Learning Java is fun.";

        List<String> words = Arrays.stream(text.split("\\W+"))
                .map(String::toLowerCase)
                .toList();

        Map<String, Long> wordFrequency = words.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        int N = 3;
        List<Map.Entry<String, Long>> topNWords = wordFrequency.entrySet().stream()
                .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
                .limit(N)
                .toList();

        System.out.println("Top " + N + " most frequent words:");
        topNWords.forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));

        Optional<Map.Entry<String, Long>> secondMostFrequent = wordFrequency.entrySet().stream()
                .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
                .skip(1)
                .findFirst();

        secondMostFrequent.ifPresent(entry -> System.out.println("Second most frequent word: " + entry.getKey() + " with frequency " + entry.getValue()));
    }
}

