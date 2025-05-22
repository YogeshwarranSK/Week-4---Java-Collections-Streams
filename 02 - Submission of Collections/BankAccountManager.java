package Day18;
import java.util.*;
public class BankAccountManager {
    static class BankAccount {
        String accountNumber;
        double balance;
        public BankAccount(String accountNumber, double balance) {
            this.accountNumber = accountNumber;
            this.balance = balance;
        }
    }
    static class BankingSystemManager {
        HashMap<String, BankAccount> accounts = new HashMap<>();
        TreeMap<Double, List<String>> sortedAccounts = new TreeMap<>();
        Queue<Map.Entry<String, Double>> withdrawalRequests = new
                LinkedList<>();
        public void addAccount(String accountNumber, double balance) {
            BankAccount account = new BankAccount(accountNumber, balance);
            accounts.put(accountNumber, account);
            sortedAccounts.putIfAbsent(balance, new ArrayList<>());
            sortedAccounts.get(balance).add(accountNumber);
        }
        public void requestWithdrawal(String accountNumber, double amount) {
            if (!accounts.containsKey(accountNumber)) {
                System.out.println("Account not found.");
                return;
            }
            withdrawalRequests.add(new AbstractMap.SimpleEntry<>(accountNumber,
                    amount));
        }
        public void processWithdrawals() {
            while (!withdrawalRequests.isEmpty()) {
                Map.Entry<String, Double> request = withdrawalRequests.poll();
                String accountNumber = request.getKey();
                double amount = request.getValue();
                BankAccount account = accounts.get(accountNumber);
                if (account.balance >= amount) {
                    account.balance -= amount;
                    System.out.println("Withdrawal of $" + amount + " from account " + accountNumber + " successful.");
                }
                else {
                    System.out.println("Insufficient balance in account " + accountNumber + " for withdrawal of $" + amount);
                }
            }
        }
        public void displaySortedAccounts() {
            System.out.println("\nCustomers Sorted by Balance:");
            for (Map.Entry<Double, List<String>> entry :
                    sortedAccounts.entrySet()) {
                System.out.println("Balance: $" + entry.getKey() + " -> Accounts: " + entry.getValue());
            }
        }
        public void displayAllAccounts() {
            System.out.println("\nAll Customer Accounts:");
            for (Map.Entry<String, BankAccount> entry : accounts.entrySet()) {
                BankAccount account = entry.getValue();
                System.out.println("Account: " + account.accountNumber + " - Balance: $" + account.balance);
            }
        }
    }
    public static void main(String[] args) {
        BankingSystemManager manager = new BankingSystemManager();
        manager.addAccount("SBI092387736", 5000.00);
        manager.addAccount("SBI)98237487", 1500.00);
        manager.addAccount("SBI37247364732", 3000.00);
        manager.requestWithdrawal("SBI76812378263", 1000.00);
        manager.requestWithdrawal("SBI8932782187213", 2000.00);
        manager.requestWithdrawal("SBI07318613123", 500.00);
        manager.requestWithdrawal("SBI87315272378213", 6000.00);
        manager.processWithdrawals();
        manager.displayAllAccounts();
        manager.displaySortedAccounts();
    }
}