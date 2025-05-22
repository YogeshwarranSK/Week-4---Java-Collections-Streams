package Day19;
import java.io.*;
public class PipedStreamExample {
    public static void main(String[] args) {
        try {
            PipedOutputStream pos = new PipedOutputStream();
            PipedInputStream pis = new PipedInputStream(pos);
            Thread writerThread = new Thread(new Writer(pos));
            Thread readerThread = new Thread(new Reader(pis));
            writerThread.start();
            readerThread.start();
        } catch (IOException e) {
            System.out.println("Error setting up piped streams: " + e.getMessage());
        }
    }
}
class Writer implements Runnable {
    private PipedOutputStream pos;
    public Writer(PipedOutputStream pos) {
        this.pos = pos;
    }
    @Override
    public void run() {
        try {
            String message = "Hello from Writer Thread!";
            pos.write(message.getBytes());
            pos.close();
        } catch (IOException e) {
            System.out.println("Writer error: " + e.getMessage());
        }
    }
}
class Reader implements Runnable {
    private PipedInputStream pis;
    public Reader(PipedInputStream pis) {
        this.pis = pis;
    }
    @Override
    public void run() {
        try {
            int data;
            while ((data = pis.read()) != -1) {
                System.out.print((char) data);
            }
            pis.close();
        } catch (IOException e) {
            System.out.println("Reader error: " + e.getMessage());
        }
    }
}