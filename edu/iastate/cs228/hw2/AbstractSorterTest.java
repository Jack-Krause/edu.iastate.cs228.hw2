package edu.iastate.cs228.hw2;

import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertTrue;

public class AbstractSorterTest {

    Point[] testArr;

    private AbstractSorter select;
    private AbstractSorter insertion;
    private AbstractSorter merge;
    private AbstractSorter quick;

    /**
     * Helper method to check if the array is sorted correctly.
     *
     * @param i - 0 if sorted by X, 1 if sorted by Y
     * @param s - (sorter) AbstractSorter
     * @return
     */
    private boolean checkSort(int i, AbstractSorter s) {
        if (i == 0) {
            for (int j = 0; j < s.points.length - 1; j++) {
                int temp = s.points[i].getX();
                if (temp > s.points[i + 1].getX()) {
                    return false;
                }
            }
        } else if (i == 1) {
            for (int k = 0; k < s.points.length - 1; k++) {
                int temp = s.points[i].getY();
                if (temp > s.points[i + 1].getY()) {
                    return false;
                }
            }
        }
        return true;
    }

    @Before
    public void setup() {
        Random rand = new Random(5);
        testArr = CompareSorters.generateRandomPoints(30, rand);
    }

    @Test
    public void selectionSortTest() {
        select = new SelectionSorter(testArr);
        select.setComparator(0);
        select.sort();
        assertTrue(checkSort(0, select));
        select.setComparator(1);
        select.sort();
        assertTrue(checkSort(1, select));
    }

    @Test
    public void insertionSortTest() {
        insertion = new InsertionSorter(testArr);
        insertion.setComparator(0);
        insertion.sort();
        assertTrue(checkSort(0, insertion));
        insertion.setComparator(1);
        insertion.sort();
        assertTrue(checkSort(1, insertion));
    }

    @Test
    public void mergeSortTest() {
        merge = new MergeSorter(testArr);
        merge.setComparator(0);
        merge.sort();
        assertTrue(checkSort(0, merge));
        merge.setComparator(1);
        merge.sort();
        assertTrue(checkSort(1, merge));
    }

    @Test
    public void quickSortTest() {
        quick = new QuickSorter(testArr);
        quick.setComparator(0);
        quick.sort();
        assertTrue(checkSort(0, quick));
        quick.setComparator(1);
        quick.sort();
        assertTrue(checkSort(1, quick));
    }


//
}
