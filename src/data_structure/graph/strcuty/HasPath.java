package data_structure.graph.strcuty;


import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * Write a method, hasPath, that takes in an object representing the adjacency list of a directed acyclic graph and two nodes (src, dst). The method should return a boolean indicating whether or not
 * there exists a directed path between the source and destination nodes.
 *
 * https://www.structy.net/problems/has-path
 */
public class HasPath {

    public static void main(String[] args) {
        Map<String, List<String>> graph = Map.of(
                "f", List.of("g", "i"),
                "g", List.of("h"),
                "h", List.of(),
                "i", List.of("g", "k"),
                "j", List.of("i"),
                "k", List.of()
        );
        System.out.println(hasPath(graph,"f","k"));
    }




    public static boolean hasPathBFS(Map<String, List<String>> graph, String src, String dst) {
       Queue<String> queue = new LinkedList<>();
       queue.add(src);
       while (!queue.isEmpty()){
           String current = queue.poll();
           if(current.equals(dst)) return true;
           for (String child :graph.get(current)) {
               queue.add(child);
           }
       }
        return false;
    }





    public static boolean hasPath(Map<String, List<String>> graph, String src, String dst) {
        if(src == dst) return true;
        for (String neighbour:graph.get(src)) {
            if (hasPath(graph,neighbour,dst))
                return true;
        }
        return false;
    }
}
