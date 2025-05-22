package Day18;
import java.util.*;
class Employee {
    String name;
    String department;
    public Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }
    public String toString() {
        return name;
    }
}
public class EmployeeDepartmentGrouper {
    public static Map<String, List<Employee>> groupByDepartment(List<Employee> employees) {
        Map<String, List<Employee>> departmentMap = new HashMap<>();
        for (Employee e : employees) {
            departmentMap.putIfAbsent(e.department, new ArrayList<>());
            departmentMap.get(e.department).add(e);
        }
        return departmentMap;
    }
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Bhaskar", "HR"),
                new Employee("Raja", "IT"),
                new Employee("Lucky", "HR")
        );
        Map<String, List<Employee>> grouped = groupByDepartment(employees);
        for (Map.Entry<String, List<Employee>> entry : grouped.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}