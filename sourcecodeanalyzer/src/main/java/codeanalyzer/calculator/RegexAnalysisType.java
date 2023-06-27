package codeanalyzer.calculator;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * RegexAnalysisType reads the content of a provided file and calculates several
 * metrics utilizing a regex analyzer.
 *
 * @author  dkokkotas
 * @version 1.0
 * @since   June 2023
 */
public class RegexAnalysisType extends AnalysisType {


    // A regex should be a class-level constant.
    private static final String LOC_REGEX = ("((//.*)|(/\\*.*)|(\\*+.*))");
    private static final String NOM_REGEX = (".*(public |protected |private |static )?" +
            "[\\w\\<\\>\\[\\]]+\\s+(\\w+) *\\([^\\)]*\\) *(\\{?|[^;]).*");
    private static final String NOC_REGEX = (".*\\s*class\\s+.*");

    /*
     * Patterns must be declared at class-level, as they need to compile once,
     * and not compiled each time the calculator methods are being called.
     */
    private final Pattern locPattern = Pattern.compile(LOC_REGEX);
    private final Pattern nomPattern = Pattern.compile(NOM_REGEX);
    private final Pattern nocPattern = Pattern.compile(NOC_REGEX);

    /**
     * Calculates the lines of code from a given source file.
     *
     * @param filePath The provided path to the source file to be analyzed.
     * @return loc An integer provided with the lines of code.
     * @exception IOException When an input/output operation fails or encounters an error.
     */
    @Override
    public int calculateLOC(String filePath) throws IOException {
        String sourceCode = fileContentReader.readFileContentIntoString(filePath);
        Matcher nonCodeLinesMatcher = locPattern.matcher(sourceCode);

        int nonCodeLinesCounter = 0;
        while (nonCodeLinesMatcher.find()) {
            nonCodeLinesCounter++;
        }

        int sourceFileLength = sourceCode.split("\n").length;
        int loc = sourceFileLength - nonCodeLinesCounter;

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
        String sourceCode = fileContentReader.readFileContentIntoString(filePath);
        Matcher methodSignatures = nomPattern.matcher(sourceCode);

        int methodCounter = 0;
        while (methodSignatures.find()) {
            methodCounter++;
        }
        return methodCounter;
    }

    /**
     * Calculates the number of classes from a given source file.
     *
     * @param filePath The provided path to the source file to be analyzed.
     * @return classCounter An integer provided with the number of classes.
     * @exception IOException When an input/output operation fails or encounters an error.
     */
    @Override
    public int calculateNOC(String filePath) throws IOException {
        String sourceCode = fileContentReader.readFileContentIntoString(filePath);
        Matcher classSignatures = nocPattern.matcher(sourceCode);

        int classCounter = 0;
        while (classSignatures.find()) {
            classCounter++;
        }
        return classCounter;
    }
}
