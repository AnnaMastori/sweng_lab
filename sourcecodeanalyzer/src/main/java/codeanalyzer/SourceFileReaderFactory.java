package codeanalyzer;

/**
 * Factory for the SourceFileReader interface.
 * 
 * @author annamastori
 *
 */
public class SourceFileReaderFactory {

	/**
	 * Creates the correct type of SourceFileReader
	 * 
	 * @param readerType type of reader
	 * @return SourceFileReader
	 */
	public SourceFileReader createSourceReader(String readerType) {
		SourceFileReader sfr;
		if (readerType.equals("web")) {
			sfr = new WebFileReader();
		} else {
			sfr = new LocalFileReader();
		}
		return sfr;
	}

}
