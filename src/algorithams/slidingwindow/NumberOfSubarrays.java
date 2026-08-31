package algorithams.slidingwindow;

/**
 * https://leetcode.com/problems/count-number-of-nice-subarrays/?envType=company&envId=deliveroo&favoriteSlug=deliveroo-all
 */
public class NumberOfSubarrays {

    public static void main(String[] args) {
        int [] nums = {2,2,2,1,2,2,1,2,2,2} ;
        int k = 2;

        System.out.println(numberOfSubarrays(nums,k));
    }

    public static int numberOfSubarrays(int[] nums, int k) {
        int start = 0 , totalCount = 0 , count = 0 ;
        for(int i = 0; i < nums.length;i++){
            if(nums[i]%2 == 1){
                count++;
            }
            if(count == k){
                totalCount++;
            }
            if(count > k){
               while (start <= i && count ==k){
                   count++;
                   if(nums[start++]%2 == 1){
                       count--;
                   }
               }
            }
        }
        return totalCount;
    }
}
