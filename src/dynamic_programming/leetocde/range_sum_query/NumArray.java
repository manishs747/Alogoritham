package dynamic_programming.leetocde.range_sum_query;

import java.util.HashMap;
import java.util.Map;

public class NumArray {

    private static int[] data;
    private static Map<String,Integer> memo =  new HashMap<>();

    public static void main(String[] args) {
        data = new int[]{-2, 0, 3, -5, 2, -1};
        int [][] query = {{0, 2}, {2, 5}, {0, 5}};
        for (int [] arr:query) {
            System.out.println(sumRange(arr[0],arr[1]));
        }
    }


    public NumArray(int[] nums) {
      data = nums;
    }

    public static int sumRange(int left, int right) {
        int sum = 0;
        if(left > right){
            return 0;
        }
        String key = left+"_"+right;
        if(memo.containsKey(key)){
            return memo.get(key);
        }
        for (int k = left; k <= right; k++) {
            sum += data[k];
        }
        sum = data[left] + sumRange(++left,right);
        memo.put(key,sum);
        return sum;
    }

}
