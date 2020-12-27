package data_structure.arrays.online;


/*
https://leetcode.com/problems/increasing-triplet-subsequence/
 */
public class TripletSequence {

    public static void main(String[] args) {
        int [] nums = {2,2,2,1,5,0,4};
        System.out.println(increasingTriplet(nums));
    }


    public static boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n < first) {
                first = n;
            } else if (n > first && n < second) {
                second = n;
            } else if (n > second && n > first) {
                return true;
            }
        }
        return false;
    }


    public static boolean increasingTripletOther(int[] nums) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        for(int n : nums) {
            if(n <= first)
                first = n;
            else if(n <= second)
                second = n;
            else{
                return true;
            }
        }
        return false;
    }
}
