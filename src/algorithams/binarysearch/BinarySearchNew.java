package algorithams.binarysearch;


/**
 * https://leetcode.com/problems/binary-search/
 */
public class BinarySearchNew {

    public static void main(String[] args) {
       int [] nums = {-1,0,3,5,9,12};
       int target = 9;
       System.out.println(searchIterative(nums,target));
    }


    public static int searchIterative(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        while (left < right){
            int mid = left + (right-left)/2;
            if(nums[mid] == target) return mid;
            if(target < nums[mid]){
                right = mid -1;
            }else {
                left = mid +1;
            }
        }
        return -1;
    }

    public static int search(int[] nums, int target) {
        return search(nums,target,0,nums.length-1);
    }

    public static int search(int[] nums, int target,int start ,int end) {
      if(start > end) return -1;
      int mid = start + (end-start)/2;
      if(nums[mid] == target) return mid;
      return  target < nums[mid]  ? search(nums,target,start,mid-1) :search(nums,target,mid+1,end);
    }


}
