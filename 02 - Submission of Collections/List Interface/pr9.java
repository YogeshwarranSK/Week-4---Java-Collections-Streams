package Day18;
import java.util.*;

public class pr9 {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>(Arrays.asList(6, 8, 5, 2));
        List<Integer> sortedList = new ArrayList<>(set);
        Collections.sort(sortedList);
        System.out.println("Sorted List: " + sortedList);
    }
}