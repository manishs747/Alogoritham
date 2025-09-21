package data_structure.arrays.online;

public class ProductOfArray {


    public static void main(String[] args) {

    }


    public int[] productExceptSelf(int[] nums) {
        int zeroCount = 0;
        for(int num : nums){
            if(num == 0) zeroCount++;
        }
        if(zeroCount > 1) return new int[nums.length];
        int total = 1;
        for (int num:nums) {
            if(num ==  0) continue;
            total *= num;
        }
        int [] result = new int[nums.length];
        for (int i = 0; i < nums.length ; i++) {
            if(zeroCount == 1){
                if(nums[i] == 0) {
                    result[i] = total;
                } else{
                    result[i] = 0;
                }

            }else{
                result[i] = total/nums[i];
            }
        }
        return result;
    }



}
