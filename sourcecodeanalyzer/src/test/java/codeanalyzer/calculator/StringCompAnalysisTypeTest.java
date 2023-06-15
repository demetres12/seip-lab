package codeanalyzer.calculator;

import codeanalyzer.reader.FileContentReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StringCompAnalysisTypeTest {
    private AnalysisType analysisType = new StringCompAnalysisType();
    private static String FILEPATH = "src/test/resources/TestClass.java";
    private List<String> EXPECTED_SOURCELIST;
    private FileContentReader fileContentReader = mock(FileContentReader.class);

    public StringCompAnalysisTypeTest() {
        try {
            EXPECTED_SOURCELIST = readTestFileContentIntoList(FILEPATH);
            when(fileContentReader.readFileContentIntoList(FILEPATH)).thenReturn(EXPECTED_SOURCELIST);
            analysisType.setContentReader(fileContentReader);
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void test_Calculate_LOC() throws IOException {
        int expectedLoc = 7;
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
    private List<String> readTestFileContentIntoList(String filepath) throws IOException {
        List<String> sourceCodeLines;
        try (Stream<String> lines = Files.lines(Paths.get(filepath))) {
            sourceCodeLines = lines.collect(Collectors.toList());
        }
        return sourceCodeLines;
    }
}