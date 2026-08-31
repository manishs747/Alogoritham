package Interview.atlas.interval_reporting;

import java.util.*;

public class SweepLineOverlap {




        public int[][] overlapAtLeastTwo(int[][] intervals) {
            List<int[]> events = new ArrayList<>();

            // Step 1: Convert intervals into events
            for (int[] in : intervals) {
                events.add(new int[]{in[0], +1});       // start
                events.add(new int[]{in[1] + 1, -1});   // end+1 since inclusive
            }

            // Step 2: Sort by time, then by delta (+1 before -1)
            events.sort((a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));

            // Step 3: Sweep
            List<int[]> result = new ArrayList<>();
            int active = 0;
            Integer windowStart = null;

            for (int[] ev : events) {
                int time = ev[0], delta = ev[1];
                int prevActive = active;
                active += delta;

                if (prevActive < 2 && active >= 2) {
                    // Overlap starts
                    windowStart = time;
                } else if (prevActive >= 2 && active < 2 && windowStart != null) {
                    // Overlap ends
                    result.add(new int[]{windowStart, time });
                    windowStart = null;
                }
            }

            return result.toArray(new int[result.size()][]);
        }




    public static List<int[]> findBusiestWindows(int[][] intervals) {



        List<int[]> events = new ArrayList<>();
        for (int[] interval : intervals) {
            events.add(new int[]{interval[0], 1});  // start
            events.add(new int[]{interval[1], -1}); // end
        }

        // Sort by time, with start (+1) before end (-1) on ties
        events.sort((a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

        int active = 0, maxActive = 0;
        Integer windowStart = null;
        List<int[]> result = new ArrayList<>();

        for (int[] event : events) {
            int time = event[0], type = event[1];
            int prevActive = active;
            active += type;

            if (active > maxActive) {
                maxActive = active;
                result.clear();        // found new max → reset windows
                windowStart = time;
            } else if (active == maxActive && prevActive < maxActive) {
                windowStart = time;    // entering max window
            } else if (prevActive == maxActive && active < maxActive) {
                result.add(new int[]{windowStart, time});
                windowStart = null;    // exiting max window
            }
        }

        return result;
    }









        // ---------------- Demo ----------------
        public static void main(String[] args) {
            SweepLineOverlap solver = new SweepLineOverlap();

            int[][] input1 = {{2, 5}, {4, 8}, {12, 15}};
            int[][] output1 = solver.overlapAtLeastTwo(input1);

            System.out.println("Overlaps for input1:");
            for (int[] interval : output1) {
                System.out.println(Arrays.toString(interval));
            }
            // Expected: [4, 6]

            int[][] input2 = {{1, 3}, {2, 4}, {3, 5}};
            int[][] output2 = solver.overlapAtLeastTwo(input2);

            System.out.println("Overlaps for input2:");
            for (int[] interval : output2) {
                System.out.println(Arrays.toString(interval));
            }
            // Expected: [2,4] (since at least 2 pipelines overlap continuously)
        }


}
