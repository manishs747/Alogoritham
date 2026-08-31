package data_structure.arrays.sort;

import utils.ArrayUtils;

import java.util.Arrays;

public class SortColor {

    public static void main(String[] args) {
        int [] nums = {2,0,2,1,1,0};
        //Output: [0,0,1,1,2,2]
        sortColors(nums);
        ArrayUtils.print(nums);
    }


    public static void sortColors(int[] nums) {
        int start = 0 , cur = 0 , end = nums.length-1;
        while (cur <= end){
            int num = nums[cur];
            if(num == 0){
                swap(nums,start++,cur++);
            } else if (num == 2) {
                swap(nums,end--,cur);
            }else {
                cur++;
            }
        }
    }

    public static void swap(int [] arr , int a , int b){
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }



}
