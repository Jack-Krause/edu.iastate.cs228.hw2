package edu.iastate.cs228.hw2;

/**
 *  
 * @author
 *
 */

/**
 * 
 * This class executes four sorting algorithms: selection sort, insertion sort, mergesort, and
 * quicksort, over randomly generated integers as well integers from a file input. It compares the 
 * execution times of these algorithms on the same input. 
 *
 */

import java.io.FileNotFoundException;
import java.util.Scanner; 
import java.util.Random; 


public class CompareSorters 
{
	/**
	 * Repeatedly take integer sequences either randomly generated or read from files. 
	 * Use them as coordinates to construct points.  Scan these points with respect to their 
	 * median coordinate point four times, each time using a different sorting algorithm.  
	 * 
	 * @param args
	 **/
	public static void main(String[] args) throws FileNotFoundException
	{
		PointScanner[] scanners = new PointScanner[4];
		Point[] pointArray = null;
		PointScanner selectionScanner = null;
		PointScanner insertionScanner = null;
		PointScanner mergeScanner = null;
		PointScanner quickScanner = null;

		Scanner scnr = new Scanner(System.in);

		int trial = 1;
		System.out.println("key: 1 (random) 2 (file input) 3 (exit)");
		int userInput = 0;
		while (userInput != 3) {
			System.out.println("Trial: ");
			userInput = scnr.nextInt();
			System.out.println(userInput);
			if (userInput == 1) {
				System.out.println("Enter number of random points: ");
				int pointsNumber = scnr.nextInt();
				System.out.println(pointsNumber);
				Random r = new Random();
				pointArray = generateRandomPoints(pointsNumber, r);
				selectionScanner = new PointScanner(pointArray, Algorithm.SelectionSort);
				insertionScanner = new PointScanner(pointArray, Algorithm.InsertionSort);
				mergeScanner = new PointScanner(pointArray, Algorithm.MergeSort);
				quickScanner = new PointScanner(pointArray, Algorithm.QuickSort);
			} else if (userInput == 2) {
				System.out.println("Points from a file");
				String fileName = scnr.next();
				System.out.println(fileName);
				try {
					selectionScanner = new PointScanner(fileName, Algorithm.SelectionSort);
					insertionScanner = new PointScanner(fileName, Algorithm.InsertionSort);
					mergeScanner = new PointScanner(fileName, Algorithm.MergeSort);
					quickScanner = new PointScanner(fileName, Algorithm.QuickSort);
				} catch (FileNotFoundException e) {
					//
				}
			} else {
				break;
			}
			//
			scanners[0] = selectionScanner;
			scanners[1] = insertionScanner;
			scanners[2] = mergeScanner;
			scanners[3] = quickScanner;

			System.out.println("algorithm size time (ns)");
			System.out.println("----------------------------------");
			for (int i=0; i<scanners.length; i++) {
				scanners[i].scan();
				System.out.println(scanners[i].stats());
			}
			System.out.println("----------------------------------");
			System.out.println();
			trial++;
		}

		// For each input of points, do the following.
		// 
		//     a) Initialize the array scanners[].  
		//
		//     b) Iterate through the array scanners[], and have every scanner call the scan() 
		//        method in the PointScanner class.  
		//
		//     c) After all four scans are done for the input, print out the statistics table from
		//		  section 2.
		//
		// A sample scenario is given in Section 2 of the project description. 
		
	}
	
	
	/**
	 * This method generates a given number of random points.
	 * The coordinates of these points are pseudo-random numbers within the range 
	 * [-50,50] × [-50,50]. Please refer to Section 3 on how such points can be generated.
	 * 
	 * Ought to be private. Made public for testing. 
	 * 
	 * @param numPts  	number of points
	 * @param rand      Random object to allow seeding of the random number generator
	 * @throws IllegalArgumentException if numPts < 1
	 */
	public static Point[] generateRandomPoints(int numPts, Random rand) throws IllegalArgumentException
	{
		Random generator = rand;
		Point[] ret = new Point[numPts];
		for (int i=0; i<numPts; i++) {
			int x = generator.nextInt(101)-50;
			int y = generator.nextInt(101)-50;
			ret[i] = new Point(x,y);
		}
		return ret;
	}
	
}
