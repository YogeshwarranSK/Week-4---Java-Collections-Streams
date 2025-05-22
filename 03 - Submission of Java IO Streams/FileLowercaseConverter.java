package Day19;
import java.io.*;
public class FileLowercaseConverter {
    public static void main(String[] args) {
        String sourceFile = "input.txt";
        String destinationFile = "output.txt";
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new
                FileInputStream(sourceFile), "UTF-8"));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new
                     FileOutputStream(destinationFile), "UTF-8"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line.toLowerCase());
                writer.newLine();
            }
            System.out.println("File conversion completed successfully.");
        } catch (IOException e) {
            System.out.println("error: " + e.getMessage());
        }
    }
}