package Day22;
import java.util.*;

class Person {
    String name;
    int age;
    double salary;

    public Person(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return name + " - Age: " + age + ", Salary: " + salary;
    }
}

public class sortPeopleByAge {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Alice", 30, 50000),
                new Person("Bob", 25, 60000),
                new Person("Charlie", 35, 55000)
        );

        people.sort((p1, p2) -> Integer.compare(p1.age, p2.age));

        for (Person person : people) {
            System.out.println(person);
        }
    }
}
