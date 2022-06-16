package codeanalyzer;

import java.io.IOException;
import java.util.List;

/**
 * Returns null if the location of file to be read is unknown.
 * 
 * @author annamastori
 *
 */
public class NullFileReader implements SourceFileReader {
	/**
	 * Reads a file and returns a List<String> with its contents
	 * 
	 * @param filepath the path of the file
	 * @throws IOException
	 */
	@Override
	public List<String> readFileIntoList(String filepath) {
		System.err.print("The file can not be read because its source type is unknown.\n");
		return null;
	}

	/**
	 * Reads a file and returns a String with the contents
	 * 
	 * @param filepath the path of the file
	 * @throws IOException
	 */
	@Override
	public String readFileIntoString(String filepath) {
		System.err.print("The file can not be read because its source type is unknown.\n");
		return null;
	}
}