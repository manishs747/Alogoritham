package data_structure.arrays.online;

import utils.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode.com/problems/merge-intervals/
 */
public class MergeIntervals {

    public static void main(String[] args) {
       int [][] arr = {{1,3},{2,6},{8,10},{15,18}};
        ArrayUtils.print(merge(arr));
    }


    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);
        int[] last = intervals[0];
        for (int i = 1; i < intervals.length ; i++) {
            if(last[1] >= intervals[i][0]){
                last[1] = Math.max(intervals[i][1],last[1]);
            }else{
                list.add(intervals[i]);
                last = intervals[i];
            }
        }
        return  list.stream().toArray(int[][] ::new);
    }

    public int[][] merge2(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        List <int[]>  merged = new ArrayList<>();
        int[] last = null;
        for(int [] interval:intervals){
            if(last == null || last[1] < interval[0]){
                merged.add(interval);
                last = interval;
            }else{
                last[1]  = Math.max(last[1],interval[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
