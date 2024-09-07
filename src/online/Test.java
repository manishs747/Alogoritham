package online;

import java.util.*;

public class Test {

    public static void main(String[] args) {
        int n = 3;
        int [][] edges = {{0,1},{1,2}};
        //doSomeThing();

    }


    public static List<String> getStatusMessage(List<Integer> timestamps,List<String> messages,int k){



    return null;
    }





























    public static int findChampion(int[][] grid) {
        int [] result = new int[grid.length];
        for (int i = 0; i <grid.length ; i++) {
            for (int j = 0; j < grid[i].length ; j++) {
                if(i!= j && grid[i][j] == 1){
                    result[i]++;
                }
            }
        }
        int max = 0;
        for (int i = 0; i < grid.length ; i++) {
            if(result[i] > result[max]) max = i;
        }
        return max;
    }







}