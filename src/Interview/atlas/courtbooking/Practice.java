package Interview.atlas.courtbooking;

import java.util.*;

public class Practice {

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

        public void addBooking(BookingRecord bookingRecord){
            this.bookings.add(bookingRecord);
            lastBookTime = bookingRecord.finishTime;
        }
    }

    public static List<Court> assignCourts(List<BookingRecord> bookingRecords) {
         List<Court>  courtList = new ArrayList<>();
         if(bookingRecords == null || bookingRecords.isEmpty()) return courtList;
         bookingRecords.sort(Comparator.comparingInt(a->a.startTime));
         PriorityQueue<Court> minHeap = new PriorityQueue<>(Comparator.comparingInt(a->a.lastBookTime));

         for (BookingRecord  bookingRecord : bookingRecords ){
             if(!minHeap.isEmpty() && bookingRecord.startTime >= minHeap.peek().lastBookTime){     //handle prev court can be used start >= end old
                 Court court = minHeap.poll();
                 court.addBooking(bookingRecord);
                 minHeap.add(court);
             }else{
                 Court court = new Court(bookingRecord);
                 minHeap.add(court);
                 courtList.add(court);
             }
         }
        return courtList;
    }

}
