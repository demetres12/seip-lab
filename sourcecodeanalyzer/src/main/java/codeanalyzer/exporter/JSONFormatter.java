package codeanalyzer.exporter;

import java.util.Map;

/**
 * JSONFormatter export the calculated metrics, writing them to a JSON format file
 *
 * @author  dkokkotas
 * @version 1.0
 * @since   June 2023
 */
public class JSONFormatter implements MetricsExportFormatter {

    /**
     * Causes a process disruption by throwing an exception, when the
     * given output format is JSON (not supported yet).
     *
     * @param metrics The calculated metrics (LOC, NOM, NOM)
     * @param filePath The provided path to the analyzed source file.
     * @exception IllegalArgumentException When the given output format is
     * JSON.
     */
    @Override
    public void writeMetrics(Map<String, Integer> metrics, String filePath) {
        throw new IllegalArgumentException("JSON output format not supported yet.");
    }
}
