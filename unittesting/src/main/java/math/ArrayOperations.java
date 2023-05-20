package math;

import io.FileIO;

import java.util.ArrayList;
import java.util.List;

/**
 * The ArrayOperations class serves the identification
 * of prime numbers from a given txt file, containing
 * several data values. 
 *
 * @author  dkokkotas
 * @version 1.0
 * @since   May 2023 
 */
public class ArrayOperations {
	
	/**
	 * Performs the identification of prime numbers algorithm.
	 * Interacts with the MyMath class of math package as well
	 * the FileIO class under the io package, in order to be
	 * functional.
	 * 
	 * @param fileIo Object of FileIO class
	 * @param filepath String argument that holds the file path
	 * @param myMath Object of MyMath class
	 * 
	 * @return int[] An Integer array containing the prime numbers
	 */
	int[] findPrimesInFile(FileIO fileIo, String filepath, MyMath myMath) {
		List<Integer> primeNumbersList = new ArrayList<>();
		int[] numbers = fileIo.readFile(filepath);
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] < 2) {
				continue; // otherwise isPrime throws exception
			}	
			if (myMath.isPrime(numbers[i])) {
				primeNumbersList.add(numbers[i]);
			}
		}
		return primeNumbersList.stream().mapToInt(i -> i).toArray();
	}
}