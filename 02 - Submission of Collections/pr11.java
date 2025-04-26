package Day18;
import java.time.LocalDate;
import java.util.*;
class Policy implements Comparable<Policy> {
     String policyNumber;
     String policyHolderName;
     LocalDate expiryDate;
     String coverageType;
     double premiumAmount;
    public Policy(String policyNumber, String policyHolderName, LocalDate
            expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyHolderName = policyHolderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }
    public String getPolicyNumber() { return policyNumber; }
    public String getCoverageType() { return coverageType; }
    public LocalDate getExpiryDate() { return expiryDate; }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Policy)) return false;
        return this.policyNumber.equals(((Policy) o).policyNumber);
    }
    @Override
    public int hashCode() {
        return policyNumber.hashCode();
    }
    @Override
    public int compareTo(Policy other) {
        return this.expiryDate.compareTo(other.expiryDate);
    }
    @Override
    public String toString() {
        return policyNumber + " | " + policyHolderName + " | " + expiryDate + " | " + coverageType + " | " + premiumAmount;
    }
}

public class pr11 {
    public static void main(String[] args) {
        Set<Policy> hashSet = new HashSet<>();
        Set<Policy> linkedHashSet = new LinkedHashSet<>();
        Set<Policy> treeSet = new TreeSet<>();
        Policy p1 = new Policy("32", "Yogesh", LocalDate.now().plusDays(10),
                "Health", 5000);
        Policy p2 = new Policy("P64", "Kheshav", LocalDate.now().plusDays(45),
                "Auto", 7000);
        Policy p3 = new Policy("P57", "Sai", LocalDate.now().plusDays(20),
                "Home", 6000);
        Policy p4 = new Policy("P63", "Aswin", LocalDate.now().plusDays(10),
                "Health", 5000);
        addToAllSets(p1, hashSet, linkedHashSet, treeSet);
        addToAllSets(p2, hashSet, linkedHashSet, treeSet);
        addToAllSets(p3, hashSet, linkedHashSet, treeSet);
        addToAllSets(p4, hashSet, linkedHashSet, treeSet);
        System.out.println("\n--- All Unique Policies (HashSet) ---");
        displayPolicies(hashSet);
        System.out.println("\n--- Policies Expiring in Next 30 Days ---");
        getExpiringSoon(hashSet);
        System.out.println("\n--- Policies with Coverage Type 'Health' ---");
        getByCoverageType(hashSet, "Health");
        System.out.println("\n--- Duplicates Based on Policy Number ---");
        findDuplicates(Arrays.asList(p1, p2, p3, p4));
        System.out.println("\n--- Performance Comparison ---");
        performanceTest(new HashSet<>(), "HashSet");
        performanceTest(new LinkedHashSet<>(), "LinkedHashSet");
        performanceTest(new TreeSet<>(), "TreeSet");
    }
    public static void addToAllSets(Policy policy, Set<Policy>... sets) {
        for (Set<Policy> set : sets) {
            set.add(policy);
        }
    }
    public static void displayPolicies(Set<Policy> set) {
        for (Policy policy : set) {
            System.out.println(policy);
        }
    }
    public static void getExpiringSoon(Set<Policy> set) {
        LocalDate today = LocalDate.now();
        for (Policy policy : set) {
            if (policy.getExpiryDate().isBefore(today.plusDays(30))) {
                System.out.println(policy);
            }
        }
    }
    public static void getByCoverageType(Set<Policy> set, String type) {
        for (Policy policy : set) {
            if (policy.getCoverageType().equalsIgnoreCase(type)) {
                System.out.println(policy);
            }
        }
    }
    public static void findDuplicates(List<Policy> policies) {
        Set<String> seen = new HashSet<>();
        for (Policy p : policies) {
            if (!seen.add(p.getPolicyNumber())) {
                System.out.println("Duplicate: " + p);
            }
        }
    }
    public static void performanceTest(Set<Policy> set, String type) {
        long start = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            set.add(new Policy("PX" + i, "Holder" + i,
                    LocalDate.now().plusDays(i), "Auto", 1000));
        }
        long end = System.nanoTime();
        System.out.println(type + " Add Time: " + (end - start) / 1_000_000.0 +
                " ms");
    }
}