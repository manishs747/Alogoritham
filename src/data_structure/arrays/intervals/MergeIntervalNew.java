package data_structure.arrays.intervals;

import utils.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervalNew {


    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        // Output: [[1,6],[8,10],[15,18]]
        //Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
        ArrayUtils.print(merge(intervals));
    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a->a[0]));
        List<int [] > mergeInterval = new ArrayList<>();
        for (int [] cur : intervals){
            // if no conflict add else merge
            if(mergeInterval.isEmpty() || cur[0] > mergeInterval.getLast()[1]){
                mergeInterval.add(cur);
            }else {
                //merge
                int [] prev = mergeInterval.getLast();
                prev[1] = Math.max(cur[1],prev[1]);
            }
        }
        return mergeInterval.toArray(new int[mergeInterval.size()][]);
    }
}
