package math;

import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

/**
 * The ArithmeticOperationsTest serves the unit testing of
 * ArithmeticOperations operations. Includes a plethora
 * of test cases, challenging the functionality of both
 * divide and multiply methods. Assertions, exceptions
 * testing etc. are some key features applied within
 * the test methods, provided by JUnit.
 *
 * @author  dkokkotas
 * @version 1.0
 * @since   May 2023
 */
public class ArithmeticOperationsTest {
	
	@Rule
	public ExpectedException thrown = ExpectedException.none(); //initialize it to .none()
	
	private final ArithmeticOperations ao = new ArithmeticOperations();
	
	/*
	 * A unit test verifying the correctness of division
	 * process between two double arguments.
	 */
	@Test
	public void test_quotientShouldBeCalculatedCorrectly() {
		assertEquals(2.5, ao.divide(5.0, 2.0), 0.0);
	}
	
	/*
	 * A unit test verifying that the division between
	 * a zero numerator and a non-zero denominator
	 * returns zero value.
	 */
	@Test
	public void test_getQuotientShouldReturnZeroValue() {
		assertEquals(0.0, ao.divide(0.0, 2.0), 0.0);
	}
	
	/*
	 * A unit test verifying that the division between
	 * numerator and denominator, both of them provided
	 * with zero values, returns Nan value.
	 */
	@Test
	public void test_getQuotientShouldReturnNaNValue() {
		assertEquals(Double.NaN, ao.divide(0.0, 0.0), 0.0);
	}
	 
	/*
	 * A unit test verifying that an invalid zero
	 * denominator causes ArithmeticException.
	 */
	@Test(expected = ArithmeticException.class) 
	public void test_getQuotient_zero_exception() throws IllegalArgumentException { 
		ao.divide(2.0, 0.0);
	}
	
	/*
	 * A unit test verifying the correctness of
	 * multiplication process between two integer
	 * arguments.
	 */
	@Test
	public void test_productShouldBeCalculatedCorrectly() {
		assertEquals(8, ao.multiply(2, 4));
	}
	
	/*
	 * A unit test verifying that the multiplication
	 * between a zero and a non-zero integers returns
	 * zero value.
	 */
	@Test
	public void test_getProductShouldReturnZeroValue() {
		assertEquals(0, ao.multiply(16, 0));
	}
	
	/*
	 * A unit test verifying that the multiplication
	 * between two integers, both of them provided
	 * with zero values, returns 0.
	 */
	@Test
	public void test_getProductShouldReturnZeroValueBoth() {
		assertEquals(0, ao.multiply(0, 0));
	}
	
	/*
	 * A test case for the exceptions caused when
	 * argument's X value is negative. Testing
	 * the exception is performed with a @Rule.
	 */
	@Test
	public void test_getProduct_negativeArgumentX_RuleException() throws IllegalArgumentException {
	  thrown.expect(IllegalArgumentException.class);
	  thrown.expectMessage("x & y should be >= 0");
	  ao.multiply(-2, 5);
	}
	
	/*
	 * A test case for the exceptions caused when
	 * argument's Y value is negative. Testing
	 * the exception is performed with a @Rule.
	 */
	@Test
	public void test_getProduct_negativeArgumentY_RuleException() throws IllegalArgumentException {
	  thrown.expect(IllegalArgumentException.class);
	  thrown.expectMessage("x & y should be >= 0");
	  ao.multiply(2, -5);
	}
	
	/*
	 * A test case for the exceptions caused when
	 * both arguments' values are negative. Testing
	 * the exception is performed with a @Rule.
	 */
	@Test
	public void test_getProduct_negativeArgumentsXandY_RuleException() throws IllegalArgumentException {
	  thrown.expect(IllegalArgumentException.class);
	  thrown.expectMessage("x & y should be >= 0");
	  ao.multiply(-2, -5);
	}
	
	/*
	 * A test case for the exceptions caused when the
	 * product does not fit in an Integer variable.
	 * Testing the exception is performed with a @Rule.
	 */
	@Test
	public void test_getProduct_DoesNotFitInInteger_RuleException() throws IllegalArgumentException {
	  thrown.expect(IllegalArgumentException.class);
	  thrown.expectMessage("The product does not fit in an Integer variable");
	  ao.multiply(((2147483647 / 2) + 1), 2);
	}
}