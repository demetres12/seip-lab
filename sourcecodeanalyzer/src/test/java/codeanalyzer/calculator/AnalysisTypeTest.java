package codeanalyzer.calculator;

import codeanalyzer.reader.FileContentReader;
import codeanalyzer.reader.LocalFileContentReader;

import org.junit.Test;

import static org.junit.Assert.assertSame;

public class AnalysisTypeTest {

    @Test
    public void testSetContentReader() {
        AnalysisType analysisType = new StringCompAnalysisType(); // any analyzer can be used
         FileContentReader expectedReader = new LocalFileContentReader(); // any reader can be used

        analysisType.setContentReader(expectedReader);
        FileContentReader actualReader = analysisType.getContentReader();

        assertSame(expectedReader, actualReader);
    }
}