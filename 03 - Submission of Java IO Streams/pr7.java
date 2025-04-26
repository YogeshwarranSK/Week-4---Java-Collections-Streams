package Day19;
import java.io.*;
public class pr7 {
    public static void main(String[] args) {
        String fileName = "students.dat";
        writeStudentData(fileName);
        readStudentData(fileName);
    }
    private static void writeStudentData(String fileName) {
        try (DataOutputStream dos = new DataOutputStream(new
                FileOutputStream(fileName))) {
            dos.writeInt(1);
            dos.writeUTF("Aswin");
            dos.writeDouble(8.7);
            dos.writeInt(2);
            dos.writeUTF("Kumar");
            dos.writeDouble(9.1);
            dos.writeInt(3);
            dos.writeUTF("Gopal");
            dos.writeDouble(7.9);
            System.out.println("Student data written successfully.");
        } catch (IOException e) {
            System.out.println("Error writing data: " + e.getMessage());
        }
    }
    private static void readStudentData(String fileName) {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(fileName))) {
            while (dis.available() > 0) {
                int roll = dis.readInt();
                String name = dis.readUTF();
                double gpa = dis.readDouble();
                System.out.println("Roll: " + roll + ", Name: " + name + ", GPA: " + gpa);
            }
        } catch (IOException e) {
            System.out.println("Error reading data: " + e.getMessage());
        }
    }
}