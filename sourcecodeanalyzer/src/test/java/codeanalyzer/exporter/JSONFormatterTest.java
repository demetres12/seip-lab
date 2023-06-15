package codeanalyzer.exporter;

import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class JSONFormatterTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none(); //initialize it to .none()
    private final MetricsExportFormatter jsonFormatter = new JSONFormatter();

    @Test
    public void test_Export_Format_JSON() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("JSON output format not supported yet.");
        jsonFormatter.writeMetrics(null,"");
    }
}