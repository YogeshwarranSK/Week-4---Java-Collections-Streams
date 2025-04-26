package Day19;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
class Employee implements Serializable {
    private int id;
    private String name;
    private String department;
    private double salary;
    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
    public void display() {
        System.out.println("ID: " + id + ", Name: " + name + ", Department: " + department
                + ", Salary: " + salary);
    }
}
public class pr4 {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Lucky", "HR", 50000));
        employees.add(new Employee(2, "Bhasdkar", "IT", 70000));
        employees.add(new Employee(3, "Raja", "Finance", 60000));
        serializeEmployees(employees, "employees.dat");
        List<Employee> retrievedEmployees = deserializeEmployees("employees.dat");
        if (retrievedEmployees != null) {
            System.out.println("Employee List:");
            for (Employee emp : retrievedEmployees) {
                emp.display();
            }
        }
    }
    private static void serializeEmployees(List<Employee> employees, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new
                FileOutputStream(filename))) {
            oos.writeObject(employees);
            System.out.println("Employees serialized successfully.");
        } catch (IOException e) {
            System.out.println("Serialization Error: " + e.getMessage());
        }
    }
    private static List<Employee> deserializeEmployees(String filename) {
        List<Employee> employees = null;
        try (ObjectInputStream ois = new ObjectInputStream(new
                FileInputStream(filename))) {
            employees = (List<Employee>) ois.readObject();
            System.out.println("Employees deserialized successfully.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Deserialization Error: " + e.getMessage());
        }
        return employees;
    }
}
