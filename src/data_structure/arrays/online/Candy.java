package data_structure.arrays.online;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/candy/solution/
 */
public class Candy {

    public static void main(String[] args) {
        int  [] rating = {1,0,2};
        int  [] rating1 = {0,1,20,9,8,7};//13
        System.out.println(candyBruteForce(rating1));
    }


    /**
     * Each child must have at least one candy.
     * Children with a higher rating get more candies than their neighbors.
     */
    public static int candyBruteForce(int[] ratings) {
         int [] result = new int[ratings.length];
         Arrays.fill(result,1);
         for (int i = 1;i < ratings.length;i++){
             if(ratings[i] < ratings[i-1] & result[i-1]==1){
             /*   while (){

                }*/
             }
             if(ratings[i] > ratings[i-1]){
                 result[i] = result[i-1]+1;
             }

         }
        return  Arrays.stream(result).sum();
    }
}
