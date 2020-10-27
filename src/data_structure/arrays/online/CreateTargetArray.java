package data_structure.arrays.online;

import data_structure.arrays.Utility;

public class CreateTargetArray {

    public static void main(String[] args) {
       int []  nums = {1,2,3,4,0};
       int [] index = {0,1,2,3,0};
       Utility.print(createTargetArray(nums,index));
       //Output: [0,4,1,3,2]
    }


    public static int[] createTargetArray(int[] nums, int[] index) {
        int[] target = new int[index.length];
        for(int i = 0;i<index.length;i++){
            int idx = index[i];
            int prev = target[idx];
            for(int j=idx+1;j<index.length;j++ ){
                int tmp = target[j];
                target[j] = prev;
                prev = tmp;
            }
            target[idx] = nums[i];
        }
        return target;
    }
}
