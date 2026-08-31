package algorithams.prefixsum;

public class SubarraySum {

    public static void main(String[] args) {
        int [] nums = {1,2,3};
        int k = 3;
        System.out.println(subarraySum(nums,3));
    }

    public static int subarraySum(int[] nums, int k) {
        int res = 0 , sum = 0 , start = 0 , mid = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum > k){
                sum -= nums[start++];
                mid = start;
            }

            if(sum == k){
                while (mid < start &&nums[mid] != 0)
                    mid++;
                res += mid-start +1;
            }
        }
        return res;
    }
}
