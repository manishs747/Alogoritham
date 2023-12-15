package data_structure.arrays.online;

import utils.ArrayUtils;

import java.util.Arrays;

public class RemoveElement {

    public static void main(String[] args) {
       int [] nums = {3,2,2,3};
       int  val = 3;
        System.out.println(removeElement(nums,val));
        ArrayUtils.print(nums);
    }


    public static int removeElement(int[] nums, int val) {
        int startPointer = 0;
        for(int num:nums){
            if(num != val)
                nums[startPointer++] = num;
        }
        return startPointer;
    }
}
