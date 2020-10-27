package data_structure.tree.online;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) {


       int  []piles = {2,4,1,2,7,8};
        System.out.println( maxCoins(piles));
    }


    public void mostVisited(int n, int[] rounds) {


    }


    public static int maxCoins(int[] piles) {
        int result = 0;
        Arrays.sort(piles);
        int start =  0;
        int end = piles.length -1;
        while (start < end){
            end --;
            if(end > 0){
                result +=   piles[end--];
            }
            start++;
        }
        return result;
    }




}
