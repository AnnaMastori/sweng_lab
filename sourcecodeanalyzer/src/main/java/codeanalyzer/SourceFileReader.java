package codeanalyzer;

import java.io.IOException;
import java.util.List;

/**
 * Reads a specific file that is either stored locally or on the web.
 * @author annamastori
 *
 */
public interface SourceFileReader {

	/**
	 * Reads a file and returns a List<String> with its contents
	 * @param filepath the path of the file
	 * @throws IOException
	 */
	public List<String> readFileIntoList(String filepath) throws IOException;
	
	/**
	 * Read a file and return a String with the contents
	 * @param filepath the path of the file
	 * @throws IOException
	 */
	public String readFileIntoString(String filepath) throws IOException;

}