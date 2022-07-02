package codeanalyzer;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * This is a front-facing interface for the code analysis system.
 * 
 * @author annamastori
 *
 */
public class SourceCodeAnalyserFacade {

	/**
	 * Performs all the operations for the code analysis.
	 * 
	 * @param sourceFileLocation     web or local
	 * @param filepath               the path of the file
	 * @param sourceCodeAnalyzerType the type of analysis to be performed
	 * @param outputFileType         csv or json
	 * @param outputFilePath         the path of the output file
	 * @throws IOException
	 */
	public void exportMetrics(String sourceFileLocation, String filepath, String sourceCodeAnalyzerType,
			String outputFileType, String outputFilePath) throws IOException {

		SourceFileReaderFactory readerFactory = new SourceFileReaderFactory();

		SourceFileReader reader = readerFactory.createSourceReader(sourceFileLocation);

		SourceCodeAnalyserFactory sourceCodeAnalyzerFactory = new SourceCodeAnalyserFactory();

		SourceCodeAnalyzer analyzer = sourceCodeAnalyzerFactory.createSourceCodeAnalyzer(sourceCodeAnalyzerType,
				reader);

		int loc = analyzer.calculateLOC(filepath);
		int nom = analyzer.calculateNOM(filepath);
		int noc = analyzer.calculateNOC(filepath);

		Map<String, Integer> metrics = new HashMap<>();
		metrics.put("loc", loc);
		metrics.put("nom", nom);
		metrics.put("noc", noc);

		MetricsExporterFactory metricsExporterFactory = new MetricsExporterFactory();

		MetricsExporter exporter = metricsExporterFactory.createMetricsExporter(outputFileType);
		exporter.writeFile(metrics, outputFilePath);
	}

}