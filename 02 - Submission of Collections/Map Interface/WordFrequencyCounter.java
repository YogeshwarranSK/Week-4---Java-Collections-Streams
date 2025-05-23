package Day18;
import java.io.*;
import java.util.*;

public class WordFrequencyCounter {
    public static Map<String, Integer> countWordFrequency(String filename)
            throws IOException {
        Map<String, Integer> wordCount = new HashMap<>();
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = reader.readLine()) != null) {
            line = line.toLowerCase().replaceAll("[^a-z0-9\\s]", "");
            String[] words = line.split("\\s+");
            for (String word : words) {
                if (!word.isEmpty()) {
                    wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                }
            }
        }
        reader.close();
        return wordCount;
    }
    public static void main(String[] args) throws IOException {
        String filename = "Java.txt";
        Map<String, Integer> result = countWordFrequency(filename);
        System.out.println(result);
    }
}
