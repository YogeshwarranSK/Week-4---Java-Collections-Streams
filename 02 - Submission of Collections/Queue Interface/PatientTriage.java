package Day18;
import java.util.*;
class Patient {
    String name;
    int severity;
    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }
    @Override
    public String toString() {
        return name + " (Severity: " + severity + ")";
    }
}
public class PatientTriage {
    public static void main(String[] args) {
        PriorityQueue<Patient> triageQueue = new PriorityQueue<>(
                (a, b) -> b.severity - a.severity);
        triageQueue.add(new Patient("Ravi", 3));
        triageQueue.add(new Patient("Shankar", 5));
        triageQueue.add(new Patient("Nithish", 2));
        System.out.println("Treatment Order:");
        while (!triageQueue.isEmpty()) {
            Patient p = triageQueue.poll();
            System.out.println(p);
        }
    }
}