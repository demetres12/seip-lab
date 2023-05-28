package math;

/**
 * The ArithmeticOperations provides simple arithmetic operations
 * of division and multiplication that serve as hands-on
 * practice on Unit Testing.
 *
 * @author  agkortzis, dkokkotas
 * @version 1.0
 * @since   2020-04-06 
 */
public class ArithmeticOperations {
	
	/**
	 * Performs the basic arithmetic operation of division.
	 * Generally, division by a zero denominator throws
	 * an ArithmeticException. However inside divide method
	 * we include another way of handling such cases.
	 * Specifically when both numerator and denominator are
	 * zero values, we return a Nan(Not a Number) value
	 * instead of throwing the exception. We could also take
	 * into consideration the infinity concept of Java, in
	 * case only the denominator is a zero value, but this
	 * could add unwanted complexity to our project.
	 * 
	 * @param numerator the numerator of the operation
	 * @param denominator the denominator of the operation
	 * @return the result of the division between numerator and denominator
	 * @exception ArithmeticException when denominator is zero but numerator is not
	 */
	public double divide(double numerator, double denominator) throws ArithmeticException {
		// Use compare() method of Double class for more precise comparisons
		if ((Double.compare(numerator, 0.0) == 0)
				&& (Double.compare(denominator, 0.0) == 0)) {
			// Division zero by zero returns Not a Number value
			return Double.NaN;
		} else if ((Double.compare(numerator, 0.0) != 0)
				&& (Double.compare(denominator, 0.0) == 0)) {
			throw new ArithmeticException("Cannot divide with zero");
		} else {
			return numerator/denominator;
		}
	}
	
	
	/**
	 * Performs the basic arithmetic operation of multiplication 
	 * between two positive Integers
	 * 
	 * @param x the first input, that being a positive integer
	 * @param y the second input, that being a positive integer
	 * @return the product of the multiplication
	 * @exception IllegalArgumentException when <b>x</b> or <b>y</b> are negative numbers 
	 * @exception IllegalArgumentException when the product does not fit in an Integer variable 
	 */
	public int multiply(int x, int y) throws IllegalArgumentException {
		if (x < 0 || y < 0) {
			throw new IllegalArgumentException("x & y should be >= 0");
		/* Otherwise, ArithmeticException will be thrown
		 * as y is used as denominator and must no be equal to zero
		 */
		} else if (y == 0) {
			return x * y;
		} else if (x <= divide(Integer.MAX_VALUE, y)) {
			return x * y;			
		} else {
			throw new IllegalArgumentException("The product does not fit in an Integer variable");		
		}
	}
}