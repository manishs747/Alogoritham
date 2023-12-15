package algorithams.binarysearch;

import java.util.Arrays;
import java.util.HashSet;

public class FindDuplicate {

    public static void main(String[] args) {
        int [] nums = {3,1,1,6,1,2,4,9,8,7};
        System.out.println(findDuplicate(nums));
    }


    public static int findDuplicateHashSet(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num:nums) {
           if(set.contains(num)) return num;
           set.add(num);
        }
        return -1;
    }

    public static int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        int left  = 0, right = nums.length-1;
        while (left < right){
           int mid = left + (right - left )/2;
           if((mid != right && nums[mid] == nums[mid+1]) || (mid != left && nums[mid] == nums[mid-1])) return nums[mid];
           if(nums[mid] <= mid){
               right = mid-1;
           }else{
              left = mid+1;
           }
        }
        return -1;
    }
}
