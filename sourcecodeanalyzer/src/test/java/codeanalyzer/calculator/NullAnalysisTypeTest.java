package codeanalyzer.calculator;

import java.io.IOException;

import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class NullAnalysisTypeTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none(); //initialize it to .none()
    private final AnalysisType analysisType = new NullAnalysisType();

    @Test
    public void test_Calculate_LOC() throws IOException {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Error in LOC calculation, due to Invalid provided analysis type.");
        analysisType.calculateLOC("path");
    }

    @Test
    public void test_Calculate_NOM() throws IOException {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Error in NOM calculation, due to Invalid provided analysis type.");
        analysisType.calculateNOM("path");
    }

    @Test
    public void test_Calculate_NOC() throws IOException {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Error in NOC calculation, due to Invalid provided analysis type.");
        analysisType.calculateNOC("path");
    }
}