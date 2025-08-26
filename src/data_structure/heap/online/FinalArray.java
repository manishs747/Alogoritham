package data_structure.heap.online;


import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/final-array-state-after-k-multiplication-operations-i/description/?envType=daily-question&envId=2024-12-16
 */
public class FinalArray {

    public static void main(String[] args) {

    }

    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.comparingInt(i->nums[i]));
        for (int i = 0; i < nums.length ; i++)
            minHeap.add(i);
        while (k-- > 0){
            int  min = minHeap.poll();
            nums[min] *= multiplier;
            minHeap.add(min);
        }
         return nums;
    }
}
