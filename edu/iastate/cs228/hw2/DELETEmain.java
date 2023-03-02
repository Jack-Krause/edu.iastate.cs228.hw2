package edu.iastate.cs228.hw2;
import java.io.FileNotFoundException;
import java.util.Random;

public class DELETEmain {

    public static void mergeSort(int[] arr) {
        int n = arr.length;
        if (n <= 1) { return; }

        int middle = n/2;

        int[] Left = new int[middle];
        int[] Right = new int[n-middle];

        for (int i=0; i<middle; i++) { Left[i] = arr[i]; }
        for (int k=middle; k<n; k++) { Right[k-middle] = arr[k]; }

        mergeSort(Left);
        mergeSort(Right);
        int[] result = Merge(Left, Right);
        System.arraycopy(result, 0, arr, 0, n);
    }

    public static int[] Merge(int[] Left, int[] Right) {
        int p = Left.length;
        int q = Right.length;
        int[] arr = new int[p+q];

        int l=0;
        int r=0;
        int k=0;

        while (l < p && r < q) {
            if (Left[l] <= Right[r]) {
                arr[k] = Left[l];
                l++;
            } else {
                arr[k] = Right[r];
                r++;
            }
            k++;
        }
        while (l < p) {
            arr[k] = Left[l];
            l++;
            k++;
        }
        while (r < q) {
            arr[k] = Right[r];
            r++;
            k++;
        }
        return arr;
    }

    public static void main(String[] args) {
        Random rand = new Random(5);
        Point[] testPts = CompareSorters.generateRandomPoints(20, rand);
        int[] arr = {90,10,80,20,70,30,60,40,100};
        mergeSort(arr);
        for (int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
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
