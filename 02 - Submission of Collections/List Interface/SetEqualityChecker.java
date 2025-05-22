package Day18;
import java.util.*;

public class SetEqualityChecker {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(7, 8, 6));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(8, 6, 3));
        boolean areEqual = set1.equals(set2);
        System.out.println("Are two sets equal? " + areEqual);
    }
}