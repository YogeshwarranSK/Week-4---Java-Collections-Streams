package Day21.JUnit;

import Day21.JUnit.Test.TaskManager;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

class TaskManagerTest {

    private final TaskManager taskManager = new TaskManager();

    @Test
    @Timeout(value = 2, unit = TimeUnit.SECONDS)
    void testLongRunningTaskTimeout() {
        taskManager.longRunningTask();
    }
}

