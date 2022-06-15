package codeanalyzer;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Analyzes the contents of a java file and calculates : loc = lines of code,
 * nom = number of methods, and noc=number of classes.
 * 
 * @author annamastori
 *
 */
public interface SourceCodeAnalyzer {

	/**
	 * Calculates the LOC metric.
	 * 
	 * @param filepath the path of the file
	 * @throws IOException
	 */
	public int calculateLOC(String filepath) throws IOException;

	/**
	 * Calculates the NOM metric.
	 * 
	 * @param filepath the path of the file
	 * @throws IOException
	 */
	public int calculateNOM(String filepath) throws IOException;

	/**
	 * Calculates the NOC metric.
	 * 
	 * @param filepath the path of the file
	 * @throws IOException
	 */
	public int calculateNOC(String filepath) throws IOException;

}