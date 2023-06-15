package codeanalyzer.calculator;

import java.io.IOException;
import java.util.List;

/**
 * StringCompAnalysisType reads the content of a provided file and calculates several
 * metrics utilizing a strin comparison analyzer.
 *
 * @author  dkokkotas
 * @version 1.0
 * @since   June 2023
 */
public class StringCompAnalysisType extends AnalysisType {

    /**
     * Calculates the lines of code from a given source file.
     *
     * @param filePath The provided path to the source file to be analyzed.
     * @return loc An integer provided with the lines of code.
     * @exception IOException When an input/output operation fails or encounters an error.
     */
    @Override
    public int calculateLOC(String filePath) throws IOException {
        List<String> sourceCodeList = fileContentReader.readFileContentIntoList(filePath);
        int nonCodeLinesCounter = 0;
        for (String line : sourceCodeList) {
            line = line.trim(); //clear all leading and trailing white spaces
            if (line.startsWith("//") || line.startsWith("/*") || line.startsWith("*")
                    || line.equals("{") || line.equals("}") || line.equals(""))
                nonCodeLinesCounter++;
        }
        int loc = sourceCodeList.size() - nonCodeLinesCounter;
        return loc;
    }

    /**
     * Calculates the number of methods from a given source file.
     *
     * @param filePath The provided path to the source file to be analyzed.
     * @return methodCounter An integer provided with the number of methods.
     * @exception IOException When an input/output operation fails or encounters an error.
     */
    @Override
    public int calculateNOM(String filePath) throws IOException {
        List<String> sourceCodeList = fileContentReader.readFileContentIntoList(filePath);
        int methodCounter = 0;
        for (String line : sourceCodeList) {
            line = line.trim(); //clear all leading and trailing white spaces
            if ( ((line.contains("public") || line.contains("private") || line.contains("protected"))
                    || line.contains("void") || line.contains("int") || line.contains("String"))
                    && line.contains("(") && line.contains(")") && line.contains("{") )
                methodCounter++;
        }
        return methodCounter;
    }

    /**
     * Calculates the number of classes from a given source file.
     *
     * @param filePath The provided path to the source file to be analyzed.
     * @return noc An integer provided with the number of classes.
     * @exception IOException When an input/output operation fails or encounters an error.
     */
    @Override
    public int calculateNOC(String filePath) throws IOException {
        List<String> sourceCodeList = fileContentReader.readFileContentIntoList(filePath);
        int classCounter = 0;
        for (String line : sourceCodeList) {
            line = line.trim(); //remove leading and trailing white spaces
            if ((line.startsWith("class ") || line.contains(" class ")) && line.contains("{")) {
                classCounter++;
            }
        }
        return classCounter;
    }
}
