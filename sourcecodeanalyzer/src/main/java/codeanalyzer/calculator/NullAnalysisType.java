package codeanalyzer.calculator;

import java.io.IOException;

/**
 * NullAnalysisTypes considers cases the user provides an invalid
 * analysis type, causing the code analysis process to
 * fail and terminate.
 *
 * @author  dkokkotas
 * @version 1.0
 * @since   June 2023
 */
public class NullAnalysisType extends AnalysisType {

    /**
     * Causes a process disruption by throwing an exception, when the
     * given analysis type, that calculates lines of code, is invalid.
     *
     * @param filePath The provided path tho the source file to be analyzed.
     * @exception IllegalArgumentException When the given analysis type is
     * neither 'regex' nor 'string comparison'.
     */
    @Override
    public int calculateLOC(String filePath) throws IOException {
        throw new IllegalArgumentException("Error in LOC calculation, due to Invalid provided analysis type.");
    }

    /**
     * Causes a process disruption by throwing an exception, when the
     * given analysis type, that calculates number of methods, is invalid.
     *
     * @param filePath The provided path tho the source file to be analyzed.
     * @exception IllegalArgumentException When the given analysis type is
     * neither 'regex' nor 'string comparison'.
     */
    @Override
    public int calculateNOM(String filePath) {
        throw new IllegalArgumentException("Error in NOM calculation, due to Invalid provided analysis type.");
    }

    /**
     * Causes a process disruption by throwing an exception, when the
     * given analysis type, that calculates number of classes, is invalid.
     *
     * @param filePath The provided path tho the source file to be analyzed.
     * @exception IllegalArgumentException When the given analysis type is
     * neither 'regex' nor 'string comparison'.
     */
    @Override
    public int calculateNOC(String filePath) {
        throw new IllegalArgumentException("Error in NOC calculation, due to Invalid provided analysis type.");
    }

}
