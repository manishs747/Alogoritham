package dynamic_programming.leetocde;

import utils.ArrayUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DeleteEarn {

    private static HashMap<Integer, Integer> points = new HashMap<>();
    private static int [] memo;


    public static void main(String[] args) {
       int [] nums = {2,2,3,3,3,4};  //9
        System.out.println(deleteAndEarn(nums));
    }

    public static int deleteAndEarn(int[] nums) {
         for (int num : nums){
             int newVal = points.getOrDefault(num,0)+num;
             points.put(num,newVal);
         }
        int[] keys = points.keySet().stream().sorted().mapToInt(Integer::intValue).toArray();
         ArrayUtils.print(keys);
        memo = new int[keys.length];
        Arrays.fill(memo,-1);
        return deleteAndEarn(keys,0);
    }

    public  static int deleteAndEarn(int[] keys, int index) {
        if(index >= keys.length) return 0;
        if(memo[index] != -1) return memo[index];

        int res = points.get(keys[index]);
        if(index + 1 < keys.length && keys[index] + 1 == keys[index+1]){
            res += deleteAndEarn(keys,index+2);
        }else{
            res += deleteAndEarn(keys,index+1);
        }
        res = Math.max(res,deleteAndEarn(keys,index+1));
        memo[index] = res;
        return res;
    }
}
