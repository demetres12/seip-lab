package codeanalyzer.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * LocalFileContentReader reads the content of a provided file, stored locally,
 * and returns its lines either in the form of a String attribute or a List.
 * The embedded methods serve the aforementioned return type differentiation.
 *
 * @author  dkokkotas
 * @version 1.0
 * @since   June 2023
 */
public class LocalFileContentReader implements FileContentReader {

    /**
     * Reads the lines of a given local file and appends them to a String.
     *
     * @param localFilePath The provided path to the source file to be read.
     * @return A String provided with the lines of the local file.
     * @exception IOException When an input/output operation fails or encounters an error.
     */
    @Override
    public String readFileContentIntoString(String localFilePath) {
        StringBuilder sb = new StringBuilder();
        File file = new File(localFilePath);
        // try-with-recourses auto-closes the reader
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");
            }
        } catch (IOException e) { // covers subclass "FileNotFoundException"
            System.err.println("Input/output operation fails or encounters an error.");
            e.printStackTrace();
        }
        return sb.toString();
    }

    /**
     * Reads the lines of a given local file and appends them to a List.
     *
     * @param localFilePath The provided path to the source file to be read.
     * @return lines A List of String type provided with the lines of the local file.
     * @exception IOException When an input/output operation fails or encounters an error.
     */
    @Override
    public List<String> readFileContentIntoList(String localFilePath) {
        List<String> lines = new ArrayList<>();
        File file = new File(localFilePath);
        // try-with-resources auto closes the reader.
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) { // covers subclass "FileNotFoundException"
            System.err.println("Input/output operation fails or encounters an error.");
            e.printStackTrace();
        }
        return lines;
    }
}
