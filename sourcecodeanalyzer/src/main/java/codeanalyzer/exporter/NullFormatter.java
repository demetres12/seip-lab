package codeanalyzer.exporter;

import java.util.Map;

/**
 * NullFormatter considers cases the user provides an invalid
 * output format type, causing the code analysis process to
 * fail and terminate.
 *
 * @author  dkokkotas
 * @version 1.0
 * @since   June 2023
 */
public class NullFormatter implements MetricsExportFormatter {

    /**
     * Causes a process disruption by throwing an exception, when the
     * given output format is invalid.
     *
     * @param metrics The calculated metrics (LOC, NOM, NOM)
     * @param filePath The provided path to the analyzed source file.
     * @exception IllegalArgumentException When the given output format is
     * invalid.
     */
    @Override
    public void writeMetrics(Map<String, Integer> metrics, String filePath) {
        throw new IllegalArgumentException("Exporting metrics process disrupted, as requested output format is invalid.");
    }
}
