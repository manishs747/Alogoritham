package data_structure.arrays.online;


import utils.ArrayUtils;

/**
 * https://leetcode.com/problems/move-zeroes/
 */
public class MoveZeroes {

    public static void main(String[] args) {
        int arr[] = {0, 1, 0, 3, 12};
        moveZeroes2(arr);
        ArrayUtils.print(arr);
    }


    public static void moveZeroes(int[] nums) {
        int zp = 0;
        for (int cp = 0; cp < nums.length; cp++) {
            if (nums[cp] != 0) {
                nums[zp++] = nums[cp];
            }
        }
        for (; zp < nums.length; zp++) {
            nums[zp] = 0;
        }
    }


    public static void moveZeroes2(int[] nums) {
        for (int cp = 0,nzp = 0; cp < nums.length; cp++) {
            if (nums[cp] != 0) {
                swap(nums,nzp++,cp);
            }
        }
    }

    public static void swap(int[] nums,int a,int b){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }


}
