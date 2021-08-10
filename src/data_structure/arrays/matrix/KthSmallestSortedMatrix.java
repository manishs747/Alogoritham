package data_structure.arrays.matrix;

import data_structure.arrays.Utility;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
 */
public class KthSmallestSortedMatrix {
    //1,5,9,10,11,12,13,13,15
    public static void main(String[] args) {

        int arr[][] = {{1, 5, 9, 10},
                {10, 11, 12},
                {13, 13, 15}};
        Utility.print(arr);
        System.out.println(kthSmallest(arr, 8));

    }


    public static int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < n * n; i++) {
            maxheap.add(matrix[i / n][i % n]);
            if (maxheap.size() > k) {
                maxheap.remove();
            }
        }
        return maxheap.peek();
    }


}
