package math;

/**
 * The MyMath class provides an implementation of a
 * simple factorial algorithm. For this purpose
 * factorial method serves the functionality of
 * the program.
 *
 * @author  dkokkotas
 * @version 1.0
 * @since   May 2023
 */
public class MyMath {
	
	/**
	 * Performs the basic factorial algorithm.
	 * @param n The provided value, upon wich we will calculate the factorial
	 * @return fact The result of the factorial algorithm for the provided input
	 * @exception IllegalArgumentException When n is less than 0 or greater than 12 
	 */
	public static int factorial(int n) {
		if (n < 0 || n > 12) {
			throw new IllegalArgumentException("Invalid value provided. Input should be within the range [0,12]");
		} else {
			int fact = 1;
		    for (int i = 2; i <= n; i++) {
		        fact = fact * i;
		    }
		    return fact;
		}
	}
}