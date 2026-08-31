package algorithams.prefixsum.meetingroom;


import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.com/problems/meeting-rooms/description/
 *
 * Given an array of meeting time intervals where intervals[i] = [starti, endi], determine if a person could attend all meetings.
 */
public class MeetingRoom {

    public static void main(String[] args) {
        int [][] intervals = {{0,30},{5,10},{15,20}};
        //Output: false
    }


    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(x -> x[0]));
        for (int i = 1; i < intervals.length; i++) {
            int [] cur = intervals[i] , prev = intervals[i-1];
            if (cur[0] < prev[1])  return false;
        }
        return true;
    }


    public boolean canAttendMeetingsLineSweep(int[][] intervals) {
        int [][] linesweep =  new int[intervals.length*2][2];
        for (int i = 0; i < intervals.length; i++) {
            linesweep[i*2] = new int[] { intervals[i][0],1};
            linesweep[i*2+1] = new int[] { intervals[i][1],-1};
        }
        Arrays.sort(linesweep, (int [] a, int [] b) -> (a[0]== b[0] ? a[1]-b[1] : a[0]-b[0]));
        int count = 0;
        for (int i = 0; i < linesweep.length; i++) {
            count += linesweep[i][1];
            if(count > 1) return false;
        }
        return true;
    }
}
