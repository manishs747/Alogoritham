package company.google.interval;

import utils.ArrayUtils;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRoom {


    public static void main(String[] args) {

      int [][] intervals = {{0,30},{5,10},{15,20}};
      //  Output: false
    }


    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a->a[0]));
        for (int i = 1; i < intervals.length ; i++) {
            int [] last = intervals[i-1] , cur = intervals[i];
            if(last[1] > cur[0]) return false;
        }
        return true;
    }
}
