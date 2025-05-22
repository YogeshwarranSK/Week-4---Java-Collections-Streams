package Day18;

import java.util.*;

public class NthElementFinder {
    public static <T> T findNthFromEnd(LinkedList<T> list, int n) {
        Iterator<T> first = list.iterator();
        Iterator<T> second = list.iterator();
        for (int i = 0; i < n; i++) {
            if (first.hasNext()) {
                first.next();
            }
            else {
                return null;
            }
        }
        while (first.hasNext()) {
            first.next();
            second.next();
        }
        return second.next();
    }
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>(Arrays.asList("L", "Q", "R",
                "H", "M"));
        int n = 2;
        String result = findNthFromEnd(list, n);
        System.out.println("Nth element from end: " + result);
    }
}