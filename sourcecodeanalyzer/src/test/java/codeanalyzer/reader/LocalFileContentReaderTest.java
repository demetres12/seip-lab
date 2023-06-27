package codeanalyzer.reader;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class LocalFileContentReaderTest {

    private static List<String> expectedList;
    private static String expectedString;
    private final static String TEST_CLASS_LOCAL = "src/test/resources/TestClass.java";

    @BeforeClass
    public static void setUp() throws IOException {
        expectedList = Files.readAllLines(new File(TEST_CLASS_LOCAL).toPath(), Charset.defaultCharset());
        expectedString = String.join("\n", expectedList) + "\n"; // transforms a list into a String (with 'new line' as delimiter)
    }

    private final FileContentReader fcr = new LocalFileContentReader();

    @Test
    public void test_Read_File_For_Regex() throws IOException {
        //read a locally stored file into a String
        String actual = fcr.readFileContentIntoString(TEST_CLASS_LOCAL);
        assertEquals(expectedString, actual);
    }

    @Test
    public void test_Read_File_For_StrComp() throws IOException {
        List<String> actualList = fcr.readFileContentIntoList(TEST_CLASS_LOCAL);

        String[] expected = expectedList.stream().toArray(String[]::new);
        String[] actual = actualList.stream().toArray(String[]::new);

        assertArrayEquals(expected, actual);
    }
}