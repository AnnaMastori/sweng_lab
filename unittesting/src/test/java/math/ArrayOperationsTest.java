package math;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import io.FileIO;

public class ArrayOperationsTest {
	
	static ArrayOperations test;
	
	@BeforeClass
	public static void setup() {
		test = new ArrayOperations();
	}
	
	@Test
	public void test_findPrimesInFile() {
		String filepath ="../unittesting/src/test/resources/io/testnumsmock.txt";
		MyMath mathmock = mock(MyMath.class);
		FileIO filemock = mock(FileIO.class);
		int[] array = {2,3,4,5,6};
		when(filemock.readFile(filepath)).thenReturn(array);
		when(mathmock.isPrime(1)).thenThrow(IllegalArgumentException.class);
		when(mathmock.isPrime(2)).thenReturn(true);
		when(mathmock.isPrime(3)).thenReturn(true);
		when(mathmock.isPrime(4)).thenReturn(false);
		when(mathmock.isPrime(5)).thenReturn(true);
		int[] arrayresult = {2,3,5,0,0};

		Assert.assertArrayEquals(arrayresult, test.findPrimesInFile(filemock, filepath, mathmock));
		


	}
}
