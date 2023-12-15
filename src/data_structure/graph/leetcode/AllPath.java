package data_structure.graph.leetcode;

import java.util.*;


/***
 * https://leetcode.com/problems/all-paths-from-source-to-target/description/
 */
public class AllPath {

    static List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {
       int [][] graph = {{4,3,1},{3,2,4},{3},{4},{}};
        System.out.println(allPathsSourceTarget(graph));
    }

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<Integer> path = new ArrayList<>();
        path.add(0);
        allPathsSourceTargetHelper(graph,0,path);
        return result;
    }

    public static void allPathsSourceTargetHelper(int[][] graph, int source,List<Integer> path) {
        if (source == graph.length-1) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int neighbour : graph[source]) {
            path.add(neighbour);
            allPathsSourceTargetHelper(graph,neighbour,path);
            path.remove(path.size()-1);
        }
    }

}
