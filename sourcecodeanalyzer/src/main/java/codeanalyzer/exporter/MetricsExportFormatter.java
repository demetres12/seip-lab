package codeanalyzer.exporter;

import java.util.Map;

/**
 * MetricsExportFormatter interface embodies the method(s) that will
 * be overridden and utilized by the different source types of exporters
 * (i.e. output formats).
 *
 * @author  dkokkotas
 * @version 1.0
 * @since   June 2023
 */
public interface MetricsExportFormatter {
    void writeMetrics(Map<String, Integer> metrics, String filePath);
}
