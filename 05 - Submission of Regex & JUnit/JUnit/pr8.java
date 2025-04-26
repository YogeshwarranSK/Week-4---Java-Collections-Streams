package Day21.JUnit;

import Day21.JUnit.Test.FileProcessor;
import org.junit.jupiter.api.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class FileProcessorTest {

    private static final String TEST_FILE = "testfile.txt";
    private FileProcessor fileProcessor;

    @BeforeEach
    void setUp() {
        fileProcessor = new FileProcessor();
    }

    @AfterEach
    void tearDown() throws IOException {
        Files.deleteIfExists(Paths.get(TEST_FILE));
    }

    @Test
    void testWriteAndReadFile() throws IOException {
        String content = "Hello, world!";
        fileProcessor.writeToFile(TEST_FILE, content);

        String readContent = fileProcessor.readFromFile(TEST_FILE);
        assertEquals(content, readContent, "The content read should match the written content.");
    }

    @Test
    void testFileExistsAfterWrite() throws IOException {
        String content = "Sample content";
        fileProcessor.writeToFile(TEST_FILE, content);

        assertTrue(Files.exists(Paths.get(TEST_FILE)), "The file should exist after writing.");
    }

    @Test
    void testIOExceptionWhenFileDoesNotExist() {
        String nonExistentFile = "non_existent_file.txt";
        assertThrows(IOException.class, () -> fileProcessor.readFromFile(nonExistentFile),
                "Reading a non-existent file should throw IOException.");
    }
}
