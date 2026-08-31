package data_structure.arrays.intervals.sweepline;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BuisestWindow {

    public static void main(String[] args) {
        int[][] input = {{1,4},{2,6},{5,8}};
        int[][] busiest = busiestWindows(input);

        System.out.println("Busiest windows:");
        for (int[] win : busiest) {
            System.out.println(Arrays.toString(win));
        }
        // Expected: [2,4], [5,6]
    }


    public static int[][] busiestWindows(int[][] intervals) {
        List<int[]> events = new ArrayList<>();
        for (int[] in : intervals) {
            events.add(new int[]{in[0], +1});       // start
            events.add(new int[]{in[1] + 1, -1});   // end+1 (inclusive)
        }

        events.sort((a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1])
                : Integer.compare(a[0], b[0]));

        int active = 0, maxActive = 0;
        Integer windowStart = null;
        List<int[]> result = new ArrayList<>();

        for (int[] ev : events) {
            int time = ev[0], delta = ev[1];
            int prevActive = active;
            active += delta;

            if (active > maxActive) {
                // new max found, reset results
                maxActive = active;
                result.clear();
                windowStart = time;
            } else if (active == maxActive && prevActive < maxActive) {
                // new busiest window starts
                windowStart = time;
            } else if (prevActive == maxActive && active < maxActive && windowStart != null) {
                // busiest window ends
                result.add(new int[]{windowStart, time - 1});
                windowStart = null;
            }
        }

        return result.toArray(new int[result.size()][]);
    }


}
