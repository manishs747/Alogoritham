package data_structure.arrays.online;


import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/contiguous-array/description/?envType=daily-question&envId=2024-03-16
 */
public class ContiguousArray {

    public static void main(String[] args) {
        int [] arr = {0,1,1,0,1,1,1,0};
        System.out.println(findMaxLength(arr));//4

    }




    public static int findMaxLength(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int max = 0 ,  count = 0;
        for (int i = 0; i < nums.length ; i++) {
            count += nums[i] == 1 ? 1 : -1;
            if(map.containsKey(count)){
                max = Math.max(max,i-map.get(count));
            }else {
                map.put(count,i);
            }
        }
        return max;
    }





}
