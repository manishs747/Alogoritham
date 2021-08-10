package dynamic_programming.leetocde;


import utils.ArrayUtils;

/**
 * https://leetcode.com/problems/counting-bits/
 */
public class CountingBits {


    public static void main(String[] args) {
        ArrayUtils.print(countBits(5));
    }


    public static int[] countBits(int n) {
         int result [] = new int[n+1];
         int [] memo = new int[n+1];
         for (int i = n;i >= 0;i--){
             result[i] = countSetBits(i,memo);
         }
        return result;
    }

    /* Function to get no of set bits in binary representation of positive integer n */
    //  n * 1 = gives 1 if last bit is 1 else 0;
    static int countSetBits(int n,int [] memo)
    {
       int nc = n;
        int count = 0;
        while (n > 0 && memo[n] == 0)
        {
            count += n & 1;
            n =  n >> 1;
        }
        memo[nc] = count+memo[n];
        return memo[nc];
    }

    static int countSetBitsRec(int n,int [] memo)
    {
        System.out.println(n);
        if(n == 0){
            return 0;
        }
        if(memo[n]  != 0){
            return memo[n];
        }

        return memo[n] = (n & 1) + countSetBitsRec(n >> 1,memo);
    }


}
