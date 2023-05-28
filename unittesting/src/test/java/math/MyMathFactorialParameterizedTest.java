package math;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.Assert.assertEquals;

/**
 * A test class that implements a Parameterized test
 * for the MyMath factorial method, demonstrating
 * Unit Testing.
 * 
 * @author  dkokkotas
 * @version 1.0
 * @since   May 2023
 */
@RunWith(Parameterized.class)
public class MyMathFactorialParameterizedTest {
	
	private final MyMath mm = new MyMath();
	
	// The value is the unique identifier of each parameter
	@Parameter (value = 0) 
	public int n;
	@Parameter (value = 1)
	public int fact;
	
	/*
	 * The following method generates the input values 
	 * for the tests. 
	 */
	@Parameters
	public static Collection<Object[]> data() {
		Object[][] data = new Object[][]{
			{0, 1},
			{1, 1},
			{2, 2},
			{12, 479001600}};
		
			return Arrays.asList(data);
	}
	
	/*
	 * A unit test that is executed for each pair of 
	 * parameters. 
	 */
	@Test
	public void test_factorialShouldBeCalculatedCorrectly() {
		assertEquals(fact, mm.factorial(n));
	}
	
	/*
	 * !! IMPORTANT !!
	 * It's not advised to add non-parameterized tests in 
	 * @RunWith(Parameterized.class) classes. They will be executed
	 * as many times as the existing pairs of parameters. 
	 * Normal unit tests should be placed in an other class.
	 */
}