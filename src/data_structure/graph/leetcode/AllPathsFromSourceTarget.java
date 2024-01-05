package data_structure.graph.leetcode;


import java.util.*;

/*
  https://leetcode.com/problems/all-paths-from-source-to-target/description/
 */
public class AllPathsFromSourceTarget {
   static List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {
      /*
        Input: graph = [[1,2],[3],[3],[]]
        Output: [[0,1,3],[0,2,3]]
       */
        int [][] graph = {{1,2},{3},{3},{}};
        System.out.println(allPathsSourceTarget(graph));
    }

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<Integer> path = new ArrayList<>();
        path.add(0);
        allPathsSourceTargetHelper(graph,path);
        return result;
    }

    private static void allPathsSourceTargetHelper(int[][] graph, List<Integer> path) {
        int source = path.get(path.size()-1);
        if(source == graph.length-1){
            result.add(new ArrayList<>(path));
            return;
        }
        for (int neighbour : graph[source]) {
            path.add(neighbour);
            allPathsSourceTargetHelper(graph,path);
            path.remove(path.size()-1);
        }
    }
}
