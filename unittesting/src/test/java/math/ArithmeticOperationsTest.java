package math;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class ArithmeticOperationsTest {
	static ArithmeticOperations testClass;
	private static final double DELTA = 1e-15;

	@BeforeClass
	public static void setup() {
		testClass = new ArithmeticOperations();
	}

	@Test
	public void test_divide() {
		Assert.assertEquals(5.0, testClass.divide(20.0, 4.0), DELTA);
	}

	public void test_divide_by_negative() {
		Assert.assertEquals(-5, testClass.divide(20, -4), DELTA);
	}

	public void test_divide_negative_by_positive() {
		Assert.assertEquals(-5.0, testClass.divide(-20, 4), DELTA);
	}

	@Test(expected = ArithmeticException.class)
	public void test_divide_by_zero() {
		testClass.divide(20.0, 0);
	}

}
