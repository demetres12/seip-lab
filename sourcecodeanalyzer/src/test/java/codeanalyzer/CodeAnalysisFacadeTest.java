package codeanalyzer;

import codeanalyzer.calculator.AnalysisType;
import codeanalyzer.calculator.AnalysisTypeFactory;
import codeanalyzer.exporter.MetricsExportFormatter;
import codeanalyzer.exporter.MetricsExportFormatterFactory;
import codeanalyzer.reader.FileContentReader;
import codeanalyzer.reader.FileContentReaderFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

public class CodeAnalysisFacadeTest {

    private final static String TEST_CLASS_LOCAL = "src/test/resources/TestClass.java";
    private final static String FILE_LOCATION_TYPE = "local";
    private final static String ANALYSIS_TYPE = "regex";
    private final static String OUTPUT_FILE = "output_results";
    private final static String EXPORT_TYPE = "csv";

    @Test
    public void test_Perform_FileAnalysis_WithMocks() throws IOException {
        MetricsExportFormatter mef = mock(MetricsExportFormatter.class);
        FileContentReader fcr = mock(FileContentReader.class);
        AnalysisType at = mock(AnalysisType.class);

        when(fcr.readFileContentIntoString(TEST_CLASS_LOCAL)).thenReturn(new String());

        when(at.calculateLOC(TEST_CLASS_LOCAL)).thenReturn(21);
        when(at.calculateNOM(TEST_CLASS_LOCAL)).thenReturn(3);
        when(at.calculateNOC(TEST_CLASS_LOCAL)).thenReturn(3);

        MetricsExportFormatterFactory meff = mock(MetricsExportFormatterFactory.class);
        FileContentReaderFactory fcrf = mock(FileContentReaderFactory.class);
        AnalysisTypeFactory atf = mock(AnalysisTypeFactory.class);

        when(meff.createExportFormatter(EXPORT_TYPE)).thenReturn(mef);
        when(fcrf.createFileContentReader(FILE_LOCATION_TYPE)).thenReturn(fcr);
        when(atf.createAnalysisType(ANALYSIS_TYPE)).thenReturn(at);

        CodeAnalysisFacade codeAnalysisFacade = new CodeAnalysisFacade(fcrf, atf, meff);
        codeAnalysisFacade.conductFileAnalysis(
                TEST_CLASS_LOCAL,
                ANALYSIS_TYPE,
                FILE_LOCATION_TYPE,
                OUTPUT_FILE,
                EXPORT_TYPE);

        // verify that all operations (methods) in the flow of performFileAnalysis are executed (called)
        verify(fcrf).createFileContentReader(FILE_LOCATION_TYPE);
        verify(meff).createExportFormatter(EXPORT_TYPE);
        verify(atf).createAnalysisType(ANALYSIS_TYPE);

        verify(at).setContentReader(fcr);

        verify(at).calculateLOC(TEST_CLASS_LOCAL);
        verify(at).calculateNOM(TEST_CLASS_LOCAL);
        verify(at).calculateNOC(TEST_CLASS_LOCAL);

        Map<String,Integer> metrics = new HashMap<>();
        metrics.put("loc", 21);
        metrics.put("nom", 3);
        metrics.put("noc", 3);

        verify(mef).writeMetrics(metrics, OUTPUT_FILE);
    }

    /*
     * The following test case behaves more like an integration test of the systems' modules than like
     * an independent unit-test of a fine-grained specific functionality since dependencies are not
     * mocked and thus, their behavior cannot be defined.
     */
    @Test
    public void test_Perform_FileAnalysis_Without_Injecting_Dependencies() throws IOException {
        File outputFile = new File(OUTPUT_FILE + ".csv");
        if(outputFile.exists())
            outputFile.delete();

        CodeAnalysisFacade codeAnalyzer = new CodeAnalysisFacade();
        try {
            codeAnalyzer.conductFileAnalysis(
                    TEST_CLASS_LOCAL,
                    ANALYSIS_TYPE,
                    FILE_LOCATION_TYPE,
                    OUTPUT_FILE,
                    EXPORT_TYPE);

            assertTrue(outputFile.exists());

            String[] expectedContent = {"loc,noc,nom,", "21,3,3,"};
            String[] actualContent = readTestFileContentIntoList(outputFile.getAbsolutePath());

            assertArrayEquals(expectedContent, actualContent);

        } finally {
            outputFile.delete();
        }
    }

    // For greater test-case independence you can give a manually created list of Strings
    private String[] readTestFileContentIntoList(String filepath) throws IOException {
        List<String> sourceCodeLines;
        try (Stream<String> lines = Files.lines(Paths.get(filepath))) {
            sourceCodeLines = lines.collect(Collectors.toList());
        }
        return sourceCodeLines.stream().toArray(String[]::new);
    }
}