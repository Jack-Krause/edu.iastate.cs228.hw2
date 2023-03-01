package edu.iastate.cs228.hw2;
import java.util.Random;

public class DELETEmain {

    public static void main(String[] args) {
        Random rand = new Random(5);
        Point[] testPts = CompareSorters.generateRandomPoints(10, rand);

        AbstractSorter s = new MergeSorter(testPts);
        s.setComparator(0);
        s.sort();
        for (int i=0; i< testPts.length; i++) {
            System.out.println(s.points[i].toString());
        }

    }
}
