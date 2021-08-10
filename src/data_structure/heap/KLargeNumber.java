package data_structure.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 */
public class KLargeNumber {


    public static void main(String[] args) {

        int [] arr = {3,2,1,5,6,4};
        System.out.println(findKthLargest(arr,2));

    }

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num:nums) {
            minHeap.add(num);
            if(minHeap.size() > k){
                minHeap.remove();
            }
        }
        return minHeap.remove();
    }


    public static int findKthLargestArr(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }
}
