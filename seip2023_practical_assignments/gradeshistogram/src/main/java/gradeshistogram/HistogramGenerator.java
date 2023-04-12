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


/**
 * The HistogramGenerator program generates and presents a grades frequencies' 
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
	 * @param gradeValues Signle dimension int array
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
		 * Populating the XYSeries data object from the input Integer array
		 * values.
		 */
		for (int i = 0; i < gradeValues.length; i++) {
			data.add(i, gradeValues[i]);
		}

		// add the series to the dataset
		dataset.addSeries(data);

		boolean legend = false; // do not visualize a legend
		boolean tooltips = false; // do not visualize tooltips
		boolean urls = false; // do not visualize urls

		// Declare and initialize a createXYLineChart JFreeChart
		JFreeChart chart = ChartFactory.createXYLineChart("Grades Frequency",
				"Grades", "Scale", dataset,
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
	 * The main method , accepts a string argument, that being the grades.txt 
	 * file, reads and fetches the grades from the txt and uses a delimiter
	 * to hold them in gradeValues array. Finally, it calls the generateChart
	 * method, in order to provide functionality to the program.
	 * 
	 * @param args Single dimension string array, containing the filename (i.e. grades.txt).
	 * @exception IOException On file path error
	 * @return Nothing
	 */
	public static void main(String[] args) throws IOException {
		// create an arraylist, in case the length of the grades.txt file is dynamic.
        ArrayList<Integer> data = new ArrayList<>();
        // filename is stored in args[0] as that's given via the CLI
        try (BufferedReader br = new BufferedReader(new FileReader(args[0]))) {  
            String line;
            while ((line = br.readLine()) != null) {
                int num = Integer.parseInt(line);
                // add each line (i.e. grade) into the arraylist
                data.add(num);
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
		HistogramGenerator hg = new HistogramGenerator();
		// call generateChart method to present the histogram
		hg.generateChart(gradeValues);
	}	
}
