package codeanalyzer;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MetricsExporterFactoryTest {
	MetricsExporterFactory factory;

	@Before
	public void setup() {
		factory = new MetricsExporterFactory();
	}

	@Test
	public void testCreateMetricsExporterCSV() {
		MetricsExporter exporter = factory.createMetricsExporter("csv");
		Assert.assertTrue(exporter instanceof CSVMetricsExporter);
	}

	@Test
	public void testCreateMetricsExporterJson() {
		MetricsExporter exporter = factory.createMetricsExporter("json");
		Assert.assertTrue(exporter instanceof JsonMetricsExporter);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCreateMetricsExporterInvalid() {
		MetricsExporter exporter = factory.createMetricsExporter("INVALID");
		
	}

}
