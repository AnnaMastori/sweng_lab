package math;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class MyMathTest {
	static MyMath testClass;

	@BeforeClass
	public static void setup() {
		testClass = new MyMath();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_factroial_of_negative() {
		testClass.factorial(-1);
	}
	@Test(expected = IllegalArgumentException.class)
	public void test_factroial_of_large_positive() {
		testClass.factorial(13);
	}

}
