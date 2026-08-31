package data_structure.arrays.online;

import utils.ArrayUtils;

public class SortedSquares {


    public static void main(String[] args) {
        int  nums [] = {-4,-1,0,3,10};
        //Output: [0,1,9,16,100]
        //System.out.println(sortedSquares(nums));
        ArrayUtils.print(sortedSquares(nums));
    }



    public static int[] sortedSquares(int[] nums) {
        int [] res = new int[nums.length];
        int l = 0 , r = nums.length-1 ;
        for(int i = nums.length-1;i >= 0;i--){
            if(nums[l]*nums[l] >= nums[r]*nums[r]){
                 res[i] = nums[l]*nums[l];
                 l++;
            }else{
                res[i] = nums[r]*nums[r];
                r--;
            }
        }
        return res;
    }
}
