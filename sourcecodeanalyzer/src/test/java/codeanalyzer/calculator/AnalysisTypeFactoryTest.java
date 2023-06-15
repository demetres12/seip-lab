package codeanalyzer.calculator;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class AnalysisTypeFactoryTest {
    private final AnalysisTypeFactory factory = new AnalysisTypeFactory();

    @Test
    public void testCreateRegexSourceCodeAnalyzer() {
        AnalysisType analysisType = factory.createAnalysisType("regex");
        assertTrue(analysisType instanceof RegexAnalysisType);
    }

    @Test
    public void testCreateStrCompSourceCodeAnalyzer() {
        AnalysisType analysisType = factory.createAnalysisType("strcomp");
        assertTrue(analysisType instanceof StringCompAnalysisType);
    }

    @Test
    public void testCreateNullSourceCodeAnalyzer() {
        AnalysisType analysisType = factory.createAnalysisType("invalid");
        assertTrue(analysisType instanceof NullAnalysisType);
    }
}