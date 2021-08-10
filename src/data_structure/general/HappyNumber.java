package data_structure.general;


import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/happy-number/
 */
public class HappyNumber {

    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }


    public static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1) {
            int sum = 0;
            while (n != 0) {
                sum += Math.pow(n % 10, 2);
                n /= 10;
            }
            if (set.contains(sum)) {
                return false;
            }
            n = sum;
            set.add(n);
        }
        return true;
    }

    public static boolean isHappy1(int n) {
        //if n = 4, there will be endlessly cycle
        while (n != 4) {
            int sum = 0;
            while (n != 0) {
                sum += Math.pow(n % 10, 2);
                n /= 10;
            }
            n = sum;
            if (n == 1) {
                return true;
            }
        }
        return false;
    }


}
