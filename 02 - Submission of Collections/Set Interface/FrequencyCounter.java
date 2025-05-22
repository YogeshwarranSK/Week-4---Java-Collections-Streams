package Day18;
import java.util.*;
public class FrequencyCounter {
    public static Map<String, Integer> countFrequency(List<String> list) {
        Map<String, Integer> frequency = new HashMap<>();
        for (String item : list) {
            frequency.put(item, frequency.getOrDefault(item, 0) + 1);
        }
        return frequency;
    }
    public static void main(String[] args) {
        List<String> items = Arrays.asList("car", "bike", "car", "car", "bike",
                "truck");
        Map<String, Integer> result = countFrequency(items);
        System.out.println("Frequency of elements: " + result);
    }
}