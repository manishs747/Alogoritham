package data_structure.arrays.online;


import java.util.Arrays;

/**
 * https://leetcode.com/problems/matchsticks-to-square/
 */
public class MatchStick {

    public static void main(String[] args) {
        int arr[] = {3,3,3,3,4};
        System.out.println(makesquare(arr));
    }



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
