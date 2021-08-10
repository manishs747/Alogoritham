package data_structure.heap;

import java.util.Comparator;
import java.util.PriorityQueue;


/**
 *  https://leetcode.com/problems/find-median-from-data-stream/
 */

public class MedianFinder {

    PriorityQueue<Integer> lowers = new PriorityQueue<Integer>(Comparator.reverseOrder()), //MaxHeap
            highers = new PriorityQueue<>(); //minHeap

    public void addNum(int num) {
        lowers.add(num);
        highers.add(lowers.poll());
        if (lowers.size() < highers.size()) {
            lowers.add(highers.poll());
        }
        System.out.println(lowers);
        System.out.println(highers);
    }

    public double findMedian() {
        return lowers.size() > highers.size() ? lowers.peek() : (lowers.peek() + highers.peek()) / 2.0;
    }
}
