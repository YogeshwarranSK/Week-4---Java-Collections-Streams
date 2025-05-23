package Day22.Java8;
import java.util.*;
import java.util.stream.*;

public class EmployeeDataProcessor {

    public static class Employee {
         int id;
         String name;
         String department;
         double salary;

        public Employee(int id, String name, String department, double salary) {
            this.id = id;
            this.name = name;
            this.department = department;
            this.salary = salary;
        }

        public String getName() { return name; }
        public String getDepartment() { return department; }
        public double getSalary() { return salary; }

        @Override
        public String toString() {
            return name + " (" + department + ", $" + salary + ")";
        }
    }

    public static void processEmployees(List<Employee> employees) {
        List<Employee> filteredEmployees = employees.stream()
                .filter(e -> "Engineering".equalsIgnoreCase(e.getDepartment()) && e.getSalary() > 80000)
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .toList();

        Map<String, List<Employee>> groupedByDept = filteredEmployees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

        Map<String, Double> avgSalaryByDept = groupedByDept.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().stream()
                                .collect(Collectors.averagingDouble(Employee::getSalary))
                ));

        System.out.println("Filtered and Sorted Employees:");
        filteredEmployees.forEach(System.out::println);

        System.out.println("\nGrouped by Department:");
        groupedByDept.forEach((dept, list) -> System.out.println(dept + ": " + list));

        System.out.println("\nAverage Salary by Department:");
        avgSalaryByDept.forEach((dept, avg) -> System.out.println(dept + ": $" + avg));
    }

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Alice", "Engineering", 90000),
                new Employee(2, "Bob", "Engineering", 75000),
                new Employee(3, "Charlie", "HR", 70000),
                new Employee(4, "David", "Engineering", 85000),
                new Employee(5, "Eve", "Marketing", 80000),
                new Employee(6, "Frank", "Engineering", 95000)
        );

        processEmployees(employees);
    }
}

