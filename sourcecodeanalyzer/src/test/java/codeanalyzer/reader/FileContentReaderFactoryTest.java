package codeanalyzer.reader;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class FileContentReaderFactoryTest {

    private final FileContentReaderFactory factory = new FileContentReaderFactory();

    @Test
    public void test_Create_Local_File_Reader() {
        FileContentReader fcr = factory.createFileContentReader("local");
        assertTrue(fcr instanceof LocalFileContentReader);
    }

    @Test
    public void test_Create_Web_File_Reader() {
        FileContentReader fcr = factory.createFileContentReader("web");
        assertTrue(fcr instanceof WebFileContentReader);
    }

    @Test
    public void test_Create_Null_File_Reader() {
        FileContentReader fcr = factory.createFileContentReader("invalid");
        assertTrue(fcr instanceof NullFileContentReader);
    }
}