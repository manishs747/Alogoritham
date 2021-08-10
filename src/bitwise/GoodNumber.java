package bitwise;

import java.math.BigInteger;

/**
 * https://leetcode.com/problems/count-good-numbers/
 */
public class GoodNumber {


    public static void main(String[] args) {
       System.out.println(Math.pow(2,5));
        System.out.println(modPow(2,5));
        //System.out.println(countGoodNumbers(50));
    }


    public static int countGoodNumbers(long n) {
        BigInteger modulas = new BigInteger(String.valueOf(1000000007));
        BigInteger five = new BigInteger("5").modPow(new BigInteger(String.valueOf(n + 1 >> 1)), modulas);
        BigInteger four = new BigInteger("4").modPow(new BigInteger(String.valueOf(n >> 1)), modulas);
        return Integer.parseInt(five.multiply(four).mod(modulas).toString());
    }


    public int countGoodNumbersOther(long n) {
        return (int) (modPow(5, (n + 1) / 2) * modPow(4, n / 2) % 1000000007);
    }

    static long  modPow(long x, long y) {
        if (y == 0)
            return 1;
        long p = modPow(x, y / 2);
        return p * p * (y % 2 > 0 ? x : 1) % 1000000007;
    }


}
