package codeanalyzer;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class NullSourceCodeAnalyserTest {

    private final static String TEST_CLASS = "a random path";
    
    private final SourceCodeAnalyzer sca = new NullSourceCodeAnalyser();
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Test
    public void testCalculateNullLOC() throws IOException {
        System.setErr(new PrintStream(outContent));
        Assert.assertEquals(-1,sca.calculateLOC(TEST_CLASS));
        Assert.assertEquals("Operation aborted due to unknown analyzer type.\n", outContent.toString());
    }

    @Test
    public void testCalculateNullNOM() throws IOException {
        System.setErr(new PrintStream(outContent));
        Assert.assertEquals(-1,sca.calculateNOM(TEST_CLASS));
        Assert.assertEquals("Operation aborted due to unknown analyzer type.\n", outContent.toString());
       
    }

    @Test
    public void testCalculateNullNOC() throws IOException {
        System.setErr(new PrintStream(outContent));
        Assert.assertEquals(-1, sca.calculateNOC(TEST_CLASS));
        Assert.assertEquals("Operation aborted due to unknown analyzer type.\n", outContent.toString());
    }

}