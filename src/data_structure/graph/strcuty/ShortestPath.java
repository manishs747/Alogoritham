package data_structure.graph.strcuty;




import java.util.*;

public class ShortestPath {

    public static void main(String[] args) {
        List<List<String>> graph = List.of(
                List.of("w", "x"),
                List.of("x", "y"),
                List.of("z", "y"),
                List.of("z", "v"),
                List.of("w", "v")
        );
        System.out.println(shortestPath3(graph,"w", "z"));
    }




    public static int shortestPath3(List<List<String>> edges, String nodeA, String nodeB) {
        Map<String, List<String>> graph = getGraph(edges);
        Map<String,Integer> countMap = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(nodeA);
        countMap.put(nodeA,0);
        while (!queue.isEmpty()){
            String currentNode = queue.poll();
            int pathCount = countMap.get(currentNode);
            if(currentNode.equals(nodeB)) return pathCount;
            visited.add(currentNode);
            for (String neighbour :graph.get(currentNode)) {
                if(!visited.contains(neighbour)){
                    queue.add(neighbour);
                    countMap.putIfAbsent(neighbour,pathCount+1);

                }
            }
        }
        return -1;
    }


    /**
     *
       Adding to queue only when is not previously added to queue and increasing the count then only
     */
    public static int shortestPath4(List<List<String>> edges, String nodeA, String nodeB) {
        Map<String, List<String>> graph = getGraph(edges);
        Map<String, Integer> countMap = new HashMap<>();
        Deque<String> queue = new LinkedList<>(); // Use Deque for both poll and add operations
        Set<String> visited = new HashSet<>();
        queue.add(nodeA);
        countMap.put(nodeA, 0);
        while (!queue.isEmpty()) {
            String currentNode = queue.poll();
            int pathCount = countMap.get(currentNode);
            if (currentNode.equals(nodeB)) return pathCount;

            for (String neighbor : graph.get(currentNode)) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor); // Mark as visited here
                    countMap.put(neighbor, pathCount + 1);
                }
            }
        }
        return -1;
    }
















    public static int shortestPath(List<List<String>> edges, String nodeA, String nodeB) {
        Map<String, List<String>> graph = getGraph(edges);
        HashSet<String> visited = new HashSet<>();
        Deque<AbstractMap.SimpleEntry<String, Integer>> queue = new ArrayDeque<>(); // Use AbstractMap.SimpleEntry
        queue.add(new AbstractMap.SimpleEntry<>(nodeA, 0));
        while (!queue.isEmpty()) {
            AbstractMap.SimpleEntry<String, Integer> entry = queue.poll();
            String current = entry.getKey();
            int distance = entry.getValue();
            if (current.equals(nodeB)) return distance;
            for (String neighbour : graph.get(current)) {
                if (!visited.contains(neighbour)) {
                    visited.add(current);
                    queue.add(new AbstractMap.SimpleEntry<>(neighbour, distance + 1));
                }
            }
        }
        return -1;
    }

    public static int shortestPath2(List<List<String>> edges, String nodeA, String nodeB) {
        Map<String, List<String>> graph = getGraph(edges);
        Map<String, Integer> countMap = new HashMap<>();
        HashSet<String> visited = new HashSet<>();
        Deque<String> queue = new ArrayDeque<>();
        queue.add(nodeA);
        countMap.put(nodeA,0);
        while (!queue.isEmpty()){
            String current = queue.poll();
            visited.add(current);
            if(current.equals(nodeB)) return countMap.get(current);
            for (String neighbour:graph.get(current)) {
                if(!visited.contains(neighbour)) {
                    queue.add(neighbour);
                    countMap.putIfAbsent(neighbour,countMap.get(current)+1);
                }
            }
        }
        return -1;
    }

    private static Map<String, List<String>> getGraph(List<List<String>> edges) {
        Map<String, List<String>> graph = new HashMap<>();
        for (List<String> edge : edges) {
            String first = edge.get(0);
            String second = edge.get(1);
            graph.computeIfAbsent(first, key -> new ArrayList<>()).add(second);
            graph.computeIfAbsent(second, key -> new ArrayList<>()).add(first);
        }
        return graph;
    }
}
