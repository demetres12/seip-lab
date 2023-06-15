package codeanalyzer.reader;

/**
 * FileContentReaderFactory serves the representation of the Factory design pattern
 * for the needs of the refactoring process. Essentially, provides an interface for
 * creating objects (i.e. readers) and delegates the responsibility of instantiation
 * to its concrete subclasses.
 *
 * @author  dkokkotas
 * @version 1.0
 * @since   June 2023
 */
public class FileContentReaderFactory {

    /**
     * Produces local, web and null readers, replacing direct object's construction calls.
     *
     * @param sourceType The file source type that could be either local, web,
     *                   or invalid (i.e. null).
     * @return A concrete FileContentReader object.
     */
    public FileContentReader createFileContentReader(String sourceType) {
        if (sourceType.equalsIgnoreCase("local")) {
            return new LocalFileContentReader();
        } else if (sourceType.equalsIgnoreCase("web")) {
            return new WebFileContentReader();
        } else {
            return new NullFileContentReader();
        }
    }
}
