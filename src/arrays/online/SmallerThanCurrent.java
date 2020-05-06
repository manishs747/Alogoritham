package arrays.online;

import arrays.Utility;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/
 */
public class SmallerThanCurrent {


    public static void main(String[] args) {
       int[] nums = {0,1,0,3,12};
       Utility.print(nums);
       moveZeroes(nums);
       Utility.print(nums);
    }


    public int findNumbers(int[] nums) {
        int r = 0;
        for (int num : nums) {
           if( countDigit(num)%2 == 0){
               r++;
           }
        }
        return r;
    }



    static int countDigit(long n)
    {
        int count = 0;
        while (n != 0) {
            n = n / 10;
            ++count;
        }
        return count;
    }

    public static void moveZeroes(int[] nums) {
        int zp = 0;
        for (int cp = 0; cp < nums.length; cp++) {
            int current = nums[cp];
            if (current != 0) {
                nums[zp++] = current;
            }
        }
        for (; zp < nums.length; zp++) {
            nums[zp] = 0;
        }
    }


    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int result[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int num : nums) {
                if (num < nums[i]) {
                    count++;
                }
            }
            result[i] = count;
        }
        return result;
    }



    public static List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = i+1 ;j< nums.length;j++) {
                if (nums[j] < nums[i]) {
                    count++;
                }
            }
            result.add(count);
        }
        return result;
    }
}
