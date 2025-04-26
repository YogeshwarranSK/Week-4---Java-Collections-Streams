package Day18;
import java.util.*;
public class pr3 {
    public static <T> List<T> rotateLeft(List<T> list, int k) {
        int n = list.size();
        k = k % n;
        List<T> result = new ArrayList<>();
        result.addAll(list.subList(k, n));
        result.addAll(list.subList(0, k));
        return result;
    }
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(46, 22, 30, 91, 83);
        int k = 2;
        List<Integer> rotatedList = rotateLeft(list, k);
        System.out.println("Rotated List: " + rotatedList);
    }
}