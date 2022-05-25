package io;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import math.ArithmeticOperations;

public class FileIOTest {

	static FileIO testClass;
	static String fileName;

	@BeforeClass
	public static void setup() {
		testClass = new FileIO();
	}

	@Test
	public void test_readFile() {
		int[] nums= {1,2,3,4,5};
		
		
		Assert.assertArrayEquals(nums, testClass.readFile("../unittesting/src/test/resources/io/testnums.txt"));
	}
}
