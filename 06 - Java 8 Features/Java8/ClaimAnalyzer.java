package Day22.Java8;
import java.util.*;
import java.util.stream.*;

public class ClaimAnalyzer {

    public static class Claim {
         String claimId;
         String policyNumber;
         double claimAmount;
         Date claimDate;
         String status;

        public Claim(String claimId, String policyNumber, double claimAmount, Date claimDate, String status) {
            this.claimId = claimId;
            this.policyNumber = policyNumber;
            this.claimAmount = claimAmount;
            this.claimDate = claimDate;
            this.status = status;
        }

        public String getClaimId() { return claimId; }
        public String getPolicyNumber() { return policyNumber; }
        public double getClaimAmount() { return claimAmount; }
        public Date getClaimDate() { return claimDate; }
        public String getStatus() { return status; }
    }

    public static class PolicyStats {
         String policyNumber;
         double totalAmount;
         double averageAmount;

        public PolicyStats(String policyNumber, double totalAmount, double averageAmount) {
            this.policyNumber = policyNumber;
            this.totalAmount = totalAmount;
            this.averageAmount = averageAmount;
        }

        public String getPolicyNumber() { return policyNumber; }
        public double getTotalAmount() { return totalAmount; }
        public double getAverageAmount() { return averageAmount; }

        @Override
        public String toString() {
            return "Policy: " + policyNumber + ", Total: $" + totalAmount + ", Average: $" + averageAmount;
        }
    }

    public static List<PolicyStats> analyzeClaims(List<Claim> claims) {
        Map<String, List<Claim>> grouped = claims.stream()
                .filter(c -> "Approved".equalsIgnoreCase(c.getStatus()) && c.getClaimAmount() > 5000)
                .collect(Collectors.groupingBy(Claim::getPolicyNumber));

        List<PolicyStats> stats = grouped.entrySet().stream()
                .map(entry -> {
                    String policy = entry.getKey();
                    List<Claim> claimList = entry.getValue();
                    double total = claimList.stream().mapToDouble(Claim::getClaimAmount).sum();
                    double avg = claimList.stream().mapToDouble(Claim::getClaimAmount).average().orElse(0);
                    return new PolicyStats(policy, total, avg);
                })
                .sorted(Comparator.comparingDouble(PolicyStats::getTotalAmount).reversed())
                .limit(3)
                .collect(Collectors.toList());

        return stats;
    }

    public static void main(String[] args) {
        List<Claim> claims = Arrays.asList(
                new Claim("C1", "P1001", 6000, new Date(), "Approved"),
                new Claim("C2", "P1001", 7000, new Date(), "Approved"),
                new Claim("C3", "P1002", 4000, new Date(), "Approved"),
                new Claim("C4", "P1002", 8000, new Date(), "Denied"),
                new Claim("C5", "P1003", 12000, new Date(), "Approved"),
                new Claim("C6", "P1004", 10000, new Date(), "Approved"),
                new Claim("C7", "P1004", 15000, new Date(), "Approved"),
                new Claim("C8", "P1005", 3000, new Date(), "Approved"),
                new Claim("C9", "P1006", 9000, new Date(), "Approved")
        );

        List<PolicyStats> topPolicies = analyzeClaims(claims);
        System.out.println("Top 3 Policies by Total Claim Amount:");
        topPolicies.forEach(System.out::println);
    }
}
