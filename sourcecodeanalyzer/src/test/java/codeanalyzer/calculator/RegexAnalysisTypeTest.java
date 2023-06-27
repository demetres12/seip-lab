package codeanalyzer.calculator;

import codeanalyzer.reader.FileContentReader;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RegexAnalysisTypeTest {

    private AnalysisType analysisType = new RegexAnalysisType();
    private static String FILEPATH = "src/test/resources/TestClass.java";
    private String EXPECTED_SOURCESTRING;
    private FileContentReader fileContentReader = mock(FileContentReader.class);

    public RegexAnalysisTypeTest() {
        try {
            EXPECTED_SOURCESTRING = readTestFileContentIntoString(FILEPATH);
            when(fileContentReader.readFileContentIntoString(FILEPATH)).thenReturn(EXPECTED_SOURCESTRING);
            analysisType.setContentReader(fileContentReader);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void test_Calculate_LOC() throws IOException {
        int expectedLoc = 21;
        int actualLoc = analysisType.calculateLOC(FILEPATH);
        assertEquals(expectedLoc, actualLoc);
    }

    @Test
    public void test_Calculate_NOM() throws IOException {
        int expectedNom = 3;
        int actualNom = analysisType.calculateNOM(FILEPATH);
        assertEquals(expectedNom, actualNom);
    }

    @Test
    public void test_Calculate_NOC() throws IOException {
        int expectedNoc = 3;
        int actualNoc = analysisType.calculateNOC(FILEPATH);
        assertEquals(expectedNoc, actualNoc);
    }

    // For greater test-case independence you can give a manually created list of Strings
    private String readTestFileContentIntoString(String filepath) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (Stream<String> stream = Files.lines( Paths.get(filepath), StandardCharsets.UTF_8))
        {
            stream.forEach(s -> sb.append(s).append("\n"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return sb.toString();
    }
}