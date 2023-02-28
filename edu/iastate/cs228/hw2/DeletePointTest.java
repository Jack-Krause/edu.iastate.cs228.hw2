package edu.iastate.cs228.hw2;

import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;

public class DeletePointTest {
    Point p;
    Point p2;
    Point p3;

    @Before
    public void setup() {
        p = new Point(30, 10);
        p2 = new Point(100, 100);
        p3 = new Point(1,0);
    }

    @Test
    public void stringTest() {
        assertEquals("(30, 10)", p.toString());
        assertEquals("(100, 100)", p2.toString());
        assertEquals("(1, 0)", p3.toString());
    }



    //
}
