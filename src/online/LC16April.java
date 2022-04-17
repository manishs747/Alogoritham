package online;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC16April {

    public static void main(String[] args) {
        int arr [] = {-4,-2,1,4,8};
        System.out.println(waysToBuyPensPencils(1000000,1,1));
    }


    public static int findClosestNumber(int[] nums) {
         int closet = nums[0];
         for(int i = 1;i < nums.length;i++){
             int c = nums[i];
             closet = Math.abs(c) == Math.abs(closet) ? Math.max(c,closet) : Math.abs(c) < Math.abs(closet) ? c:closet;
         }
         return closet;
    }


    public static long waysToBuyPensPencils(int total, int cost1, int cost2) {
        long res = 0;
        for (int cnt = 0; cnt * cost1 <= total; ++cnt)
            res += (total - cnt * cost1) / cost2 + 1;
        return res;
    }


}
