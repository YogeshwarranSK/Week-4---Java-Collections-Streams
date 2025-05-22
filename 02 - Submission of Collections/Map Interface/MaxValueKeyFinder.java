package Day18;
import java.util.*;

public class MaxValueKeyFinder {
    public static String getMaxKey(Map<String, Integer> map) {
        String maxKey = null;
        int maxValue = Integer.MIN_VALUE;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                maxKey = entry.getKey();
            }
        }
        return maxKey;
    }
    public static void main(String[] args) {
        Map<String, Integer> scores = new HashMap<>();
        scores.put("U", 15);
        scores.put("E", 30);
        scores.put("A", 45);
        String result = getMaxKey(scores);
        System.out.println(result);
    }
}