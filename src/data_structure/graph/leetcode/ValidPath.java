package data_structure.graph.leetcode;


import data_structure.graph.Node;

import java.util.*;

/**
 * https://leetcode.com/problems/find-if-path-exists-in-graph/description/
 */
public class ValidPath {


    public static void main(String[] args) {
       int  n = 3, source = 0, destination = 3;
       int [][] edges = {{0,1},{0,2},{3,5},{5,4},{4,3}};
       System.out.println(validPath(n,edges,source,destination));
    }

    public static boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, Set<Integer>> graph = getGraph(edges);
        return validPathDFS(graph,source,destination,new HashSet<>());
    }

    public static boolean validPathDFS(Map<Integer, Set<Integer>> graph, int source, int destination,HashSet<Integer> visited) {
        if(visited.contains(source)) return false;
        visited.add(source);
         if(source == destination) return true;
        for (int neigbour :graph.get(source)) {
           if (validPathDFS(graph,neigbour,destination,visited)) return true;
        }
        return false;
    }


    private static Map<Integer, Set<Integer>> getGraph(int[][] edges) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int [] edge : edges ) {
            extracted(map, edge[0], edge[1]);
            extracted(map,  edge[1],edge[0]);
        }
        return map;
    }

    private static void extracted(Map<Integer, Set<Integer>> map, int first, int second) {
        Set<Integer> set = map.getOrDefault(first,new HashSet<>());
        set.add(second);
        map.put(first, set);
    }
}
