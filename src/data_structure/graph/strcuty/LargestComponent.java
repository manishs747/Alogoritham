package data_structure.graph.strcuty;

import java.util.*;


public class LargestComponent {

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
        System.out.println(largestComponent3(graph));
    }


    public static int largestComponent3(Map<Integer, List<Integer>> graph) {
        int max = 0;
        Set<Integer> visted = new HashSet<>();
        for (int key:graph.keySet())
            max = Math.max(max,dfs3(graph,visted,key)) ;
        return max;
    }

    private static int dfs3(Map<Integer, List<Integer>> graph, Set<Integer> visted, int key) {
        if(visted.contains(key)) return 0;
        visted.add(key);
        int count = 1;
        for (int neighbour:graph.get(key))
            count += dfs3(graph,visted,neighbour);
        return count;
    }









}
