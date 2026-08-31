package data_structure.heap.online;


import utils.ArrayUtils;

import java.util.*;

/**
 * https://leetcode.com/problems/merge-intervals/description/
 */
public class MergeInterval {


    public static void main(String[] args) {
        int [][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        //Output: [[1,6],[8,10],[15,18]]
        ArrayUtils.print(merge(intervals));
    }

    public static int[][] merge(int[][] intervals) {
        if(intervals.length == 0) return null;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);
        for (int i = 1; i <  intervals.length; i++) {
           int [] prev = result.getLast() , cur = intervals[i];
           if(prev[1] >= cur[0]){
               prev[1] = Math.max(cur[1],prev[1]);
               result.set(result.size()-1,prev);
           }else{
               result.add(cur);
           }
        }
        return result.toArray(new int [result.size()][]);
    }


        public int[][] merge2(int[][] intervals) {
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


        public  int [][] mergePQ(int [][] intervals){
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




}
