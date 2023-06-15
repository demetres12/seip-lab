package codeanalyzer.reader;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class FileContentReaderFactoryTest {

    private final FileContentReaderFactory factory = new FileContentReaderFactory();

    @Test
    public void testCreateLocalFileReader() {
        FileContentReader fcr = factory.createFileContentReader("local");
        assertTrue(fcr instanceof LocalFileContentReader);
    }

    @Test
    public void testCreateWebFileReader() {
        FileContentReader fcr = factory.createFileContentReader("web");
        assertTrue(fcr instanceof WebFileContentReader);
    }

    @Test
    public void testCreateNullFileReader() {
        FileContentReader fcr = factory.createFileContentReader("invalid");
        assertTrue(fcr instanceof NullFileContentReader);
    }
}