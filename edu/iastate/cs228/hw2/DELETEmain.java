package edu.iastate.cs228.hw2;
import java.io.FileNotFoundException;
import java.util.Random;

public class DELETEmain {

    public static void main(String[] args) {
        Random r = new Random(7);
        Point[] pts = CompareSorters.generateRandomPoints(20, r);
        PointScanner s = new PointScanner(pts, Algorithm.MergeSort);
        s.scan();
        System.out.println(s.stats());
        System.out.println(s.toString());
    }


}
