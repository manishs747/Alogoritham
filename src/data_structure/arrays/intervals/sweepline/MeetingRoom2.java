package data_structure.arrays.intervals.sweepline;

import java.util.*;

public class MeetingRoom2 {

    public static void main(String[] args) {
       int [][] intervals = {{0,30},{5,10},{15,20}};
        System.out.print(minMeetingRoomsHeap(intervals));
    }

    public static int minMeetingRooms(int[][] intervals) {
        int count = 0 , maxCount = 0;
        List<int []> events = new ArrayList<>();
        for (int [] interval: intervals){
           events.add(new int[]{interval[0],1});
           events.add(new int[]{interval[1],-1});
        }
        events.sort((a, b) ->
                a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0])
        );
        for (int [] event:events ){
            count += event[1];
            maxCount = Math.max(maxCount,count);
        }
        return maxCount ;
    }

    public static int minMeetingRoomsHeap(int[][] intervals) {
        Arrays.sort(intervals,Comparator.comparingInt(a->a[0]));
        PriorityQueue<Integer >  minHeap = new PriorityQueue<>();
        for (int [] interval : intervals){
            //check if new  meeting room is needed
            if(!minHeap.isEmpty() &&  interval[0] >= minHeap.peek() ) {
                minHeap.poll();
                minHeap.add(interval[1]);
            }else{
                minHeap.add(interval[1]);
            }
        }
        return minHeap.size();
    }




}
