package data_structure.arrays.online;

import java.util.Arrays;

public class ShortestUnsortedContinuous {

    public static void main(String[] args) {
        int [] nums = {1,3,2};
        System.out.println(findUnsortedSubarray(nums));
    }


    public static int findUnsortedSubarray(int[] nums) {
        if(null == nums || nums.length == 0 || nums.length == 1){
            return 0;
        }
          int [] tmp_nums = nums.clone();
          Arrays.sort(tmp_nums);
          int start = -1;
          for(int i=0;i<nums.length;i++){
             if(tmp_nums[i] != nums[i]){
                 start = i;
                 break;
             }
          }
          if (start == -1){
              return 0;
          }
        int end = -1;
        for(int i=nums.length-1;i >= 0;i--){
            if(tmp_nums[i] != nums[i]){
                end = i;
                break;
            }
        }
        return end -start +1;
    }
}
