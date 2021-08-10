package dynamic_programming.leetocde;

/**
 * https://leetcode.com/problems/get-maximum-in-generated-array/
 */
public class MaximumGenerated {

    public static void main(String[] args) {
        System.out.println(getMaximumGenerated(4)); //3
    }


    public static int getMaximumGenerated(int n) {
        if(n < 2){
            return n;
        }
        int result[] = new int[n + 1];
        int max = 0;
        result[1] = 1;
        for (int i = 2; i <= n; i++) {
            result[i] = i % 2 == 0 ? result[i / 2] : result[i / 2] + result[i / 2 + 1];
            max = Math.max(max,result[i]);
        }
        return max;
    }
}
