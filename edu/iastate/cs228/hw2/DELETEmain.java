package edu.iastate.cs228.hw2;

public class DELETEmain {

    public static void main(String[] args) {
        Point[] pts = new Point[5];

        pts[0] = new Point(0,100);
        pts[1] = new Point(0, 90);
        pts[2] = new Point(0, 80);
        pts[3] = new Point(0, 70);
        pts[4] = new Point(0, 60);

        SelectionSorter s = new SelectionSorter(pts);
        s.setComparator(1);
        s.sort();

        for (int i=0; i<pts.length; i++) {
            System.out.println(s.points[i].toString());
        }

    }
}
