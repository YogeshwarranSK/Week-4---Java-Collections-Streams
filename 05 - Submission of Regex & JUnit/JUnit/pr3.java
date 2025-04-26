package Day21.JUnit;

import Day21.JUnit.Test.ListManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListManagerTest {

    private ListManager listManager;
    private List<Integer> testList;

    @BeforeEach
    void setUp() {
        listManager = new ListManager();
        testList = new ArrayList<>();
    }

    @Test
    void testAddElement() {
        listManager.addElement(testList, 10);
        assertTrue(testList.contains(10));
        assertEquals(1, testList.size());
    }

    @Test
    void testRemoveElement() {
        testList.add(20);
        testList.add(30);
        listManager.removeElement(testList, 20);
        assertFalse(testList.contains(20));
        assertEquals(1, testList.size());
    }

    @Test
    void testGetSize() {
        assertEquals(0, listManager.getSize(testList));
        testList.add(5);
        testList.add(10);
        assertEquals(2, listManager.getSize(testList));
    }
}
