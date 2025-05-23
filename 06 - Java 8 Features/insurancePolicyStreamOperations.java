package Day22;
import java.util.*;
import java.util.stream.Collectors;

class InsurancePolicy {
    String policyNumber;
    String holderName;
    double premiumAmount;

    public InsurancePolicy(String policyNumber, String holderName, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.holderName = holderName;
        this.premiumAmount = premiumAmount;
    }

    @Override
    public String toString() {
        return "PolicyNumber: " + policyNumber + ", HolderName: " + holderName + ", Premium: $" + premiumAmount;
    }
}

public class insurancePolicyStreamOperations {
    public static void main(String[] args) {
        List<InsurancePolicy> policies = Arrays.asList(
                new InsurancePolicy("P001", "Alice Smith", 1300),
                new InsurancePolicy("P002", "Bob Johnson", 950),
                new InsurancePolicy("P003", "Charlie Brown", 1500),
                new InsurancePolicy("P004", "Diana Green", 2200),
                new InsurancePolicy("P005", "Eve Smith", 1800),
                new InsurancePolicy("P006", "Frank White", 2100),
                new InsurancePolicy("P007", "George Hill", 700),
                new InsurancePolicy("P008", "Hannah Smith", 1300)
        );

        System.out.println("1. Premium > $1200:");
        policies.stream()
                .filter(p -> p.premiumAmount > 1200)
                .forEach(System.out::println);

        System.out.println("\n2. Sorted by Holder Name:");
        policies.stream()
                .sorted(Comparator.comparing(p -> p.holderName))
                .forEach(System.out::println);

        System.out.println("\n3. Total Premium:");
        double total = policies.stream()
                .mapToDouble(p -> p.premiumAmount)
                .sum();
        System.out.println("$" + total);

        System.out.println("\n4. Print Policy Details:");
        policies.forEach(p -> System.out.println(p));

        System.out.println("\n5. Premium between $1000 and $2000:");
        policies.stream()
                .filter(p -> p.premiumAmount >= 1000 && p.premiumAmount <= 2000)
                .forEach(System.out::println);

        System.out.println("\n6. Highest Premium:");
        policies.stream()
                .max(Comparator.comparingDouble(p -> p.premiumAmount))
                .ifPresent(System.out::println);

        System.out.println("\n7. Grouped by Holder Name Initial:");
        Map<Character, List<InsurancePolicy>> grouped = policies.stream()
                .collect(Collectors.groupingBy(p -> p.holderName.charAt(0)));
        grouped.forEach((initial, list) -> {
            System.out.println(initial + ":");
            list.forEach(System.out::println);
        });

        System.out.println("\n8. Average Premium:");
        policies.stream()
                .mapToDouble(p -> p.premiumAmount)
                .average()
                .ifPresent(avg -> System.out.println("$" + avg));

        System.out.println("\n9. Sorted by Premium:");
        policies.stream()
                .sorted(Comparator.comparingDouble(p -> p.premiumAmount))
                .forEach(System.out::println);

        System.out.println("\n10. Any Policy > $2000:");
        boolean anyAbove2000 = policies.stream().anyMatch(p -> p.premiumAmount > 2000);
        System.out.println(anyAbove2000);

        System.out.println("\n11. Count by Premium Range:");
        Map<String, Long> rangeCounts = policies.stream()
                .collect(Collectors.groupingBy(p -> {
                    if (p.premiumAmount <= 1000) return "$0-$1000";
                    else if (p.premiumAmount <= 2000) return "$1001-$2000";
                    else return ">$2000";
                }, Collectors.counting()));
        rangeCounts.forEach((range, count) -> System.out.println(range + ": " + count));

        System.out.println("\n12. Unique Holder Names:");
        policies.stream()
                .map(p -> p.holderName)
                .distinct()
                .forEach(System.out::println);

        System.out.println("\n13. Holder Name contains 'Smith':");
        policies.stream()
                .filter(p -> p.holderName.contains("Smith"))
                .forEach(System.out::println);

        System.out.println("\n14. Map of Policy Number to Premium:");
        Map<String, Double> policyMap = policies.stream()
                .collect(Collectors.toMap(p -> p.policyNumber, p -> p.premiumAmount));
        policyMap.forEach((k, v) -> System.out.println(k + " -> $" + v));
    }
}
