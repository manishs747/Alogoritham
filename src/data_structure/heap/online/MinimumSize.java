package data_structure.heap.online;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/minimum-limit-of-balls-in-a-bag/description/?envType=daily-question&envId=2024-12-07
 */
public class MinimumSize {

    public static void main(String[] args) {
       int [] nums = {2,4,8,2};
       int maxOperations = 4;
        System.out.println(minimumSize(nums,maxOperations));
    }


    public static int minimumSize(int[] nums, int maxOperations) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Comparator.reverseOrder());
        Arrays.stream(nums).forEach(num -> maxHeap.add(num));
        while (maxOperations-- > 0){
           int bag = maxHeap.poll();
           maxHeap.add(bag/2);
           maxHeap.add(bag - (bag/2));
        }
        return maxHeap.peek();
    }
}
