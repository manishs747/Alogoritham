package data_structure.arrays.search;

public class SecondLargest {

    public static void main(String[] args) {
        int[] nums = {5,1};
        System.out.println(secondLargest(nums));
    }

    public static int secondLargest(int[] nums) {
        int first = 0;
        int second = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= first) {
                second = first;
                first = nums[i];
            } else if (nums[i] > second && nums[i] != first) {
                second = nums[i];
            }
        }
        System.out.println("First:" + first + " second:" + second);
        return second;
    }
}
