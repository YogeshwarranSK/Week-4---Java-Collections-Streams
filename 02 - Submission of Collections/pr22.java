package Day18;
import java.time.LocalDate;
import java.util.*;

public class pr22 {
    static class Policy {
        String policyNumber;
        String policyholderName;
        LocalDate expiryDate;
        public Policy(String policyNumber, String policyholderName, LocalDate
                expiryDate) {
            this.policyNumber = policyNumber;
            this.policyholderName = policyholderName;
            this.expiryDate = expiryDate;
        }
        public String toString() {
            return policyNumber + " - " + policyholderName + " - " + expiryDate;
        }
    }
    static class PolicyManager {
        Map<String, Policy> hashMap = new HashMap<>();
        Map<String, Policy> linkedHashMap = new LinkedHashMap<>();
        TreeMap<LocalDate, List<Policy>> treeMap = new TreeMap<>();
        public void addPolicy(Policy policy) {
            hashMap.put(policy.policyNumber, policy);
            linkedHashMap.put(policy.policyNumber, policy);
            treeMap.putIfAbsent(policy.expiryDate, new ArrayList<>());
            treeMap.get(policy.expiryDate).add(policy);
        }
        public Policy getPolicyByNumber(String number) {
            return hashMap.get(number);
        }
        public List<Policy> getPoliciesExpiringIn30Days() {
            LocalDate now = LocalDate.now();
            LocalDate limit = now.plusDays(30);
            SortedMap<LocalDate, List<Policy>> upcoming = treeMap.subMap(now,
                    true, limit, true);
            List<Policy> result = new ArrayList<>();
            for (List<Policy> list : upcoming.values()) result.addAll(list);
            return result;
        }
        public List<Policy> getPoliciesByHolder(String name) {
            List<Policy> result = new ArrayList<>();
            for (Policy p : hashMap.values()) {
                if (p.policyholderName.equalsIgnoreCase(name)) {
                    result.add(p);
                }
            }
            return result;
        }
        public void removeExpiredPolicies() {
            LocalDate today = LocalDate.now();
            hashMap.entrySet().removeIf(entry ->
                    entry.getValue().expiryDate.isBefore(today));
            linkedHashMap.entrySet().removeIf(entry ->
                    entry.getValue().expiryDate.isBefore(today));
            treeMap.headMap(today, false).clear();
        }
        public void printAllPolicies() {
            for (Policy p : linkedHashMap.values()) {
                System.out.println(p);
            }
        }
    }
    public static void main(String[] args) {
        PolicyManager manager = new PolicyManager();
        manager.addPolicy(new Policy("P56", "Yogesh",
                LocalDate.now().plusDays(10)));
        manager.addPolicy(new Policy("P98", "Aswin",
                LocalDate.now().plusDays(40)));
        manager.addPolicy(new Policy("P3", "Sagar",
                LocalDate.now().minusDays(5)));
        System.out.println("Get Policy P56:");
        System.out.println(manager.getPolicyByNumber("P56"));
        System.out.println("\nPolicies expiring in 30 days:");
        for (Policy p : manager.getPoliciesExpiringIn30Days())
            System.out.println(p);
        System.out.println("\nPolicies for Bhaskar:");
        for (Policy p : manager.getPoliciesByHolder("Bhaskar"))
            System.out.println(p);
        manager.removeExpiredPolicies();
        System.out.println("\nAll Active Policies (after removing expired):");
        manager.printAllPolicies();
    }
}