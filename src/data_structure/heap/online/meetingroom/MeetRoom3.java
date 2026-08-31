package data_structure.heap.online.meetingroom;

import java.util.*;

public class MeetRoom3 {

    public static int counter = 0;

    public static class Court{
        int id;
        int lastBookTime;
        List<int []> bookings = new ArrayList<>();

        public Court(int start ,int end){
            id = ++counter;
            lastBookTime = end;
            bookings.add(new int[]{start,end});
        }

        @Override
        public String toString() {
            return "Court id "+id+" with num of booking: "+bookings.size();
        }
    }

    public static void main(String[] args) {
        int [][] bookingRecords = {{0,30},{5,10},{15,20}};
        System.out.print(assignCourts(bookingRecords));
    }



   public static List<Court> assignCourts(int[][]  bookingRecords){
       Arrays.sort(bookingRecords, Comparator.comparingInt(a->a[0]));
       PriorityQueue<Court> minHeap = new PriorityQueue<>(Comparator.comparingInt(a->a.lastBookTime));
       List<Court>  courtList = new ArrayList<>();
       for (int i = 0; i < bookingRecords.length; i++) {
           if(!minHeap.isEmpty() && bookingRecords[i][0] >= minHeap.peek().lastBookTime) { //start >= end same meeting room can be used
             Court court = minHeap.poll();
             court.bookings.add(new int []{bookingRecords[i][0],bookingRecords[i][1]});
             court.lastBookTime = bookingRecords[i][1];
             minHeap.add(court);
           }else {
               Court court = new Court(bookingRecords[i][0], bookingRecords[i][1]);
               minHeap.add(court);
               courtList.add(court);
           }
       }
       return courtList;
    }
}
