package math;

/**
 * This MyMath class
 * 
 * @author Anna Mastori
 * @version 1.0
 * @since 2022-05-23
 */
public class MyMath {

	/**
	 * This method takes an int and returns its factorial.
	 * 
	 * @param n, must be 0 <= n <= 12
	 * @return int that is the factorial of n
	 */
	public int factorial(int n) {

		if (n < 0 || n > 12) {
			throw new IllegalArgumentException();
		}

		if (n == 0)
			return 1;
		else
			return (n * factorial(n - 1));
	}

}
