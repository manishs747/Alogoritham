package data_structure.heap.online;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class KThSmallestSumInMatrix {


        public static void main(String[] args) {
        int arr[][] = {
                {1, 3, 11},
                {2, 4, 6}
        };
        System.out.println(kthSmallest(arr,9));
    }


    public static int kthSmallest(int[][] mat, int k) {
        Queue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        kthSmallest(mat, maxHeap, k, 0, 0);
        return maxHeap.peek();
    }


    public static void kthSmallest(int[][] mat, Queue<Integer> maxHeap, int k, int row, int sum) {
        if (row == mat.length) {
            maxHeap.add(sum);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
            return;
        }
        for (int num : mat[row]) {
            kthSmallest(mat, maxHeap, k, row + 1, sum + num);
        }
    }
}
