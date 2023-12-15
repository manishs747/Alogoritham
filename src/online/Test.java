package online;

import java.util.*;

public class Test {

    public static void main(String[] args) {
        int n = 3;
        int [][] edges = {{0,1},{1,2}};
        System.out.println(findChampion(n,edges));
    }


    public long maximumScoreAfterOperations(int[][] edges, int[] values) {
      return -1;
    }










    //SImple Java Solution using set

    public  static int findChampion(int n, int[][] edges) {
          Set<Integer> set = new HashSet<>();
          for (int i = 0; i < n ; i++) set.add(i);
          for (int [] edge:edges) set.remove(edge[1]);
          if(set.size() > 1) return -1;
          return set.iterator().next();
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