package Day22.Java8;
import java.util.*;
import java.util.stream.Collectors;

class PolicyHolder {
    int holderId;
    String name;
    int age;
    String policyType;
    double premiumAmount;

    public PolicyHolder(int holderId, String name, int age, String policyType, double premiumAmount) {
        this.holderId = holderId;
        this.name = name;
        this.age = age;
        this.policyType = policyType;
        this.premiumAmount = premiumAmount;
    }
}

class RiskAssessment {
    int holderId;
    String name;
    double riskScore;
    String riskCategory;

    public RiskAssessment(int holderId, String name, double riskScore, String riskCategory) {
        this.holderId = holderId;
        this.name = name;
        this.riskScore = riskScore;
        this.riskCategory = riskCategory;
    }

    @Override
    public String toString() {
        return holderId + " - " + name + " - " + riskScore + " - " + riskCategory;
    }
}

public class PolicyRiskAnalyzer {
    public static List<RiskAssessment> assessPolicyHolderRisks(List<PolicyHolder> holders) {
        return holders.stream()
                .filter(h -> h.policyType.equals("Life") && h.age > 60)
                .map(h -> {
                    double riskScore = h.premiumAmount / h.age;
                    String riskCategory = riskScore > 0.5 ? "High Risk" : "Low Risk";
                    return new RiskAssessment(h.holderId, h.name, riskScore, riskCategory);
                })
                .sorted((a, b) -> Double.compare(b.riskScore, a.riskScore))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<PolicyHolder> holders = Arrays.asList(
                new PolicyHolder(1, "Alice", 65, "Life", 40.0),
                new PolicyHolder(2, "Bob", 70, "Health", 60.0),
                new PolicyHolder(3, "Carol", 72, "Life", 50.0),
                new PolicyHolder(4, "Dave", 61, "Life", 35.0)
        );

        List<RiskAssessment> assessments = assessPolicyHolderRisks(holders);
        assessments.forEach(System.out::println);
    }
}
