package data_structure.arrays;


/**
 * https://leetcode.com/problems/valid-triangle-number/
 */
public class ValidTriangleNumber {

    public static void main(String[] args) {
        int[] arr = {2, 2, 3, 4};
        System.out.println(triangleNumber(arr));
    }


    public static int triangleNumber(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                   if(nums[i] + nums[j] > nums[k] && nums[i] + nums[k] > nums[j] && nums[k] + nums[j] > nums[i]){
                       count++;
                   }
                }
            }
        }
        return count;
    }
}
