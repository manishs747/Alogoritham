package data_structure.arrays.online;


import utils.ArrayUtils;

/**
 * https://leetcode.com/problems/sort-colors/description/?envType=daily-question&envId=2024-06-12
 */
public class SortColors {

    public static void main(String[] args) {

        int [] arr = {2,0,2,1,1,0};
        ArrayUtils.print(arr);
        sortColors(arr);
        ArrayUtils.print(arr);

    }

    public static void sortColors(int[] nums) {
        int start = 0 , current = 0, end = nums.length-1;
        while (current < end){
            int cur = nums[current];
            if(cur == 2){
                swap(nums,current,end--);
            }else if(cur == 0){
                swap(nums,current,start++);
            }else {
                current++;
            }
            if(start > current) current = start;
        }
    }

    public static void swap(int [ ] arr , int i , int j){
        int tmp = arr[i];
        arr[i] =  arr[j];
        arr[i] = tmp;
    }
}
