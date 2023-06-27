package codeanalyzer.exporter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * CSVFormatter export the calculated metrics, writing them to a CSV format file
 *
 * @author  dkokkotas
 * @version 1.0
 * @since   June 2023
 */
public class CSVFormatter implements MetricsExportFormatter {

    /**
     * Accepts the calculated metrics and the source file path and write the
     * metrics to a CSV format file.
     *
     * @param metrics The calculated metrics (LOC, NOM, NOM)
     * @param filePath The provided path to the analyzed source file.
     */
    @Override
    public void writeMetrics(Map<String, Integer> metrics, String filePath) {
        File outputFile = new File(filePath + ".csv");
        StringBuilder metricsNames = new StringBuilder();
        StringBuilder metricsValues = new StringBuilder();

        for (Map.Entry<String, Integer> entry : metrics.entrySet()) {
            metricsNames.append(entry.getKey() + ",");
            metricsValues.append(entry.getValue()+",");
        }

        try {
            FileWriter writer = new FileWriter(outputFile);
            writer.append(metricsNames + "\n");
            writer.append(metricsValues + "\n");
            writer.close();
            System.out.println("Metrics saved in " + outputFile.getAbsolutePath());
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}
