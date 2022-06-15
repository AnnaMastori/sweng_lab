package codeanalyzer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * MetricsExporter interface.
 * 
 * @author annamastori
 *
 */
public interface MetricsExporter {

	/**
	 * Writes metrics in a file.
	 * 
	 * @param metrics  a map of metrics
	 * @param filepath the path of the file
	 */
	public void writeFile(Map<String, Integer> metrics, String filepath);

}
