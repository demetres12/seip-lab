package codeanalyzer.reader;

import java.io.IOException;

import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class NullFileContentReaderTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none(); //initialize it to .none()
    private final FileContentReader fcr = new NullFileContentReader();

    @Test
    public void test_Read_File_For_Regex() throws IOException {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Source code analysis process was aborted, as the provided source type is invalid.");
        fcr.readFileContentIntoString("any-filepath");
    }

    @Test
    public void test_Read_File_For_StrComp() throws IOException {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Source code analysis process was aborted, as the provided source type is invalid.");
        fcr.readFileContentIntoList("any-filepath");
    }
}