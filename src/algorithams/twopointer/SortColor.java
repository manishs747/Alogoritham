package algorithams.twopointer;


import utils.ArrayUtils;

/**
 * https://leetcode.com/problems/sort-colors/description/?envType=company&envId=oracle&favoriteSlug=oracle-thirty-days
 */
public class SortColor {

    public static void main(String[] args) {
        //Input:
       int  nums []  = {2,0,2,1,1,0};
       // Output: [0,0,1,1,2,2]
        sortColors2(nums);
        ArrayUtils.print(nums);
    }


    public  static void sortColors2(int[] nums) {
        int left = 0 ,current =   0, right = nums.length -1 ;

        while (current <= right) {
            if (nums[current] == 1) {
                current++;
            }
            else if (nums[current] == 0) {
                swap(nums,left++,current++);
            }
            else if (nums[current] == 2) {
                swap(nums,right--,current);
            }
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public  static void sortColors1(int[] nums) {
        int zero = 0 ,one = 0,two = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zero++;
            }
            if (nums[i] == 1) {
                one++;
            }
            if (nums[i] == 2) {
                two++;
            }
        }
        int i = 0;
        while (zero > 0) {
            nums[i++] = 0;
            zero--;
        }
        while (one > 0) {
            nums[i++] = 1;
            one--;
        }
        while (two > 0) {
            nums[i++] = 2;
            two--;
        }

    }
}
