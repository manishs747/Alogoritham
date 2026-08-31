package data_structure.heap.online.meetingroom;

import utils.ArrayUtils;

import java.util.Arrays;
import java.util.Comparator;

public class MeetRoom1 {

    /**
     * Given an array of meeting time intervals where intervals[i] = [starti, endi], determine if a person could attend all meetings.
     */
    public static void main(String[] args) {
        int [][] intervals = {{0,30},{5,10},{15,20}};
        //Output: false
    }

    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        for (int i = 1 ; i < intervals.length; i++){
           int [] prev = intervals[i-1] , cur = intervals[i];
           if(prev[1] > cur[0]) return false;
        }
        return true;
    }
}
