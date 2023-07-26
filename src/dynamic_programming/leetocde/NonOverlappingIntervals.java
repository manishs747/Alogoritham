package dynamic_programming.leetocde;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


/**
 * https://leetcode.com/problems/non-overlapping-intervals/description/
 */
public class NonOverlappingIntervals {

    public static void main(String[] args) {
        int [][] arr = {{1,2},{2,3},{3,4},{1,3}};
        System.out.println(eraseOverlapIntervals(arr));

    }


    public static int eraseOverlapIntervals(int[][] intervals) {
       Arrays.sort(intervals, Comparator.comparingInt(a->a[0]));
        List<int[]> result = new ArrayList<>();
        int [] last = null;
        for (int [] interval:intervals) {
            if(last == null || last[1] <= interval[0]){
                result.add(interval);
                last = interval;
            }else{
                last[1] = Math.max(last[1],interval[1]);
            }
        }
        return intervals.length-result.size() ;
    }
}
