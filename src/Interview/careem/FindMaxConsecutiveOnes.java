package Interview.careem;
/*
https://leetcode.com/problems/max-consecutive-ones/?envType=company&envId=careem&favoriteSlug=careem-all
 */
public class FindMaxConsecutiveOnes {

    public static void main(String[] args) {
      int [] arr = {1,1,0,1,1,1};
        System.out.println(findMaxConsecutiveOnes(arr));
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, oneCount = 0;
        for (int num: nums){
            oneCount = num == 0 ? 0 : oneCount + 1;
            max = Math.max(max,oneCount);
        }
       return max;
    }


    public static int findMaxConsecutiveOnes2(int[] nums) {
        int max = 0, oneCount = 0;
        for (int num: nums){
             if(num == 1){
                 oneCount++;
             }else{
                 max = Math.max(max,oneCount);
                 oneCount = 0;
             }
        }
        return Math.max(max,oneCount);
    }


}
