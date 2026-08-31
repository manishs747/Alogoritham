package algorithams.prefixsum;


/**
 * https://leetcode.com/problems/count-number-of-nice-subarrays/
 */
public class NumberOfSubarrays {

    public static void main(String[] args) {
        int [] nums = {2,2,2,1,2,2,1,2,2,2};
        System.out.println(numberOfSubarrays(nums,2));

    }

    public static int numberOfSubarrays(int[] nums, int k) {
        int res = 0, odd = 0;
        int l = 0,m = 0;
        for (int i = 0; i < nums.length ; i++) {
            if(nums[i] % 2 == 1) odd++;
            //count greater than k
            while (odd > k){
                if(nums[l++] % 2 == 1)
                    odd--;
                m = l;
            }
            if(odd == k){
                while (nums[m] % 2 != 1){
                    m++;
                }
                res += m-l+1;
            }
        }
        return res;
    }
}
