package data_structure.arrays.online;

import utils.ArrayUtils;

import java.util.LinkedList;
import java.util.Queue;

public class ShuffleArray {

/*
   https://leetcode.com/problems/shuffle-the-array/submissions/
 */
    public static void main(String[] args) {
        //System.out.println("hello");
        int [] arr = {1,3,5,7,9,2,4,6,8,10};
       int [] resutl = shuffleNew(arr,5);
        ArrayUtils.print(resutl);
        //1,4,2,3,3,2,4,1

    }


    public static int[] shuffle(int[] nums, int n) {
        if (nums.length < 2) {
            return nums;
        }
        int[] result = new int[nums.length];
        for (int i = 0, r = 0; i < n; i++) {
            result[r++] = nums[i];
            result[r++] = nums[n + i];
        }
        return result;
    }


    public static int[] shuffleNew(int[] nums, int n) {
        if (nums.length <= 2) {
            return nums;
        }
        int secondIndex = n;
        Queue<Integer> queue = new LinkedList<>();
        boolean swapFlag = true;
        for (int i = 1; i < nums.length - 1; i++) {
            System.out.println(queue);
            if (i < n) {
                queue.add(nums[i]);
            }
            if (swapFlag) {
                nums[i] = nums[secondIndex++];
                swapFlag = false;
            } else if (!queue.isEmpty()) {
                nums[i] = queue.poll();
                swapFlag = true;
            }
        }
        return nums;
    }
}
