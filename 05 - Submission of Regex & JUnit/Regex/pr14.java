package Day21;
import java.util.regex.*;
import java.util.*;

public class pr14 {
    public static void main(String[] args) {
        String text = "This is is a repeated repeated word test.";
        Pattern pattern = Pattern.compile("\\b(\\w+)\\b\\s+\\1\\b", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        Set<String> repeated = new LinkedHashSet<>();
        while (matcher.find()) {
            repeated.add(matcher.group(1));
        }
        System.out.println(String.join(", ", repeated));
    }
}
