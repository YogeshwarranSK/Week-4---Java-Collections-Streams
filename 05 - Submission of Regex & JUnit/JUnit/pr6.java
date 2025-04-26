package Day21.JUnit;

import Day21.JUnit.Test.NumberUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class NumberUtilsTest {

    private final NumberUtils numberUtils = new NumberUtils();

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6})
    void testIsEvenWithEvenNumbers(int number) {
        assertTrue(numberUtils.isEven(number), number + " should be even");
    }

    @ParameterizedTest
    @ValueSource(ints = {7, 9, 11})
    void testIsEvenWithOddNumbers(int number) {
        assertFalse(numberUtils.isEven(number), number + " should be odd");
    }
}
