package Day18;
import java.util.*;
public class pr4 {
    public static <T> List<T> removeDuplicates(List<T> list) {
        Set<T> seen = new LinkedHashSet<>();
        seen.addAll(list);
        return new ArrayList<>(seen);
    }
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3, 8, 2, 2, 3, 6);
        List<Integer> result = removeDuplicates(list);
        System.out.println("After removing duplicates: " + result);
    }
}