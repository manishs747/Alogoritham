package data_structure.arrays.intervals.sweepline;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SweepLine {

    public static void main(String[] args) {
        /**
         * Use this info to solve different problems:
         *
         * Max concurrency (Meeting Rooms II, My Calendar III)
         *
         * Busiest windows (like your CI pipelines problem)
         *
         * Free time (Employee Free Time)
         *
         * Skyline shape (The Skyline Problem)
         *
         *
         */

        int[][] input = {{2,5}, {4,8}, {12,15}};
        int[][] output = findWindows(input);

        System.out.println("Windows with at least 2 pipelines:");
        for (int[] in : output) {
            System.out.println(Arrays.toString(in));
        }
        // Expected: [4,6]
    }


    //find window where overalpping is more than 2
    public static int[][] findWindows(int[][] intervals) {
        List<int [] > events = new ArrayList<>();
        for (int [] interval : intervals){
            events.add(new int []{interval[0],1});
            events.add(new int []{interval[1]+1,-1});
        }

        events.sort(Comparator.comparingInt(a->a[0]));
        List<int[]> result = new ArrayList<>();
        int active = 0;
        Integer windowStart = null;
        for (int [] event : events){
            int preActive = active;
            int time = event[0];
            active += event[1];

            if(preActive < 2 && active >= 2){
                windowStart = time;
            }else if(preActive >= 2 && active < 2 && windowStart != null){
               result.add(new int [] {windowStart,time}); // overlap ends (inclusive)
                windowStart = null;
            }
        }
        return  result.toArray(new int[result.size()][]);
    }

        public static int maxConcurrentJobs(int[][] intervals) {
        List<int[]> events = new ArrayList<>();

        // Convert intervals into events
        for (int[] in : intervals) {
            events.add(new int[]{in[0], +1});       // start
            events.add(new int[]{in[1] + 1, -1});   // end+1 trick for inclusivity
        }

        // Sort events by time, then by delta
        events.sort((a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));

        int active = 0, maxActive = 0;

        // Sweep line
        for (int[] ev : events) {
            active += ev[1];  // update active jobs
            maxActive = Math.max(maxActive, active);
        }

        return maxActive;
    }
}
