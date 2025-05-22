package Day18;
import java.util.*;

public class InvertMapUtility {
    public static <K, V> Map<V, List<K>> invertMap(Map<K, V> inputMap) {
        Map<V, List<K>> inverted = new HashMap<>();
        for (Map.Entry<K, V> entry : inputMap.entrySet()) {
            V value = entry.getValue();
            K key = entry.getKey();
            inverted.putIfAbsent(value, new ArrayList<>());
            inverted.get(value).add(key);
        }
        return inverted;
    }
    public static void main(String[] args) {
        Map<String, Integer> original = new HashMap<>();
        original.put("A", 3);
        original.put("B", 4);
        original.put("C", 5);
        Map<Integer, List<String>> inverted = invertMap(original);
        System.out.println(inverted);
    }
}