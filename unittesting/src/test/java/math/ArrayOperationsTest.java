package math;

import io.FileIO;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * The ArrayOperationsTest serves the unit testing of
 * ArrayOperations' functionality. Includes a plethora
 * of test cases, challenging the functionality of
 * findPrimesInFile method. Assertions, exceptions
 * testing etc. are some key features applied within
 * the test methods, provided by JUnit. Mockito framework
 * is used to mock the dependency with MyMath and FileIO
 * classes.
 *
 * @author  dkokkotas
 * @version 1.0
 * @since   May 2023
 */
public class ArrayOperationsTest {
	
	private final ArrayOperations aot = new ArrayOperations();
	
	/*
	 * A unit test verifying that the program reads a file
	 * with numbers successfully and returns only the prime values
	 */
	@Test
	public void test_getPrimes_Mocking() {
		String filepath = "vardata.txt";
		int[] expectedNumbers = new int[] {
				2,43,99,24,39,16,13,47
		};
		
		// Mock the FileIO dependency
		FileIO fio = mock(FileIO.class);
		when(fio.readFile(filepath)).thenReturn(expectedNumbers);
		
		// Mock the MyMath dependency
		MyMath mm = mock(MyMath.class);
		when(mm.isPrime(2)).thenReturn(true);
		when(mm.isPrime(43)).thenReturn(true);
		when(mm.isPrime(99)).thenReturn(false);
		when(mm.isPrime(24)).thenReturn(false);
		when(mm.isPrime(39)).thenReturn(false);
		when(mm.isPrime(16)).thenReturn(false);
		when(mm.isPrime(13)).thenReturn(true);
		when(mm.isPrime(47)).thenReturn(true);
		
		int[] expectedPrimeNumbers = {2,43,13,47};
		
		assertArrayEquals(expectedPrimeNumbers, aot.findPrimesInFile(fio, filepath, mm));
	}
	
	/*
	 * A test case for the exceptions caused when
	 * argument's value is less than 2.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void test_getPrimes_ArgumentLessThanTwo_Mocking() throws IllegalArgumentException {
		String filepath = "data.txt";
		int[] expectedNumbers = new int[] {
				14,28,-9,2,136,37,45,92,34,89
		};
		
		// Mock the FileIO dependency
		FileIO fio = mock(FileIO.class);
		when(fio.readFile(filepath)).thenReturn(expectedNumbers);
		
		// Mock the MyMath dependency
		MyMath mm = mock(MyMath.class);
		when(mm.isPrime(16)).thenReturn(false);
		when(mm.isPrime(28)).thenReturn(false);
		when(mm.isPrime(-9)).thenThrow(IllegalArgumentException.class);
		// No need to define further behavior as the exception will be thrown
		
		aot.findPrimesInFile(fio, filepath, mm);
	}
}