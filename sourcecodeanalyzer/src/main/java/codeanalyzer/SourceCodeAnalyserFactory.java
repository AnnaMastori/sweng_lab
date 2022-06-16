package codeanalyzer;

/**
 * This is the factory for the SourceCodeAnalyser.
 * 
 * @author annamastori
 *
 */
public class SourceCodeAnalyserFactory {

	/**
	 * Creates appropriates SourceCodeAnalyser.
	 * 
	 * @param analysisType the type of analysis
	 * @param fileReader   the SourceFileReader that will read the file
	 * @return the SourceCodeAnalyzer object
	 */
	public SourceCodeAnalyzer createSourceCodeAnalyzer(String analysisType, SourceFileReader fileReader) {

		SourceCodeAnalyzer an;
		if (analysisType.equals("regex")) {
			an = new RegexAnalyzer(fileReader);
		} else {
			an = new StrcompAnalyzer(fileReader);
		}
		return an;
	}
}