package io;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import math.ArithmeticOperations;

public class FileIOTest {

	static FileIO testClass;
	static int nums[] = {1,2,3,4,5};

	@BeforeClass
	public static void setup() {
		testClass = new FileIO();
	}

	@Test
	public void test_readFile() {
		int[] nums= {1,2,3,4,5};
		Assert.assertArrayEquals(nums, testClass.readFile("../unittesting/src/test/resources/io/testnums.txt"));
	}
	
	@Rule
	public ExpectedException expectedEx = ExpectedException.none();

	@Test
	public void shouldThrowIllegalArgumentExceptionFileNotEXist() {
	    expectedEx.expect(IllegalArgumentException.class);
	    expectedEx.expectMessage("Input file does not exist");
	    testClass.readFile("../unittesting/src/test/resources/io/abcdoesnotexist.txt");
	}
	
	@Test
	public void shouldThrowIllegalArgumentExceptionEmptyFile() {
	    expectedEx.expect(IllegalArgumentException.class);
	    expectedEx.expectMessage("Given file is empty");
	    testClass.readFile("../unittesting/src/test/resources/io/emptyfile.txt");
	}
}
