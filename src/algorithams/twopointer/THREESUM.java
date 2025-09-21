package algorithams.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class THREESUM {

    public static void main(String[] args) {

      int   nums []  = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));

    }


    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length-2 ; i++) {
            if(nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int l = i +1, r = nums.length-1;
            while (l<r){
                int sum = nums[i] + nums[l] + nums[r];
               if(sum == 0 ) {
                   result.add(Arrays.asList(nums[i],nums[l],nums[r])) ;
                   break;
               }
               if(sum < 0){
                   l++;
               }else {
                   r--;
               }
            }
        }
        return result;
    }
}
