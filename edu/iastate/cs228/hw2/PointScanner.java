package edu.iastate.cs228.hw2;

/**
 * 
 * @author 
 *
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;


/**
 * 
 * This class sorts all the points in an array of 2D points to determine a reference point whose x and y 
 * coordinates are respectively the medians of the x and y coordinates of the original points. 
 * 
 * It records the employed sorting algorithm as well as the sorting time for comparison. 
 *
 */
public class PointScanner  
{
	private Point[] points; 
	
	private Point medianCoordinatePoint;  // point whose x and y coordinates are respectively the medians of 
	                                      // the x coordinates and y coordinates of those points in the array points[].
	private Algorithm sortingAlgorithm;    
	
		
	protected long scanTime; 	       // execution time in nanoseconds. 
	
	/**
	 * This constructor accepts an array of points and one of the four sorting algorithms as input. Copy 
	 * the points into the array points[].
	 * 
	 * @param  pts  input array of points 
	 * @throws IllegalArgumentException if pts == null or pts.length == 0.
	 */
	public PointScanner(Point[] pts, Algorithm algo) throws IllegalArgumentException
	{
		this.sortingAlgorithm = algo;
		if (pts == null || pts.length == 0) {
			throw new IllegalArgumentException();
		}

		this.points = new Point[pts.length];
		for (int i=0; i<pts.length; i++) {
			this.points[i] = new Point(pts[i]);
		}
	}

	
	/**
	 * This constructor reads points from a file. 
	 * 
	 * @param  inputFileName
	 * @throws FileNotFoundException 
	 * @throws InputMismatchException   if the input file contains an odd number of integers
	 */
	protected PointScanner(String inputFileName, Algorithm algo) throws FileNotFoundException, InputMismatchException
	{
		File f = new File(inputFileName);
		int counter = 0;
		Scanner scnr = new Scanner(f);
		while (scnr.hasNextInt()) {
			counter++;
			scnr.nextInt();
		}
		scnr.close();
		if (counter % 2 != 0) {
			throw new InputMismatchException();
		}
		this.points = new Point[counter/2];
		this.sortingAlgorithm = algo;
		scnr = new Scanner(f);
		int pCounter = 0;
		while (scnr.hasNextInt()) {
			int a = scnr.nextInt();
			int b = 0;
			if (scnr.hasNextInt()) {
				b = scnr.nextInt();
			}
			points[pCounter] = new Point(a, b);
			pCounter++;
		}

	}

	
	/**
	 * Carry out two rounds of sorting using the algorithm designated by sortingAlgorithm as follows:  
	 *    
	 *     a) Sort points[] by the x-coordinate to get the median x-coordinate. 
	 *     b) Sort points[] again by the y-coordinate to get the median y-coordinate.
	 *     c) Construct medianCoordinatePoint using the obtained median x- and y-coordinates.     
	 *  
	 * Based on the value of sortingAlgorithm, create an object of SelectionSorter, InsertionSorter, MergeSorter,
	 * or QuickSorter to carry out sorting.       
	 * @param algo
	 * @return
	 */
	public void scan()
	{
		// TODO  
		AbstractSorter aSorter = null;
		if (sortingAlgorithm == null) {
			return;
		} else if (sortingAlgorithm == Algorithm.QuickSort) {
			aSorter = new QuickSorter(this.points);
		} else if (sortingAlgorithm == Algorithm.MergeSort) {
			aSorter = new MergeSorter(this.points);
		} else if (sortingAlgorithm == Algorithm.InsertionSort) {
			aSorter = new InsertionSorter(this.points);
		} else if (sortingAlgorithm == Algorithm.SelectionSort) {
			aSorter = new InsertionSorter(this.points);
		}

		//Sorting for X:
		aSorter.setComparator(0);
		long startTimeX = System.nanoTime();
		aSorter.sort();
		long elapsedX = System.nanoTime() - startTimeX;
		int medX = aSorter.getMedian().getX();

		//Sorting for Y:
		aSorter.setComparator(1);
		long startTimeY = System.nanoTime();
		aSorter.sort();
		long elapsedY = System.nanoTime() - startTimeY;
		int medY = aSorter.getMedian().getY();
		medianCoordinatePoint = new Point(medX, medY);

		//elapsed time
		long elapsed = elapsedX + elapsedY;
		this.scanTime = elapsed;
		System.out.println("finished");
	}
	
	
	/**
	 * Outputs performance statistics in the format: 
	 * 
	 * <sorting algorithm> <size>  <time>
	 * 
	 * For instance, 
	 * 
	 * selection sort   1000	  9200867
	 * 
	 * Use the spacing in the sample run in Section 2 of the project description. 
	 */
	public String stats()
	{
		StringBuilder s = new StringBuilder();
		String one = String.format("%-17s", this.sortingAlgorithm);
		s.append(one);
		String two = String.format("%-9s", this.points.length);
		s.append(two);
		s.append(this.scanTime);
		return s.toString();
	}
	
	
	/**
	 * Write MCP after a call to scan(),  in the format "MCP: (x, y)"   The x and y coordinates of the point are displayed on the same line with exactly one blank space 
	 * in between. 
	 */
	@Override
	public String toString()
	{
		StringBuilder s = new StringBuilder("MCP: (");
		s.append(this.medianCoordinatePoint.getX());
		s.append(", ");
		s.append(this.medianCoordinatePoint.getY());
		s.append(')');
		return s.toString();
	}

	
	/**
	 *  
	 * This method, called after scanning, writes point data into a file by outputFileName. The format 
	 * of data in the file is the same as printed out from toString().  The file can help you verify 
	 * the full correctness of a sorting result and debug the underlying algorithm. 
	 * 
	 * @throws FileNotFoundException
	 */
	public void writeMCPToFile() throws FileNotFoundException
	{
		// TODO 
	}	

	public Point[] getPoints() {
		return this.points;
	}

		
}
