package data_structure.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Utility {


    public static  Map<String, List<String>> getSampleGraph(){
        Map<String, List<String>> graph = Map.of(
                "f", List.of("g", "i"),
                "g", List.of("h"),
                "h", List.of(),
                "i", List.of("g", "k"),
                "j", List.of("i"),
                "k", List.of()
        );
        return graph;
    }


    public static Map<String, List<String>> getGraph(List<List<String>> edges) {
        Map<String, List<String>> graph = new HashMap<>();
        for (List<String> edge : edges ) {
            graph.computeIfAbsent(edge.get(0), key -> new ArrayList<>()).add(edge.get(1));
            graph.computeIfAbsent(edge.get(1), key -> new ArrayList<>()).add(edge.get(0));
        }
        return graph;
    }

    public static Map<Integer, List<Integer>> getGraphBiDirectional(int [][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int [] edge : edges ) {
            graph.computeIfAbsent(edge[0], key -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], key -> new ArrayList<>()).add(edge[0]);
        }
        return graph;
    }

    public static Map<Integer, List<Integer>> getGraph(int [][] grid) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i <grid.length ; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 0) continue;
                graph.computeIfAbsent(i, key -> new ArrayList<>()).add(j);
            }
        }
        return graph;
    }
}
