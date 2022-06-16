package codeanalyzer;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CSVExporterTest {

	MetricsExporter exp;

	@Before
	public void setup() {
		exp = new CSVMetricsExporter();
	}

	@Test
	public void testWriteCSV() {
		// create the metrics content
		Map<String, Integer> metrics = new HashMap<>();
		metrics.put("loc", 30);
		metrics.put("nom", 5);
		metrics.put("noc", 2);

		// generate and write the output file
		String outputFilepath = "src/test/resources/output_metrics";
		exp.writeFile(metrics, outputFilepath);

		// evaluate that the file exists
		File outputFile = new File(outputFilepath + ".csv");
		Assert.assertTrue(outputFile.exists());

		// delete the generated file
		outputFile.delete();
	}

}