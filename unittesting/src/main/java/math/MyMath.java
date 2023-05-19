package math;

/**
 * The MyMath class provides an implementation of
 * simple factorial and primality algorithms. For
 * that purpose factorial and isPrime methods serve
 * the functionality of the program.
 *
 * @author  dkokkotas
 * @version 1.0
 * @since   May 2023
 */
public class MyMath {
	
	/**
	 * Performs the basic factorial algorithm.
	 * @param n The provided value, upon which we will calculate the factorial
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
	/**
	 * Checks whether a given int value is either a prime number or a composite
	 * @param n The provided value, upon which we will check it's primality
	 * @return {@code true} if the number is prime, {@code false} otherwise
	 * @exception IllegalArgumentException When n is less than 2 
	 */
	public boolean isPrime(int n) {
		if (n < 2) {
			throw new IllegalArgumentException("Invalid value provided. Input should be greater than 1");
		} else {
			for (int i = 2; i < n; i++) {
				if (n % i == 0) {
					return false;
				}
			}
			return true; // divisible only by 1 and itself
		}
	}
}