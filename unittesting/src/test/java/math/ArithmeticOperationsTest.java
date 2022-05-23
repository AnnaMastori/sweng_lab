package math;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

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
	
	@Test
	public void test_multiply() {
		Assert.assertEquals(20, testClass.multiply(5, 4), DELTA);
	}
	
	@Test
	public void test_multiply_with_zero() {
		Assert.assertEquals(0.0, testClass.multiply(0, 4), DELTA);
	}
	
	@Rule
	public ExpectedException expectedEx = ExpectedException.none();

	@Test
	public void shouldThrowIllegalArgumentExceptionNotInt() {
	    expectedEx.expect(IllegalArgumentException.class);
	    expectedEx.expectMessage("The product does not fit in an Integer variable");
	    testClass.multiply(Integer.MAX_VALUE, 2);
	}
	
	@Test
	public void shouldThrowIllegalArgumentExceptionNegatives() {
	    expectedEx.expect(IllegalArgumentException.class);
	    expectedEx.expectMessage("x & y should be >= 0");
	    testClass.multiply(-1, 2);
	}
	

}
