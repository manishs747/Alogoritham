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
       System.out.println(validPathBFS(n,edges,source,destination));
    }

    /********************************************BFS********************************************************************************/

    public static boolean validPathBFS(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> graph = getGraph(edges);
        return validPathBFSHelper(graph,source,destination,new HashSet<>());
    }

    private static boolean validPathBFSHelper(Map<Integer, List<Integer>> graph, int source, int destination, HashSet<Integer> visited) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(source);
        while (!queue.isEmpty()){
            int current = queue.remove();
            if (current == destination) return true;
            if(visited.contains(current)) continue;
            visited.add(current);
            for (int neighbour : graph.get(current)) {
                queue.add(neighbour);
            }
        }
        return false;
    }


    /********************************************DFS********************************************************************************/

    public static boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> graph = getGraph(edges);
        return validPathDFS(graph,source,destination,new HashSet<>());
    }

    public static boolean validPathDFS(Map<Integer, List<Integer>> graph, int source, int destination,HashSet<Integer> visited) {
        if (visited.contains(source)) return false;
        visited.add(source);
        if (source == destination) return true;
        for (int neighbour : graph.get(source)) {
            if (validPathDFS(graph, neighbour, destination, visited)) return true;
        }
        return false;
    }

    /********************************************GET GRAPH********************************************************************************/

    private static Map<Integer, List<Integer>> getGraph(int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int [] edge : edges ) {
            extracted(map, edge[0], edge[1]);
            extracted(map,  edge[1],edge[0]);
        }
        return map;
    }

    private static void extracted(Map<Integer, List<Integer>> map, int first, int second) {
        List<Integer> set = map.getOrDefault(first,new ArrayList<>());
        set.add(second);
        map.put(first, set);
    }
}
