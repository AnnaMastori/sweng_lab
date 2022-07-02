package codeanalyzer;

/**
 * This is the factory for the SourceCodeAnalyser interface.
 * 
 * @author annamastori
 *
 */
public class SourceCodeAnalyserFactory {

	/**
	 * Creates the appropriate SourceCodeAnalyser.
	 * 
	 * @param analysisType the type of analysis
	 * @param fileReader   the SourceFileReader that will read the file
	 * @return the SourceCodeAnalyzer object
	 */
	public SourceCodeAnalyzer createSourceCodeAnalyzer(String analysisType, SourceFileReader fileReader) {

		SourceCodeAnalyzer an;
		if (analysisType.equals("regex")) {
			an = new RegexAnalyzer(fileReader);
		} else if (analysisType.equals("strcomp")) {
			an = new StrcompAnalyzer(fileReader);
		} else {
			an = new NullSourceCodeAnalyser();
		}
		return an;
	}
}