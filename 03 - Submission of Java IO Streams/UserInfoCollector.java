package Day19;
import java.io.*;
public class UserInfoCollector {
    public static void main(String[] args) {
        BufferedReader reader = null;
        FileWriter writer = null;
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter your name: ");
            String name = reader.readLine();
            System.out.print("Enter your age: ");
            String age = reader.readLine();
            System.out.print("Enter your fav programming language: ");
            String language = reader.readLine();
            writer = new FileWriter("userinfo.txt");
            writer.write("Name: " + name + "\n");
            writer.write("Age: " + age + "\n");
            writer.write("Favorite Programming Language: " + language + "\n");
            System.out.println("Information saved successfully to userinfo.txt");
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                System.out.println("Error " + e.getMessage());
            }
        }
    }
}
