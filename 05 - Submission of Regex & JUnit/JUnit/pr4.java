package Day21.JUnit;

import Day21.JUnit.Test.MathOperations;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathOperationsTest {

    @Test
    void testDivideValid() {
        MathOperations mathOps = new MathOperations();
        assertEquals(2, mathOps.divide(6, 3));
    }

    @Test
    void testDivideByZeroThrowsException() {
        MathOperations mathOps = new MathOperations();
        assertThrows(ArithmeticException.class, () -> mathOps.divide(10, 0),
                "Expected divide() to throw ArithmeticException when dividing by zero");
    }
}
