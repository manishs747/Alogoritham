package dynamic_programming.leetocde;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/count-sorted-vowel-strings/
 */
public class CountSortedVowel {

    public static void main(String[] args) {
        System.out.println(countVowelStrings(1));
    }


    /**
     * https://leetcode.com/problems/count-sorted-vowel-strings/
     */
    public static int countVowelStrings(int n) {


        return 0;
    }






        /**
         * https://leetcode.com/problems/matchsticks-to-square/
         */
        public static boolean makesquare(int[] matchsticks) {
            if(null == matchsticks || matchsticks.length < 4){
                return false;
            }
            int sum = Arrays.stream(matchsticks).sum();
            if (sum % 4 != 0) {
                return false;
            }
            int side = sum/4;

            return false;
        }

}
