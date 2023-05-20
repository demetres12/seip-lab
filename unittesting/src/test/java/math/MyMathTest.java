package math;

import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;


/**
 * The MyMathTest class serves the unit testing of
 * MyMath operations. Includes several test methods
 * regarding factorial and primality normal and exception
 * cases. Assertions, exceptions testing etc. are some
 * key features applied within the test methods, provided
 * by JUnit.
 *
 * @author  dkokkotas
 * @version 1.0
 * @since   May 2023
 */
public class MyMathTest {
	
	@Rule
	public ExpectedException thrown = ExpectedException.none(); //initialize it to .none()
	
	private final MyMath mm = new MyMath();
	
	/*
	 * A test case for the exceptions caused when
	 * argument's value is negative. Testing
	 * the exception is performed with a @Rule.
	 */
	@Test
	public void test_getFactorial_negativeArgument_RuleException() throws IllegalArgumentException {
	  thrown.expect(IllegalArgumentException.class);
	  thrown.expectMessage("Invalid value provided. Input should be within the range [0,12]");
	  mm.factorial(-1);
	}
	
	/*
	 * A test case for the exceptions caused when
	 * argument's value is greater than 12. Testing
	 * the exception is performed with a @Rule.
	 */
	@Test
	public void test_getFactorial_ArgumentGreaterThanTwelve_RuleException() throws IllegalArgumentException {
	  thrown.expect(IllegalArgumentException.class);
	  thrown.expectMessage("Invalid value provided. Input should be within the range [0,12]");
	  mm.factorial(13);
	}
	
	/*
	 * A unit test verifying that the program
	 * returns true when the given value is a prime
	 * number.
	 */
	@Test
	public void test_isPrimeReturnsTrue() {
		assertTrue(mm.isPrime(3));
	}
	
	/*
	 * A unit test verifying that the program
	 * returns false when the given value is a
	 * composite number.
	 */
	@Test
	public void test_isPrimeReturnsFalse() {
		assertFalse(mm.isPrime(4));
	}
	
	/*
	 * A test case for the exceptions caused when
	 * argument's value is less than 2. Testing
	 * the exception is performed with a @Rule.
	 */
	@Test
	public void test_isPrime_ArgumentLessThanTwo_RuleException() throws IllegalArgumentException {
	  thrown.expect(IllegalArgumentException.class);
	  thrown.expectMessage("Invalid value provided. Input should be greater than 1");
	  mm.isPrime(0);
	}
}