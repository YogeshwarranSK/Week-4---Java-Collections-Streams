package Day21.JUnit;

import Day21.JUnit.Test.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void testAddition() {
        assertEquals(8, calculator.add(5, 3), "Addition should work correctly");
    }

    @Test
    void testSubtraction() {
        assertEquals(2, calculator.subtract(5, 3), "Subtraction should work correctly");
    }

    @Test
    void testMultiplication() {
        assertEquals(15, calculator.multiply(5, 3), "Multiplication should work correctly");
    }

    @Test
    void testDivision() {
        assertEquals(2, calculator.divide(6, 3), "Division should work correctly");
    }

    @Test
    void testDivisionByZero() {
        assertThrows(ArithmeticException.class, () -> calculator.divide(6, 0),
                "Division by zero should throw ArithmeticException");
    }
}
