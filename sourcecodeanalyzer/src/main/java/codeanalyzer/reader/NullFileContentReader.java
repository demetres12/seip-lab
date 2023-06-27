package codeanalyzer.reader;

import java.util.List;

/**
 * NullFileContentReader considers cases the user provides an invalid
 * location source type, causing the code analysis process to
 * fail and terminate.
 *
 * @author  dkokkotas
 * @version 1.0
 * @since   June 2023
 */
public class NullFileContentReader implements FileContentReader{

    /**
     * Causes a process disruption by throwing an exception, when the
     * given source type, to be read and returned into a String, is invalid.
     *
     * @param filePath The provided path tho the source file to be analyzed.
     * @exception IllegalArgumentException When the given source type is
     * neither 'web' nor 'local'.
     */
    @Override
    public String readFileContentIntoString(String filePath) throws IllegalArgumentException {
        throw new IllegalArgumentException("Source code analysis process was aborted, as the provided source type is invalid.");
    }

    /**
     * Causes a process disruption by throwing an exception, when the
     * given source type, to be read and returned into a List, is invalid.
     *
     * @param filePath The provided path to the source file to be analyzed.
     * @exception IllegalArgumentException When the given source type is
     * neither 'web' nor 'local'.
     */
    @Override
    public List<String> readFileContentIntoList(String filePath) {
        throw new IllegalArgumentException("Source code analysis process was aborted, as the provided source type is invalid.");
    }
}
