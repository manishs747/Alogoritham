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
        System.out.println(largestComponent(graph));
    }

    public static int largestComponent(Map<Integer, List<Integer>> graph) {
        int max = 0;
        Set<Integer> visited = new HashSet<>();
        for (int current : graph.keySet()) {
            if (!visited.contains(current)) {
                max = Math.max(max, dfs(graph, current, visited));
            }
        }
        return max;
    }

    private static int dfs(Map<Integer, List<Integer>> graph, int current, Set<Integer> visited) {
        if (visited.contains(current)) return 0;
        visited.add(current);
        int count = 1; // Count the current node
        for (int neighbor : graph.get(current)) {
            count += dfs(graph, neighbor, visited);
        }
        return count;
    }


    /**************************************************************************************/
    public static int largestComponent2(Map<Integer, List<Integer>> graph) {
        int max = 0;
        HashSet<Integer> visited = new HashSet<>();
        for (int current : graph.keySet()) {
            if(!visited.contains(current)){
                max = Math.max(max, dfs2(graph,current,visited,0)) ;
            }
        }
        return max;
    }

    private static int dfs2(Map<Integer, List<Integer>> graph, int current, HashSet<Integer> visited, int count) {
        if(visited.contains(current)) return  0;
        visited.add(current);
        count++;
        for (int neighbor :graph.get(current)){
            if(!visited.contains(neighbor )){
                count = dfs2(graph,neighbor ,visited,count);
            }
        }
        return count;
    }

}
