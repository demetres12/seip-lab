package codeanalyzer.calculator;

/**
 * AnalysisTypeFactory serves the representation of the Factory design pattern
 * for the needs of the refactoring process. Essentially, provides an interface for
 * creating objects (i.e. analyzers) and delegates the responsibility of instantiation
 * to its concrete subclasses.
 *
 * @author  dkokkotas
 * @version 1.0
 * @since   June 2023
 */
public class AnalysisTypeFactory {

    /**
     * Produces regex, string comparison and null analyzers replacing direct object's
     * construction calls.
     *
     * @param analysisType The analysis type that could be either regex, string comparison,
     *                   or invalid (i.e. null).
     * @return A concrete AnalysisType object.
     */
    public AnalysisType createAnalysisType(String analysisType) {
        if (analysisType.equalsIgnoreCase("regex")) {
            return new RegexAnalysisType();
        } else if (analysisType.equalsIgnoreCase("strcomp")) {
            return new StringCompAnalysisType();
        } else {
            return new NullAnalysisType();
        }
    }
}
