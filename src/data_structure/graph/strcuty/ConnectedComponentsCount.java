package data_structure.graph.strcuty;

import java.util.*;

public class ConnectedComponentsCount {

    public static void main(String[] args) {

        Map<Integer, List<Integer>> graph = Map.of(
                0, List.of(8, 1, 5),
                1, List.of(0),
                5, List.of(0, 8),
                8, List.of(0, 5),
                2, List.of(3, 4),
                3, List.of(2, 4),
                4, List.of(3, 2)
        );
        System.out.println(connectedComponentsCount3(graph));
    }


      /**************************************************************************************************/

    public static int connectedComponentsCount3(Map<Integer, List<Integer>> graph) {
        int count = 0;
        Set<Integer> visted = new HashSet<>();
        for (int key:graph.keySet()) {
           if(!visted.contains(key)){
               count++;
               dfs3(graph,visted,key);
           }
        }
        return count;
    }

    private static void dfs3(Map<Integer, List<Integer>> graph, Set<Integer> visted, int key) {
        if(visted.contains(key)) return;
        visted.add(key);
        for (int neighbour:graph.get(key)) {
            dfs3(graph,visted,neighbour);
        }
    }


    /**************************************************************************************************/

    public static int connectedComponentsCount(Map<Integer, List<Integer>> graph) {
        Set<Integer> visited = new HashSet<>();
        int count = 0;
        for (int neighbor :graph.keySet())
            if(dfs(graph,neighbor ,visited))
                count++;
        return count;
    }

    private static boolean dfs(Map<Integer, List<Integer>> graph, int current, Set<Integer> visited) {
        if(visited.contains(current)) return false;
        visited.add(current);
        for (int neighbor :graph.get(current))
                dfs(graph,neighbor ,visited);
        return true;
    }

}
