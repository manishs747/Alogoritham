package data_structure.arrays.online;
/*
   https://leetcode.com/problems/find-peak-element/
   solution: https://www.youtube.com/watch?v=CFgUQUL7j_c

A peak element is an element that is greater than its neighbors.
Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.
The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
You may imagine that nums[-1] = nums[n] = -∞.

Example 1:

Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.
Example 2:

Input: nums = [1,2,1,3,5,6,4]
Output: 1 or 5
Explanation: Your function can return either index number 1 where the peak element is 2, or index number 5 where the peak element is 6.

 */
public class PeakElement {

    public static void main(String[] args) {

    }

    public int findPeakElement(int[] nums) {

            return 0;
    }





    /*
    https://leetcode.com/problems/valid-mountain-array/
     */
    public boolean validMountainArray(int[] arr) {
        if (arr.length < 3) {
            return false;
        }
        if(arr[1] < arr[0]){
            return false;
        }
        boolean asc = true;
        int prev = arr[1];
        boolean change = false;
        for (int i = 1;i< arr.length;i++){
            int cur = arr[i];
            if(prev == cur || (!asc && cur > prev)){
                return false;
            }
            if(asc && cur < prev){
                asc = false;
                change =  true;
            }
            prev = cur;
        }
        return (!change || asc)?false:true;
    }


}
