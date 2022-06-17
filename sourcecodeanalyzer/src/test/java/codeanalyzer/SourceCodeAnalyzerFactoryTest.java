package codeanalyzer;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.mockito.Mockito.mock;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;


public class SourceCodeAnalyzerFactoryTest {

    SourceCodeAnalyserFactory factory ;
    SourceFileReader mockedWebReader ;
    SourceFileReader mockedLocalReader ;

    @Before
    public void setUp() throws IOException {
    	factory = new SourceCodeAnalyserFactory();
    	mockedWebReader = mock(LocalFileReader.class);
    	mockedLocalReader = mock(LocalFileReader.class);
    }

    @Test
    public void testCreateSourceCodeAnalyzerRegexLocal() {
        SourceCodeAnalyzer analyzer = factory.createSourceCodeAnalyzer("regex", mockedLocalReader);
        Assert.assertTrue(analyzer instanceof RegexAnalyzer);
    }

    @Test
    public void testCreateSourceCodeAnalyzerStrcompLocal() {
        SourceCodeAnalyzer analyzer = factory.createSourceCodeAnalyzer("strcomp", mockedLocalReader);
        Assert.assertTrue(analyzer instanceof StrcompAnalyzer);
    }

    @Test
    public void testCreateSourceCodeAnalyzerNullLocal() {
        SourceCodeAnalyzer analyzer = factory.createSourceCodeAnalyzer("unknown", mockedLocalReader);
        Assert.assertTrue(analyzer instanceof NullSourceCodeAnalyser);
    }

    @Test
    public void testCreateSourceCodeAnalyzerRegexWeb() {
        SourceCodeAnalyzer analyzer = factory.createSourceCodeAnalyzer("regex", mockedWebReader);
        Assert.assertTrue(analyzer instanceof RegexAnalyzer);
    }

    @Test
    public void testCreateSourceCodeAnalyzerStrcompWeb() {
        SourceCodeAnalyzer analyzer = factory.createSourceCodeAnalyzer("strcomp", mockedWebReader);
        Assert.assertTrue(analyzer instanceof StrcompAnalyzer);
    }

    @Test
    public void testCreateSourceCodeAnalyzerNullWeb() {
        SourceCodeAnalyzer analyzer = factory.createSourceCodeAnalyzer("unknown", mockedWebReader);
        Assert.assertTrue(analyzer instanceof NullSourceCodeAnalyser);
    }
}