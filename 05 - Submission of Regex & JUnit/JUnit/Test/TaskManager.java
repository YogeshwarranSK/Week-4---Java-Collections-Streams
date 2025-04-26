package Day21.JUnit.Test;

public class TaskManager {

    public String longRunningTask() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return "Interrupted";
        }
        return "Completed";
    }
}

