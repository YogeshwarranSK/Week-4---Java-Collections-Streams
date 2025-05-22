package Day19;
import java.io.*;
public class ImageByteArrayCopy {
    public static void main(String[] args) {
        String sourceImagePath = "sourceImg.jpg";
        String destinationImagePath = "copiedImg.jpg";
        try {
            byte[] imageBytes = convertImageToByteArray(sourceImagePath);
            if (imageBytes != null) {
                writeByteArrayToImage(imageBytes, destinationImagePath);
                System.out.println("Image copied successfully.");
            } else {
                System.out.println("Failed to convert image to byte array.");
            }
        } catch (IOException e) {
            System.out.println("error: " + e.getMessage());
        }
    }
    private static byte[] convertImageToByteArray(String imagePath) throws IOException {
        try (FileInputStream fis = new FileInputStream(imagePath);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }
            return baos.toByteArray();
        }
    }
    private static void writeByteArrayToImage(byte[] imageBytes, String outputPath)
            throws IOException {
        try (ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
             FileOutputStream fos = new FileOutputStream(outputPath)) {
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = bais.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        }
    }
}
