package math;

import java.util.ArrayList;

import io.FileIO;

public class ArrayOperations {

	/**
	 * This method with a given FileIO and MyMath instances creates an array of ints
	 * from a given filepath and makes an array that has only its the prime ints.
	 * 
	 * @param fileIo, FileIO type object
	 * @param filepath, String with the path the the file 
	 * @param myMath, MyMath object
	 * @return array with only the primes from the file's ints
	 */
	public int[] findPrimesInFile(FileIO fileIo, String filepath, MyMath myMath) {
		int[] array = fileIo.readFile(filepath);
		int[] primeNums = new int[array.length];
		int counter = 0;
		for (int n : array) {
			if (myMath.isPrime(n)) {
				primeNums[counter] = n;
				counter++;
			}
		}
		return primeNums;
	}
}
