package math;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * A class used as a holder of the @RunWith and @Suite 
 * annotations, necessary when someone needs to group
 * classes that include tests, for demonstrating Unit Testing.
 * 
 * @author dkokkotas
 * @version 1.0
 * @since   May 2023
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({MyMathTest.class, MyMathFactorialParameterizedTest.class})
public class MyMathTestSuite {
	/*
	 * This class remains empty. Is used only as a holder 
	 * of the above annotations.
	 */
}
