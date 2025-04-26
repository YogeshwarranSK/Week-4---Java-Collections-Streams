package Day18;

import java.util.*;
public class pr1 {
    public static <T> void reverseList(List<T> list) {
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            T temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);
            left++;
            right--;
        }
    }
    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>(Arrays.asList(6, 7, 8, 9,
                10));
        List<Integer> linkedList = new LinkedList<>(Arrays.asList(1, 2, 3, 4,
                5));
        reverseList(arrayList);
        reverseList(linkedList);
        System.out.println("Reversed ArrayList: " + arrayList);
        System.out.println("Reversed LinkedList: " + linkedList);
    }
}