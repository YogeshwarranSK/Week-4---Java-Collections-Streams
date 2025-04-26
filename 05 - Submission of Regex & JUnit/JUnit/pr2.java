package Day21.JUnit;

import Day21.JUnit.Test.StringUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {

    private StringUtil stringUtils;

    @BeforeEach
    void setUp() {
        stringUtils = new StringUtil();
    }

    @Test
    void testReverse() {
        assertEquals("tac", stringUtils.reverse("cat"));
        assertEquals("madam", stringUtils.reverse("madam"));
        assertNull(stringUtils.reverse(null));
    }

    @Test
    void testIsPalindrome() {
        assertTrue(stringUtils.isPalindrome("madam"));
        assertTrue(stringUtils.isPalindrome("RaceCar"));  // case-insensitive check
        assertFalse(stringUtils.isPalindrome("hello"));
        assertFalse(stringUtils.isPalindrome(null));
    }

    @Test
    void testToUpperCase() {
        assertEquals("HELLO", stringUtils.toUpperCase("hello"));
        assertEquals("JAVA", stringUtils.toUpperCase("Java"));
        assertNull(stringUtils.toUpperCase(null));
    }
}

