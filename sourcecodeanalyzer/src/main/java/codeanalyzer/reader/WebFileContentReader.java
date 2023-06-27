package codeanalyzer.reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * WebFileContentReader reads the content of a provided web file and returns it's
 * lines either by a String attribute or by a List. The embedded methods
 * serve the aforementioned return type differentiation.
 *
 * @author  dkokkotas
 * @version 1.0
 * @since   June 2023
 */
public class WebFileContentReader implements FileContentReader {

    /**
     * Reads the lines of a given web file and appends them to a String.
     *
     * @param urlFilePath The provided path to the source file to be read.
     * @return A String provided with the lines of the web file.
     * @exception IOException When an input/output operation fails or encounters an error.
     */
    @Override
    public String readFileContentIntoString(String urlFilePath) {
        StringBuilder sb = new StringBuilder();
        // try-with-resources auto-closes the reader
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new URL(urlFilePath).openStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");
            }
        } catch (IOException e) {
            System.err.println("Input/output operation fails or encounters an error.");
            e.printStackTrace();
        }
        return sb.toString();
    }

    /**
     * Reads the lines of a given web file and appends them to a List.
     *
     * @param urlFilePath The provided path to the source file to be read.
     * @return lines A List of String type provided with the lines of the web file.
     * @exception IOException When an input/output operation fails or encounters an error.
     */
    @Override
    public List<String> readFileContentIntoList(String urlFilePath) {
        List<String> lines = new ArrayList<>();
        // try-with-resources auto-closes the reader
        try (BufferedReader reader = new BufferedReader(
            new InputStreamReader(new URL(urlFilePath).openStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    lines.add(line);
                }
        } catch (IOException e) {
            System.err.println("Input/output operation fails or encounters an error.");
            e.printStackTrace();
        }
        return lines;
    }
}
