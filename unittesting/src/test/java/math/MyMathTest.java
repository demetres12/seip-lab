package math;

import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

/**
 * The MyMathTest class serves the unit testing of
 * MyMath operations. Includes several test cases
 * regarding factorial exceptions thrown. Assertions,
 * exceptions testing etc. are some key options
 * applied within the test methods, provided by JUnit.
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
	 * the exception is performed with a @Rule
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
	 * the exception is performed with a @Rule
	 */
	@Test
	public void test_getFactorial_ArgumentGreaterThanTwelve_RuleException() throws IllegalArgumentException {
	  thrown.expect(IllegalArgumentException.class);
	  thrown.expectMessage("Invalid value provided. Input should be within the range [0,12]");
	  mm.factorial(13);
	}
}