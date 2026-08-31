package Interview.atlas.interval_reporting;

import java.util.*;

public class JobIntervalReporting {


    public static int[][] mergeIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return new int[][]{};
        // Step 1: Sort intervals by start time
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> mergedInterval = new ArrayList<>();
        for (int [] interval:intervals){
            // if no conflict add else merge start > end
            if(mergedInterval.isEmpty() ||  interval[0] > mergedInterval.getLast()[1] ){
                mergedInterval.add(interval);
            }else{
                mergedInterval.getLast()[1] = Math.max(interval[1],mergedInterval.getLast()[1]);
            }


        }
        return mergedInterval.toArray(new int[mergedInterval.size()][]);
    }




    }
