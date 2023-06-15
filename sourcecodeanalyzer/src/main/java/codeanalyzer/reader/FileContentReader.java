package codeanalyzer.reader;

import java.util.List;

/**
 * FileContentReader interface embodies the methods that will
 * be overridden and utilized by the different source types of readers.
 * Both included methods serve the content reading of a given file
 * and differentiate in terms of their return types.
 *
 * @author  dkokkotas
 * @version 1.0
 * @since   June 2023
 */
public interface FileContentReader {
    public String readFileContentIntoString(String filePath);
    public List<String> readFileContentIntoList(String filePath);
}
