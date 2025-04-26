package Day18;
import java.util.*;

public class pr8 {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(3, 8, 7));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(8, 6, 5));
        Set<Integer> symmetricDiff = new HashSet<>(set1);
        symmetricDiff.addAll(set2);
        Set<Integer> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);
        symmetricDiff.removeAll(intersection);
        System.out.println("Symmetric Difference: " + symmetricDiff);
    }
}