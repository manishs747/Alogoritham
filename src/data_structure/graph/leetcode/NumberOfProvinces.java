package data_structure.graph.leetcode;


import data_structure.graph.Utility;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/number-of-provinces/
 */
public class NumberOfProvinces {

    public static void main(String[] args) {
        int [][]  grid =   {
                {1,1,0},
                {1,1,0},
                {0,0,1}
        };
        System.out.println(findCircleNum(grid));
    }

    public static  int findCircleNum(int[][] isConnected) {
        int count = 0;
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < isConnected.length; i++) { //number of nodes
                if(!visited.contains(i)){
                    count++;
                    dfs(isConnected,visited,i);

                }
        }
       return count;
    }

    private static void dfs(int[][] isConnected,Set<Integer> visited ,int node) {
        visited.add(node);
        for (int i = 0; i < isConnected.length ; i++) {
            if(isConnected[node][i] == 1 && !visited.contains(i) ){
                dfs(isConnected,visited,i);
            }
        }
    }

    /***************************************************************************************************/

    public static int findCircleNum2(int[][] isConnected) {
        int n = isConnected.length;
        int numberOfComponents = 0;
        boolean[] visit = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                numberOfComponents++;
                dfs(i, isConnected, visit);
            }
        }

        return numberOfComponents;
    }

    public static void dfs(int node, int[][] isConnected, boolean[] visit) {
        visit[node] = true;
        for (int i = 0; i < isConnected.length; i++) {
            if (isConnected[node][i] == 1 && !visit[i]) {
                dfs(i, isConnected, visit);
            }
        }
    }


    /***********************************************************************************************************/
    public static  int findCircleNum3(int[][] isConnected) {
        Map<Integer, List<Integer>> graph = Utility.getGraph(isConnected);
        System.out.println(graph);
        Set<Integer> visited = new HashSet<>();
        int count = 0;
        for (int key:graph.keySet()) {
            if(dfs(graph,visited,key))
                count++;
        }
        return count;
    }

    private static boolean dfs(Map<Integer, List<Integer>> graph, Set<Integer> visited, int key) {
      if(!visited.add(key)) return false;
      for (int neighbour:graph.get(key))
          dfs(graph,visited,neighbour);
      return true;
    }
}
