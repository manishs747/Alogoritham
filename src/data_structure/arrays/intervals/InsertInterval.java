package data_structure.arrays.intervals;


import utils.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode.com/problems/insert-interval/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class InsertInterval {

    public static void main(String[] args) {
        //int [][] intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int [] newinterval = {0,8};
        //output :  [[1,2],[3,10],[12,16]]
        int [][] intervals  = {{1,5}};
        ArrayUtils.print(insert(intervals,newinterval));
    }


    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int []> result = new ArrayList<>();
        boolean isMerged = false;
        for (int []  interval :intervals ) {

            if(!isMerged && newInterval[1] < interval[0]){
                result.add(newInterval);
                isMerged = true;
            }
            if(!isMerged && (
                    (newInterval[0] >= interval [0] &&newInterval[0] <= interval [1]) ||(newInterval[1] >= interval [0] &&newInterval[1] <= interval [1])
            || (interval[0] >= newInterval [0] &&interval[0] <= newInterval [1]) ||(interval[1] >= newInterval [0] &&interval[1] <= newInterval [1])
            )

            ){
                interval[0] = Math.min(interval[0],newInterval[0]);
                interval[1]= Math.max(interval[1],newInterval[1]);
                isMerged = true;
            }


            if(result.isEmpty() || result.get(result.size()-1)[1] < interval[0]){
                result.add(interval);
            }else{
                result.get(result.size()-1)[1] = Math.max(result.get(result.size()-1)[1],interval[1]);
            }
        }
        if(!isMerged) result.add(newInterval);
        return result.toArray(new int[0][]);
    }

    public static int[][] insert2(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0;

        // Add intervals that come before the newInterval
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i++]);
        }

        // Merge overlapping intervals
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        result.add(newInterval);

        // Add intervals that come after the newInterval
        while (i < intervals.length) {
            result.add(intervals[i++]);
        }

        return result.toArray(new int[0][]);
    }


}
