package Day19;
import java.io.*;
public class pr2 {
    public static void main(String[] args) {
        String sourcePath = "largefilSource.dat";
        String bufferedPath = "largefilebuffer.dat";
        String unbufferedPath = "largefileUnbuffer.dat";
        long timeBuffered = copyUsingBufferedStreams(sourcePath, bufferedPath);
        long timeUnbuffered = copyUsingUnbufferedStreams(sourcePath, unbufferedPath);
        System.out.println("Time taken with Buffered Streams: " + timeBuffered + " nanoseconds");
        System.out.println("Time taken with Unbuffered Streams: " + timeUnbuffered + " nanoseconds");
    }
    private static long copyUsingBufferedStreams(String source, String destination) {
        long startTime = System.nanoTime();
        try (BufferedInputStream bis = new BufferedInputStream(new
                FileInputStream(source));
             BufferedOutputStream bos = new BufferedOutputStream(new
                     FileOutputStream(destination))) {
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            System.out.println("Buffered Stream Error: " + e.getMessage());
        }
        long endTime = System.nanoTime();
        return endTime - startTime;
    }
    private static long copyUsingUnbufferedStreams(String source, String destination) {
        long startTime = System.nanoTime();
        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(destination)) {
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            System.out.println("Unbuffered Stream Error: " + e.getMessage());
        }
        long endTime = System.nanoTime();
        return endTime - startTime;
    }
}