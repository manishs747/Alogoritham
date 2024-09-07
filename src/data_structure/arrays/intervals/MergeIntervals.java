package data_structure.arrays.intervals;


import utils.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode.com/problems/merge-intervals/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class MergeIntervals {

    public static void main(String[] args) {
       int [][] intervals = {{1,3},{2,6},{8,10},{15,18}};// Output: [[1,6],[8,10],[15,18]]

        System.out.println(merge(intervals));
        ArrayUtils.print(merge(intervals));
    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int []> result = new ArrayList<>();
        for (int []  interval :intervals ) {
            if(result.isEmpty() || result.get(result.size()-1)[1] < interval[0]){
                result.add(interval);
            }else{
              result.get(result.size()-1)[1] = Math.max(result.get(result.size()-1)[1],interval[1]);
            }
        }
        return result.toArray(new int[0][]);
    }

    public static int[][] merge2(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int []> result = new ArrayList<>();
        int [] first = intervals[0];
        for (int i = 1; i < intervals.length ; i++) {
             int [] current = intervals[i];
             if(first[1] < current[0]){
                 result.add(first);
                 first = current;
             }else{
                 first[1] = Math.max( first[1],current[1]);
                 first[0] = Math.min( first[0],current[0]);
             }
        }
        result.add(first);
        return result.toArray(new int[0][]);
    }
}
