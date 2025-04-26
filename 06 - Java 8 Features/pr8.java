package Day22;
import java.util.function.BiFunction;

public class pr8 {
    public static void main(String[] args) {
        BiFunction<String, String, String> concatenate = (s1, s2) -> s1 + " " + s2;

        String result = concatenate.apply("Hello", "World");
        System.out.println("Concatenated string: " + result);
    }
}

