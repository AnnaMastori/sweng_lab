package math;

/**
 * This MyMath class contains methods that perform basix math operations.
 * 
 * @author Anna Mastori
 * @version 1.0
 * @since 2022-05-23
 */
/**
 * @author masto
 *
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

	/**
	 * This method takes an int and returns true if it is prime.
	 * @param n, an integer number
	 * @return boolean, true if n is prime or false otherwise
	 */
	public boolean isPrime(int n) {

		if (n <= 1)
			throw new IllegalArgumentException();

		for (int i = 2; i < n; i++)
			if (n % i == 0)
				return false;
		return true;
	}

}
