package codeanalyzer.exporter;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class CSVFormatterTest {

    private final MetricsExportFormatter csvFormatter = new CSVFormatter();
    private static String FILEPATH = "generated_results";

    @Test
    public void test_Export_Format_Csv() {

        Map<String, Integer> metrics = new HashMap<>();
        metrics.put("loc",30);
        metrics.put("nom",5);
        metrics.put("noc",2);

        String outputFilepath = "src/test/resources/generated_metrics";
        csvFormatter.writeMetrics(metrics, outputFilepath);

        File outputFile = new File(outputFilepath + ".csv");
        Assert.assertTrue(outputFile.exists());

        // clean resources
        outputFile.delete();
    }
}