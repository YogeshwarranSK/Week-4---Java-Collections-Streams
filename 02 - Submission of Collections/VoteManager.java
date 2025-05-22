package Day18;
import java.util.*;

public class VoteManager {
    static class VotingManager {
        HashMap<String, Integer> voteCount = new HashMap<>();
        LinkedHashMap<String, Integer> voteOrder = new LinkedHashMap<>();
        public void castVote(String candidate) {
            voteCount.put(candidate, voteCount.getOrDefault(candidate, 0) + 1);
            voteOrder.put(candidate, voteOrder.getOrDefault(candidate, 0) + 1);
        }
        public void displayVoteOrder() {
            System.out.println("Vote Order (LinkedHashMap):");
            for (Map.Entry<String, Integer> entry : voteOrder.entrySet()) {
                System.out.println(entry.getKey() + " -> " + entry.getValue());
            }
        }
        public void displayVoteCountSorted() {
            TreeMap<String, Integer> sortedVotes = new TreeMap<>(voteCount);
            System.out.println("Vote Count Sorted (TreeMap):");
            for (Map.Entry<String, Integer> entry : sortedVotes.entrySet()) {
                System.out.println(entry.getKey() + " -> " + entry.getValue());
            }
        }
    }
    public static void main(String[] args) {
        VotingManager vm = new VotingManager();
        vm.castVote("BHaskar");
        vm.castVote("Raja");
        vm.castVote("Raja");
        vm.castVote("Lucky");
        vm.castVote("Vamsi");
        vm.displayVoteOrder();
        System.out.println();
        vm.displayVoteCountSorted();
    }
}