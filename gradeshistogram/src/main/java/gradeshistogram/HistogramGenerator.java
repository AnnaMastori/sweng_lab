package gradeshistogram;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 * This class generates a histogram chart from a given txt file that contains grades.
 * @author annamastori
 *
 */

public class HistogramGenerator {

	public static void main(String args[]) {
		// takes the grades from the txt file
		ArrayList<Integer> list = readFile(args[0]);
		int[] array=createFrequencyArray(list);
		generateChart(array);
	}

	/**
	 * Receives the path to the grades.txt file. From the file an ArrayList is
	 * created with the grades it contains.
	 * 
	 * @param filepath
	 * @return ArrayList of Integers
	 */
	public static ArrayList<Integer> readFile(String filepath) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		try {
			File myObj = new File(filepath);
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				list.add(Integer.parseInt(data));
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		} finally {
		}

		return list;

	}

	/**
	 * Receives a list of Integers and produces a frequency array.
	 * @param Integer list
	 * @return int array with frequencies
	 */
	public static int[] createFrequencyArray(ArrayList<Integer> list) {

		Collections.sort(list);
		int max = list.get(list.size() - 1);
		int array[] = new int[max + 1];
		for (Integer i : list) {
			array[i]++;
		}
		return array;
	}

	/***
	 * Receives a single dimension Integer ArrayList. From this array the dataset
	 * that will be used for the visualization is generated. Finally, The chart is
	 * generated with the use of the aforementioned dataset and then presented in
	 * the screen.
	 * 
	 * @param dataValues array of ints
	 */
	public static void generateChart(int[] dataValues) {
		/*
		 * The XYSeriesCollection object is a set XYSeries series (dataset) that can be
		 * visualized in the same chart
		 */
		XYSeriesCollection dataset = new XYSeriesCollection();
		/*
		 * The XYSeries that are loaded in the dataset. There might be many series in
		 * one dataset.
		 */
		XYSeries data = new XYSeries("random values");

		/*
		 * Populating the XYSeries data object from the input Integer array values.
		 */
		for (int i = 0; i < dataValues.length; i++) {
			data.add(i, dataValues[i]);
		}

		// add the series to the dataset
		dataset.addSeries(data);

		boolean legend = false; // do not visualize a legend
		boolean tooltips = false; // do not visualize tooltips
		boolean urls = false; // do not visualize urls

		// Declare and initialize a createXYLineChart JFreeChart
		JFreeChart chart = ChartFactory.createXYLineChart("Grades Histogram", "Grades", "Frequency", dataset,
				PlotOrientation.VERTICAL, legend, tooltips, urls);
		
		/*
		 * Initialize a frame for visualizing the chart and attach the previously
		 * created chart.
		 */
		ChartFrame frame = new ChartFrame("First", chart);
		frame.pack();
		// makes the previously created frame visible
		frame.setVisible(true);
	}

}
