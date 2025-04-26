package Day19;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.File;
import java.io.IOException;
public class pr1 {
    public static void main(String[] args) {
        String sourcePath = "source.txt.rtf";
        String destinationPath = "destination.txt.rtf";
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File sourceFile = new File(sourcePath);
            if (!sourceFile.exists()) {
                System.out.println("Source file does not exist.");
                return;
            }
            fis = new FileInputStream(sourceFile);
            fos = new FileOutputStream(destinationPath);
            int data;
            while ((data = fis.read()) != -1) {
                fos.write(data);
            }
            System.out.println("File copied successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                System.out.println("Error while closing streams: " + e.getMessage());
            }
        }
    }
}