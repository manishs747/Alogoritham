package data_structure.graph.strcuty;

import data_structure.graph.Utility;

import java.util.*;

public class UndirectedPath {

    public static void main(String[] args) {
        List<List<String>> edges = List.of(
                List.of("i", "j"),
                List.of("k", "i"),
                List.of("m", "k"),
                List.of("k", "l"),
                List.of("o", "n")
        );
        System.out.println(undirectedPath(edges,"j","m"));
    }

    public static boolean undirectedPath(List<List<String>> edges, String nodeA, String nodeB) {
        Map<String, List<String>> map = Utility.getGraph(edges);
        return undirectedPathHelper(map,nodeA,nodeB,new HashSet<>());
    }

    public static boolean undirectedPathHelper(Map<String, List<String>> map, String nodeA, String nodeB, HashSet<String> visited) {
        if (visited.contains(nodeA)) return false;
        visited.add(nodeA);
        if(nodeA.equals(nodeB) ) return true;
        for (String neighbour:map.get(nodeA)) {
            if(undirectedPathHelper(map,neighbour,nodeB,visited)) return true;
        }
        return false;
    }


}
