package gradeshistogram;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeSet;
import java.util.Collections;


/**
 * The HistogramGenerator program generates and presents a grades frequencies 
 * chart, provided with an array of integers, representing the grades. 
 * The grades are passed via the command line as a txt file. HistogramGenerator
 * implements JFree java library features in order to produce the chart.
 * 
 * @author dkokkotas
 * @version 1.0
 * @since April 2023 
 */

public class HistogramGenerator {
	
	/**
	 * The generateChart method , accepts an array of integers, that being the
	 * grades and visualizes the histogram so it's visible to the end user in 
	 * a proper way.
	 * 
	 * @param gradeValues Single dimension int array
	 * @return Nothing
	 */
	public void generateChart(int[] gradeValues) {
		/*
		 * The XYSeriesCollection object is a set XYSeries series (dataset) that
		 * can be visualized in the same chart
		 */
		XYSeriesCollection dataset = new XYSeriesCollection();
		/*
		 * The XYSeries that are loaded in the dataset. There might be many
		 * series in one dataset.
		 */
		XYSeries data = new XYSeries("random values");

		/*
		 *	Create Arraylist to keep the grade values, in order to count frequencies
		 *  via Collections' frequency method.
		 */
		ArrayList<Integer> list = new ArrayList<Integer>();

		// create a TreeSet to keep grades sorted and remove duplicates
		TreeSet<Integer> tree = new TreeSet<Integer>();

		// pass the elements of gradeValues into both the tree and list
		for(int i = 0; i< gradeValues.length; i++) {
			tree.add(gradeValues[i]);
			list.add(gradeValues[i]);
		}

		// create the new sorted array by converting TreeSet to int array
		int[] sortedGrades = tree.stream().mapToInt(Integer::intValue).toArray();
		
		/*
		 * Populating the XYSeries data object from the input Integer array
		 * values.For each unique element i.e. grade, we add it's value and it's frequency
		 */
		for(int i = 0; i < sortedGrades.length; i++) {
			data.add(sortedGrades[i], Collections.frequency(list, sortedGrades[i]));
		}

		// add the series to the dataset
		dataset.addSeries(data);

		boolean legend = false; // do not visualize a legend
		boolean tooltips = false; // do not visualize tooltips
		boolean urls = false; // do not visualize urls

		// Declare and initialize a createXYLineChart JFreeChart
		JFreeChart chart = ChartFactory.createXYLineChart("Grades Frequency",
				"Grades", "Frequency", dataset,
				PlotOrientation.VERTICAL, legend, tooltips, urls);

		/*
		 * Initialize a frame for visualizing the chart and attach the
		 * previously created chart.
		 */
		ChartFrame frame = new ChartFrame("Grades Histogram", chart);
		frame.pack();
		// makes the previously created frame visible
		frame.setVisible(true);
	}

	/**
	 * The readGrades method , accepts a String value, that being the filename,
	 * reads and fetches the grades from the txt, using a delimiter, in order to
	 * hold them in gradeValues array. Finally the method returns the 
	 * array's values.
	 * 
	 * @param filename String argument that holds the filename
	 * @exception IOException On file path error
	 * @return int[] An integer array containing the grades
	 */
	public int[] readGrades(String filename) throws IOException {
		// create an Arraylist, in case the length of the grades.txt file is dynamic
		ArrayList<Integer> data = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
			String line;
			while ((line = br.readLine()) != null) {
				int value = Integer.parseInt(line);
				// add each line (i.e. grade) into the arraylist
				data.add(value);
			}
		} catch (IOException e) {
			System.out.println("File not found.");
			e.printStackTrace();
		}
		// declare the gradeValues array, and set the length equal to arraylist's
		int[] gradeValues = new int[data.size()];
		// insert the arraylist's values into array
		for (int i = 0; i < data.size(); i++) {
			gradeValues[i] = data.get(i);
		}
		return gradeValues;
	}
	
	/**
	 * The main method , accepts a String array, that being the CL arguments, 
	 * calls the readGrades method to store the grades in an integer
	 * array and calls generateChart method, in order to provide functionality
	 * to the program. The filename is stored in args[0] as that's given via the
	 * CLI.
	 * 
	 * @param args Single dimension string array, containing the filename (i.e. grades.txt).
	 * @return Nothing
	 */
	public static void main(String[] args) throws IOException {
		HistogramGenerator hg = new HistogramGenerator();
		if(args.length != 1) {
			System.err.println("Invalid command line argument. Try again!");
			System.exit(1);
		}
		// call readGrades method to receive grades array
		int[] grades = hg.readGrades(args[0]);
		// call generateChart method to present the histogram
		hg.generateChart(grades);
	}	
}
