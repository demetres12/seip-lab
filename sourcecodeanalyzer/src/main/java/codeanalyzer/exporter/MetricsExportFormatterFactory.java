package codeanalyzer.exporter;

/**
 * MetricsExportFormatterFactory serves the representation of the Factory design pattern
 * for the needs of the refactoring process. Essentially, provides an interface for
 * creating objects (i.e. analyzers) and delegates the responsibility of instantiation
 * to its concrete subclasses.
 *
 * @author  dkokkotas
 * @version 1.0
 * @since   June 2023
 */
public class MetricsExportFormatterFactory {

    /**
     * Produces csv, json and null formatters replacing direct object's
     * construction calls.
     *
     * @param outputType The output type that could be either csv, json,
     *                   or invalid (i.e. null).
     * @return A concrete MetricsExportFormatter object.
     */
    public MetricsExportFormatter createExportFormatter(String outputType) {
        if (outputType.equalsIgnoreCase("csv")) {
            return new CSVFormatter();
        } else if (outputType.equalsIgnoreCase("json")) {
           return new JSONFormatter();
        } else {
           return new NullFormatter();
        }
    }
}
