package data_structure.tree.online;

import java.util.HashSet;

public class Cobtest {

    public static void main(String[] args) {
        int [] nums = {1,-1,-2,4,-7,3};//
        System.out.println(maxResult(nums,2));
    }


    public static int maxResult(int[] nums, int k) {

///pathSum(B, i, k) = B[i] + max(pathSum(B, i+1, k)

        return maxResultHelper(nums,nums.length-1,k,nums[nums.length-1]);
    }


    public static int maxResultHelper(int[] nums,int len, int k ,int sum) {
        if(len -1 < k){
          return   sum + getMax(nums,len);
        }
        int i = 1;
        int maxSum = 0;
        while(k -i > 0){
            maxSum = Math.max(maxSum,4);
        }
        return sum +maxResultHelper(nums,len-1,k,sum);
    }

    public static int getMax(int[] nums,int len){
        int max = 0;
        for (int i =0;i < len-1;i++) {

        }
        return max;
    }







    public boolean canJump(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = lastPos; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }





    public static int maximumUniqueSubarray(int[] nums) {
        int i = 0, j = 1;
        HashSet<Integer> integers = new HashSet<>();
        integers.add(nums[0]);
        int sum = nums[0];
        int max = sum;
        while (i < nums.length - 1 && j < nums.length) {
            if (!integers.contains(nums[j])) {
                sum = sum + nums[j];
                max = Math.max(sum, max);
                integers.add(nums[j++]);
            }
            else {
                sum -= nums[i];
                integers.remove(nums[i++]);
            }
        }
        return max;
    }




    static int maxSum(int arr[], int n)
    {
        int max_sum = 0;
        for (int i = 0; i < arr.length; i++)
            max_sum += arr[i];
        int window_sum = max_sum;
        for (int i = arr.length; i < n; i++) {
            window_sum += arr[i] - arr[i - arr.length];
            max_sum = Math.max(max_sum, window_sum);
        }
        return max_sum;
    }


}
