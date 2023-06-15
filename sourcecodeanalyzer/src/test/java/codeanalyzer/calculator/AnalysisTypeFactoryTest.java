package codeanalyzer.calculator;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class AnalysisTypeFactoryTest {
    private final AnalysisTypeFactory factory = new AnalysisTypeFactory();

    @Test
    public void test_Create_Regex_SourceCode_Analyzer() {
        AnalysisType analysisType = factory.createAnalysisType("regex");
        assertTrue(analysisType instanceof RegexAnalysisType);
    }

    @Test
    public void test_Create_StrComp_SourceCode_Analyzer() {
        AnalysisType analysisType = factory.createAnalysisType("strcomp");
        assertTrue(analysisType instanceof StringCompAnalysisType);
    }

    @Test
    public void test_Create_Null_SourceCode_Analyzer() {
        AnalysisType analysisType = factory.createAnalysisType("invalid");
        assertTrue(analysisType instanceof NullAnalysisType);
    }
}