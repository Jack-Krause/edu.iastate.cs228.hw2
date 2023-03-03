package edu.iastate.cs228.hw2;

import org.junit.Before;
import org.junit.Test;

import java.util.Random;

public class PScannerTest {


    @Test
    public void constTest() {
        Random rand = new Random(5);
        Point[] p = CompareSorters.generateRandomPoints(30, rand);
        PointScanner pScanner = new PointScanner(p, Algorithm.SelectionSort);
        pScanner.getPoints();

    }












    //
}
