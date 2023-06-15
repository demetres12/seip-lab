package codeanalyzer.exporter;

import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class NullFormatterTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none(); //initialize it to .none()
    private final MetricsExportFormatter nullFormatter = new NullFormatter();

    @Test
    public void test_ExportFormatNull() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Exporting metrics process disrupted, as requested output format is invalid.");
        nullFormatter.writeMetrics(null,"");
    }
}