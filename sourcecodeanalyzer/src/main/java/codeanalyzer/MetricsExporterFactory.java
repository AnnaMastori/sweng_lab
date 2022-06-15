package codeanalyzer;

/**
 * Factory class for the MetricsExporter interface.
 * @author annamastori
 *
 */
public class MetricsExporterFactory {
	
	/**
	 * Creates a MetricsExporter that corresponds to the type of the output file. 
	 * @param fileType the type of the output file
	 */
	public MetricsExporter createMetricsExporter(String fileType) {
		MetricsExporter ex;
		if (fileType.equals("csv")) {
			ex = new CSVMetricsExporter();
		} else {
			ex = new JsonMetricsExporter();
		}
		return ex;
	}
}
