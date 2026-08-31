package Interview.atlas.courtbooking;

import data_structure.heap.online.meetingroom.MeetRoom3;
import opennlp.tools.util.Heap;

import java.util.*;

public class TennisCourtBooking {
    private static int courtCounter = 0;
    public static class BookingRecord {
        int id;
        int startTime;
        int finishTime;

        public BookingRecord(int id, int startTime, int finishTime) {
            if (startTime >= finishTime) {
                throw new IllegalArgumentException("startTime must be < finishTime");
            }
            this.id = id;
            this.startTime = startTime;
            this.finishTime = finishTime;
        }

        @Override
        public String toString() {
            return "Booking{" + id + ": " + startTime + " -> " + finishTime + "}";
        }
    }

    public static class Court {
        int id;
        int lastBookTime;
        List<BookingRecord> bookings = new ArrayList<>();

        public Court( BookingRecord firstBooking) {
            this.id = ++courtCounter;
            this.lastBookTime = firstBooking.finishTime;
            this.bookings.add(firstBooking);
        }

        @Override
        public String toString() {
            return "Court#" + id + " bookings=" + bookings;
        }
    }

    public static List<Court> assignCourts(List<BookingRecord> bookingRecords) {
        if(bookingRecords == null|| bookingRecords.isEmpty()) return new ArrayList<>();
        bookingRecords.sort(Comparator.comparingInt(a->a.startTime));
        Queue<Court> minHeap = new PriorityQueue<>(Comparator.comparingInt(a->a.lastBookTime));
        List<Court> courtList = new ArrayList<>();
        for (BookingRecord bookingRecord:bookingRecords){
            if(!minHeap.isEmpty() &&  bookingRecord.startTime >= minHeap.peek().lastBookTime){
              Court  court = minHeap.poll();
              court.bookings.add(bookingRecord);
              court.lastBookTime = bookingRecord.finishTime;
              minHeap.offer(court);
            }else{
                Court court = new Court(bookingRecord);
                courtList.add(court);
                minHeap.offer(court);
            }
        }
        return courtList;
    }

    public static void main(String[] args) {
        List<BookingRecord> bookings = Arrays.asList(
                new BookingRecord(1, 0, 30),
                new BookingRecord(2, 5, 10),
                new BookingRecord(3, 15, 20),
                new BookingRecord(4, 35, 50),
                new BookingRecord(5, 20, 40)
        );

        List<Court> result = assignCourts(bookings);

        System.out.println("Total courts used: " + result.size());
        for (Court c : result) {
            System.out.println(c);
        }
    }
}
