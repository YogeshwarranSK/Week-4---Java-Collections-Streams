package Day21.JUnit;

import Day21.JUnit.Test.DatabaseConnection;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseConnectionTest {

    private DatabaseConnection db;

    @BeforeEach
    void setUp() {
        db = new DatabaseConnection();
        db.connect();
    }

    @AfterEach
    void tearDown() {
        db.disconnect();
    }

    @Test
    void testConnectionIsEstablished() {
        assertTrue(db.isConnected(), "Database should be connected after setUp");
    }

    @Test
    void testConnectionIsDisconnectedAfterEachTest() {
        assertTrue(db.isConnected(), "Connection should be active during the test");
    }
}
