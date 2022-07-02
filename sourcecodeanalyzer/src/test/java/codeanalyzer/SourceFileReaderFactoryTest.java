package codeanalyzer;

import org.junit.Assert;
import org.junit.Test;

public class SourceFileReaderFactoryTest {

	SourceFileReaderFactory factory = new SourceFileReaderFactory();

	@Test
	public void testcreateSourceReaderWeb() {
		Assert.assertTrue(factory.createSourceReader("web") instanceof WebFileReader);
	}

	@Test
	public void testcreateSourceReaderLocal() {
		Assert.assertTrue(factory.createSourceReader("local") instanceof LocalFileReader);
	}

	@Test
	public void testcreateSourceReaderNull() {
		Assert.assertTrue(factory.createSourceReader("invalid") instanceof NullFileReader);
	}

}