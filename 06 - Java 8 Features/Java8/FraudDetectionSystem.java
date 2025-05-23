package Day22.Java8;
import java.util.*;
import java.util.stream.Collectors;

class Transaction {
    int transactionId;
    String policyNumber;
    double amount;
    String transactionDate;
    boolean isFraudulent;

    public Transaction(int transactionId, String policyNumber, double amount, String transactionDate, boolean isFraudulent) {
        this.transactionId = transactionId;
        this.policyNumber = policyNumber;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.isFraudulent = isFraudulent;
    }

    // Getter method for policyNumber
    public String getPolicyNumber() {
        return policyNumber;
    }
}

class FraudAlert {
    String policyNumber;
    int fraudulentTransactionCount;
    double totalFraudAmount;

    public FraudAlert(String policyNumber, int fraudulentTransactionCount, double totalFraudAmount) {
        this.policyNumber = policyNumber;
        this.fraudulentTransactionCount = fraudulentTransactionCount;
        this.totalFraudAmount = totalFraudAmount;
    }

    @Override
    public String toString() {
        return "Policy: " + policyNumber + ", Fraudulent Transactions: " + fraudulentTransactionCount + ", Total Fraud Amount: " + totalFraudAmount;
    }
}

public class FraudDetectionSystem {

    public static List<FraudAlert> detectFraud(List<Transaction> transactions) {
        return transactions.stream()
                .filter(t -> t.isFraudulent && t.amount > 10000)
                .collect(Collectors.groupingBy(Transaction::getPolicyNumber)) // Corrected the grouping
                .entrySet().stream()
                .map(entry -> {
                    String policyNumber = entry.getKey();
                    List<Transaction> policyTransactions = entry.getValue();
                    int count = policyTransactions.size();
                    double totalAmount = policyTransactions.stream().mapToDouble(t -> t.amount).sum();

                    if (count > 5 || totalAmount > 50000) {
                        return new FraudAlert(policyNumber, count, totalAmount);
                    } else {
                        return null;
                    }
                })
                .filter(Objects::nonNull) // Remove null entries (non-alerting policies)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Transaction> transactions = Arrays.asList(
                new Transaction(1, "P123", 15000, "2025-01-01", true),
                new Transaction(2, "P124", 20000, "2025-02-01", true),
                new Transaction(3, "P123", 5000, "2025-03-01", true),
                new Transaction(4, "P125", 20000, "2025-04-01", true),
                new Transaction(5, "P123", 25000, "2025-05-01", true),
                new Transaction(6, "P123", 20000, "2025-06-01", true),
                new Transaction(7, "P123", 10000, "2025-07-01", true),
                new Transaction(8, "P123", 30000, "2025-08-01", true),
                new Transaction(9, "P126", 12000, "2025-09-01", true)
        );

        List<FraudAlert> alerts = detectFraud(transactions);
        alerts.forEach(System.out::println);
    }
}
