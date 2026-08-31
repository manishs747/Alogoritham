package online.leetcode;

import java.util.*;
import java.util.function.ToIntFunction;

public class Solution {

    public static void main(String[] args) {

      /*

     Car Rental - Maximum Overlapping Intervals Problem
 *
 * Problem:
 * A car rental company has data on past rentals in the format:
 * [{carId, startTime, endTime}, {carId, startTime, endTime}, ...]
 * Where each entry represents a car rental with:
 * - carId: identifier for the car
 * - startTime: when the rental starts
 * - endTime: when the rental ends
 *
 * Find the maximum number of cars needed at any point in time to serve all customers.
 *
 * Example:
 * Input: [{0, 1, 3}, {1, 2, 4}]
 * Output: 2
 * Explanation: Between time 2-3, both rentals overlap, requiring 2 cars
              1,+1.
              3 , -1,
              2, +1,
              4, -1


       */

        int [][]  input =  {{0, 1, 3}, {1, 2, 4}};
        System.out.println(getMaxCarNeeded(input));
    }

    public static int getMaxCarNeeded(int [][]  rides){
        int maxCar = 0;
        int [][] lineSweep = new int[2*rides.length][2];
        for(int i = 0 ; i < rides.length;i++){
            int []   ride = rides[i];  // carid , start , end
            lineSweep[2*i]   =  new int[]{ride[1],1};  // start
            lineSweep[2*i+1]   =  new int[]{ride[2],-1}; //end    2*i , 2*i +1
        }
        Arrays.sort(lineSweep,Comparator.comparing(a->a[0]));

        Arrays.sort(lineSweep, (a, b) -> a[0] == b [0] ? a[1]-b[1]: a[0] - b[0]);
        int count = 0;
        for(int[] sweep : lineSweep){
            count += sweep[1];
            maxCar = Math.max(maxCar,count);
        }
        return maxCar;
    }




}
