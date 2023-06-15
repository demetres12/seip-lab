package codeanalyzer.exporter;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class MetricsExportFormatterFactoryTest {
    private final MetricsExportFormatterFactory meff = new MetricsExportFormatterFactory();

    @Test
    public void test_Create_CSV_Exporter() {
        MetricsExportFormatter exporter = meff.createExportFormatter("csv");
        assertTrue(exporter instanceof CSVFormatter);
    }

    @Test
    public void test_Create_JSON_Exporter() {
        MetricsExportFormatter exporter = meff.createExportFormatter("json");
        assertTrue(exporter instanceof JSONFormatter);
    }

    @Test
    public void test_Create_NULL_Exporter() {
        MetricsExportFormatter exporter  = meff.createExportFormatter("xml");
        assertTrue(exporter instanceof NullFormatter);
    }
}