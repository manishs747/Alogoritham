package data_structure.graph.leetcode;

import data_structure.graph.Utility;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FindPathExistsGraph {

    public static void main(String[] args) {
       int [][] edges = {{0,1},{0,2},{3,5},{5,4},{4,3}};
       int source = 0, destination = 5;
       System.out.println(validPath(6,edges,source,destination));

    }



    public static boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> graph = Utility.getGraphBiDirectional(edges);
        Set<Integer> visited = new HashSet<>();
        return validPathhelper(graph,visited,source,destination);
    }

    private static boolean validPathhelper(Map<Integer, List<Integer>> graph, Set<Integer> visited, int source, int destination) {
        if(source == destination) return true;
        if(visited.contains(source)) return false;
        visited.add(source);
        for (int neighbour:graph.get(source)) {
            if(validPathhelper(graph,visited,neighbour,destination)) return true;
        }
        return false;
    }

}
