package codeanalyzer.calculator;

import java.io.IOException;

import codeanalyzer.reader.FileContentReader;

/**
 * AnalysisType abstract class:
 * 1. Embodies the calculation methods that will be overridden and utilized
 * by the different types of analyzers.
 * 2. Serves the representation of the Bridge design pattern for the needs
 * of the refactoring process. Essentially, we create a composition relationship
 * between the AnalysisType and FileContentReader abstractions (e.g., regex analyzer for a web file).
 *
 * By switching from inheritance to the object composition, we are able to hold
 * interchangeable implementations at runtime.
 *
 * @author  dkokkotas
 * @version 1.0
 * @since   June 2023
 */
public abstract class AnalysisType {

    // a reference field corresponding to a reader
    protected FileContentReader fileContentReader;

    // set the reader, which will be analyzed
    public void setContentReader(FileContentReader fileContentReader) {
        this.fileContentReader = fileContentReader;
    }

    public FileContentReader getContentReader() {
        return fileContentReader;
    }

    public abstract int calculateLOC(String filePath) throws IOException;
    public abstract int calculateNOM(String filePath) throws IOException;
    public abstract int calculateNOC(String filePath) throws IOException;
}
