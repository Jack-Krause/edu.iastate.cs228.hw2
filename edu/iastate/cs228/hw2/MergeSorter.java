package edu.iastate.cs228.hw2;

import java.io.FileNotFoundException;
import java.lang.NumberFormatException; 
import java.lang.IllegalArgumentException; 
import java.util.InputMismatchException;

/**
 *  
 * @author
 *
 */

/**
 * 
 * This class implements the mergesort algorithm.   
 *
 */

public class MergeSorter extends AbstractSorter
{
	// Other private instance variables if needed
	
	/** 
	 * Constructor takes an array of points.  It invokes the superclass constructor, and also 
	 * set the instance variables algorithm in the superclass.
	 *  
	 * @param pts   input array of integers
	 */
	public MergeSorter(Point[] pts) 
	{
		super(pts);
		this.algorithm = "merge sort";
	}


	/**
	 * Perform mergesort on the array points[] of the parent class AbstractSorter. 
	 * 
	 */
	@Override 
	public void sort()
	{
		mergeSortRec(this.points);
	}

	
	/**
	 * This is a recursive method that carries out mergesort on an array pts[] of points. One 
	 * way is to make copies of the two halves of pts[], recursively call mergeSort on them, 
	 * and merge the two sorted subarrays into pts[].   
	 * 
	 * @param pts	point array 
	 */
	private void mergeSortRec(Point[] pts) {
		int n = pts.length;
		if (n<=1) { return; }

		int middle = n/2;

		Point[] left = new Point[middle];
		Point[] right = new Point[n-middle];
		for (int i=0; i<middle; i++) {
			left[i] = pts[i];
		}
		for (int k=0; k<n-middle; k++) {
			left[k-middle] = pts[k];
		}

		mergeSortRec(left);
		mergeSortRec(right);
		Point[] result = merge(left, right);
		for (int i=0; i<pts.length; i++) {
			pts[i] = new Point(result[i]);
		}
	}

	
	// Other private methods if needed ...
	private Point[] merge(Point[] Left, Point[] Right) {
		int p = Left.length;
		int q = Right.length;

		Point[] arr = new Point[p+q];
		int l = 0;
		int r = 0;
		int k = 0;

		while (l < p && r < q) {
			if (pointComparator.compare(Left[l], Right[r]) <= 0) {
				arr[k] = new Point(Left[l]);
				l++;
			} else {
				arr[k] = new Point(Right[r]);
				r++;
			}
			k++;
		}

		while (l < p) {
			arr[k] = new Point(Left[l]);
			k++;
			l++;
		}

		while (r < q) {
			arr[k] = new Point(Right[r]);
			k++;
			r++;
		}
		return arr;
	}
}
