package data_structure.arrays.mergeinterval;

import utils.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {


    public static void main(String[] args) {
      int [][]  intervals = {{1,3},{2,6},{8,10},{15,18}};
        ArrayUtils.print(merge(intervals));
    }


    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a->a[0]));
        List<int[]> result = new ArrayList<>();
        int [] last = null;


        return null;
    }
}
