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
	
	@Test
	public void test_isPrime_true() {
		Assert.assertEquals(true, testClass.isPrime(3));
	}
	
	@Test
	public void test_isPrime_false() {
		Assert.assertEquals(false, testClass.isPrime(6));
	}
	
	@Test(expected = IllegalArgumentException.class )
	public void test_isPrime_IllegalArgument() {
		Assert.assertEquals(false, testClass.isPrime(1));
	}

}
