package Day18;
import java.util.*;

public class pr20 {
    public static Map<String, Integer> mergeMaps(Map<String, Integer> map1,
                                                 Map<String, Integer> map2) {
        Map<String, Integer> merged = new HashMap<>(map1);
        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            merged.put(entry.getKey(), merged.getOrDefault(entry.getKey(), 0) +
                    entry.getValue());
        }
        return merged;
    }
    public static void main(String[] args) {
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 1);
        map1.put("B", 5);
        Map<String, Integer> map2 = new HashMap<>();
        map2.put("B", 3);
        map2.put("C", 4);
        Map<String, Integer> result = mergeMaps(map1, map2);
        System.out.println(result);
    }
}
