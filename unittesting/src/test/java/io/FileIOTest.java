package io;

import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertArrayEquals;

/**
 * The FileIOTest serves the unit testing of
 * FileIO operations. Includes a plethora
 * of test cases, challenging the functionality of
 * readFile method. Assertions, exceptions
 * testing etc. are some key features applied within
 * the test methods, provided by JUnit.
 *
 * @author  dkokkotas
 * @version 1.0
 * @since   May 2023
 */
public class FileIOTest {
	
	@Rule
	public ExpectedException thrown = ExpectedException.none(); //initialize it to .none()
	public static String resourcesPath = "src/test/resources/";
	
	private final FileIO fio = new FileIO();
	
	/*
	 * A unit test verifying that the program reads
	 * a file successfully.
	 */
	@Test
	public void test_readFileNormalCase() {
		int[] expectedNumbers = new int[] {
			14, 28, -9, 2, 136, 37, 45, 92, 34
		};
		String validInputFilePath = resourcesPath.concat("data.txt");
		
		assertArrayEquals(expectedNumbers, fio.readFile(validInputFilePath));
	}
	
	/*
	 * A test case for the exceptions caused when
	 * the given file doesn't exist. Testing
	 * the exception is performed with a @Rule.
	 */
	@Test
	public void test_readFile_DoesNotExist_RuleException() throws IllegalArgumentException {
	  thrown.expect(IllegalArgumentException.class);
	  thrown.expectMessage("Input file does not exist");
	  fio.readFile("invalid.txt");
	}
	
	/*
	 * A test case for the exceptions caused when the
	 * given file does not contain any numbers.
	 * Testing the exception is performed with a @Rule.
	 */
	@Test
	public void test_readFile_isEmpty_RuleException() throws IllegalArgumentException {
	  thrown.expect(IllegalArgumentException.class);
	  thrown.expectMessage("Given file is empty");
	  String validInputFilePath = resourcesPath.concat("empty.txt");
	  fio.readFile(validInputFilePath);
	}
	
	/*
	 * A unit test verifying that any non-Integer value
	 * is being ignored and not returned by readFile method.
	 */
	@Test
	public void testReadFileContainsInvalidEntries() {
			int[] expectedNumbers = new int[] {
					2, 43, 99, 24, 39, 16, 13, 47
				};
				String validInputFilePath = resourcesPath.concat("vardata.txt");
				
				assertArrayEquals(expectedNumbers, fio.readFile(validInputFilePath));
	}
}