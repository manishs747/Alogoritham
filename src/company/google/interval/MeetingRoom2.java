package company.google.interval;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/meeting-rooms-ii/description/
 */
public class MeetingRoom2 {
    public static void main(String[] args) {
        int [][] intervals = {{0,30},{5,10},{15,20}};
        //Output: 2
        System.out.println(minMeetingRooms(intervals));
    }


    public static int minMeetingRooms(int[][] intervals) {
        int [] start = new int [intervals.length] , end = new int [intervals.length];
        for (int i = 0; i <  intervals.length ; i++){
              int [] interval = intervals[i];
              start[i] = interval[0];
              end[i] = interval[1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int sp = 0, ep = 0 , maxRoom = 0 , room = 0;
        while (sp < start.length && ep < end.length){
            if(start[sp] < end[ep]){
                room++;
                sp++;
                maxRoom = Math.max(maxRoom,room);
            }else{ //meeting end
                room--;
                ep++;
            }
        }
        return maxRoom;
    }

    public static int minMeetingRooms2(int[][] intervals){
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int[] interval : intervals) {
            if (!pq.isEmpty() && pq.peek() <= interval[0]) {
                pq.poll();
            }
            pq.offer(interval[1]);
        }
        return pq.size();
    }




}
