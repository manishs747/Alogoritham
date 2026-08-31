package data_structure.arrays.online;

import java.util.Arrays;
import java.util.Comparator;

public class CarPooling {

    public static void main(String[] args) {
        int [][] trips = {{3,2,7},{3,7,9},{8,3,9}};
        System.out.println(carPooling(trips,11));
    }


    public static boolean carPooling(int[][] trips, int capacity) {
        int[][] sweeps = new int[trips.length * 2][2];
        int idx = 0;
        for (int[] t : trips) {
            sweeps[idx++] = new int[]{t[1],  t[0]};
            sweeps[idx++] = new int[]{t[2], -t[0]};
        }
        Arrays.sort(sweeps, Comparator.comparingInt((int [] a)-> a[0]).thenComparingInt(a->a[1]) );
        int curCap = 0;
        for( int[]  sweep : sweeps ){
            curCap += sweep[1];
            if( curCap > capacity) return false;
        }
        return true;
    }


}
