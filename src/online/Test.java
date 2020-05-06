package online;

public class Test {

    public static void main(String[] args) {
        int[] nums = {0,1,0,1};
        System.out.println(kLengthApart(nums,1));
    }


    public static boolean kLengthApart(int[] nums, int k) {
        int d = 0-k-1;
        for (int i=0;i < nums.length;i++) {
            if(nums[i] == 1){
                int diff = i-d;
                if(diff <= k){
                    return false;
                }
                d=i;
            }
        }
        return true;
    }




}