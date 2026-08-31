package data_structure.arrays.intervals;


import utils.ArrayUtils;

import java.util.*;

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
        for (int []  curInterval :intervals ) {
            if(result.isEmpty() || curInterval[0] > result.getLast()[1]){
                result.add(curInterval);
            }else{
              result.get(result.size()-1)[1] = Math.max(result.get(result.size()-1)[1],curInterval[1]);
            }
        }
        return result.toArray(new int[0][]);
    }



    public static int[][] merge3(int[][] intervals) {
        Queue<int [] > minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for (int [] interval: intervals){
            minHeap.add(interval);
        }
        List<int []> result = new ArrayList<>();
        while (!minHeap.isEmpty()){
            int [] curInterval = minHeap.poll();
            if(result.isEmpty() || result.getLast()[1] < curInterval[0]){
                result.add(curInterval);
            }else {

                result.getLast()[1] = Math.max(curInterval[1],result.getLast()[1]);
            }
        }
        return result.toArray(new int [result.size()][]);
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
