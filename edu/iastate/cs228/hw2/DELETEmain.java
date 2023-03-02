package edu.iastate.cs228.hw2;
import java.io.FileNotFoundException;
import java.util.Random;

public class DELETEmain {


    public static void main(String[] args) {
        Random rand = new Random(5);
        Point[] testPts = CompareSorters.generateRandomPoints(20, rand);
        AbstractSorter m = new MergeSorter(testPts);
        m.setComparator(1);
        m.sort();
        for (int i=0; i<m.points.length; i++) {
            System.out.println(m.points[i].toString());
        }
    }

//    public static void main(String[] args) {
//        Random rand = new Random(7);
////        Point[] balls = CompareSorters.generateRandomPoints(20, rand);
//        try {
//            PointScanner ps = new PointScanner("aa.txt", Algorithm.SelectionSort);
//            for (int i=0; i<ps.getPoints().length; i++) {
//                Point[] p = ps.getPoints();
//                System.out.println(p[i].toString());
//            }
//        } catch (FileNotFoundException e) {
//            //
//            System.out.println("File not Found");
//        }
//    }

}
