package data_structure.heap.online.meetingroom;

import java.util.*;

public class MeetRoom2 {

    public static void main(String[] args) {
        /**
         * Given an array of meeting time intervals intervals where intervals[i] = [starti, endi], return the minimum number of conference rooms required.
         */

        int [][] intervals = {{0,30},{5,10},{15,20}};
        //Output: 2
        System.out.print(minMeetingRooms2Pointer(intervals));
    }

    public static int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals,(a,b)-> a[0]-b[0]); //COmparator.compareint(a->a[0);
        PriorityQueue<Integer>  minHeap = new PriorityQueue<>();
        for (int i = 0; i < intervals.length ; i++) {
            if(!minHeap.isEmpty() && intervals[i][0] >= minHeap.peek()){ // start >= end prev meeting room can be used
               minHeap.poll(); //meeting can happen in existing meeting room
            }
            minHeap.offer(intervals[i][1]);
        }
        return minHeap.size();
    }

    public static int minMeetingRooms2Pointer(int[][] intervals) {
        int [] startArr = new int[intervals.length];
        int [] endArr = new int[intervals.length];
        for (int i = 0;i < intervals.length;i++){
            startArr[i] = intervals[i][0];
            endArr[i] = intervals[i][1];
        }
        Arrays.sort(startArr);
        Arrays.sort(endArr);
        int count = 0 ,maxCount = 0 ,start = 0, end = 0;
        while (start < intervals.length){
            if(startArr[start] >= endArr[end]) { //start >= end prev meeting room can be used count --
                count--;
                end++;
            }else{
                count++;
                start++;
            }
            maxCount = Math.max(maxCount,count);
        }
       return maxCount;
    }







    public static int minMeetingRooms2(int[][] intervals) {
        int roomCount = 0;
        Queue<int[]> minHeap1 = new PriorityQueue<>(Comparator.comparingInt(a->a[0]));
        Queue<int[]> minHeap2 = new PriorityQueue<>(Comparator.comparingInt(a->a[0]));
        for(int i = 0;i < intervals.length ;i++){
            minHeap1.add(intervals[i]);
        }
        while (!minHeap1.isEmpty() || !minHeap2.isEmpty() ){
            roomCount++;
            int [] prev = minHeap1.poll();
            while (!minHeap1.isEmpty()){
                int [] cur = minHeap1.poll();
                 if(prev[1] >= cur[0]){ //conflict
                     minHeap2.add(cur);
                     continue;
                 }
                prev = cur;
            }

            Queue<int[]> tmp  = minHeap1;
            minHeap1 = minHeap2;
            minHeap2 = tmp;
        }
        return  roomCount;
    }

}
