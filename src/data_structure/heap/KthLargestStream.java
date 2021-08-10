package data_structure.heap;


import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/kth-largest-element-in-a-stream/
 */
public class KthLargestStream {
    public static void main(String[] args) {
        int[] arr = {};
        KthLargestStream ks = new KthLargestStream(1, arr);
        System.out.println(ks.add(9));
    }

    private int k;
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public KthLargestStream(int k, int[] nums) {
        this.k = k;
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        minHeap.add(val);
        if (minHeap.size() > k) {
            minHeap.remove();
        }
        return minHeap.peek();
    }
}
