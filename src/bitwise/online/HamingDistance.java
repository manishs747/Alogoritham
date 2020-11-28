package bitwise.online;

import bitwise.BitUtil;

/*
https://leetcode.com/problems/hamming-distance/
 */
public class HamingDistance {

    public static void main(String[] args) {
        System.out.println(hammingDistance(1,4));
    }


    public static int hammingDistance(int x, int y) {
        return BitUtil.getSetBit(x^y);
    }
}
