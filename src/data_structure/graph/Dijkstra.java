package data_structure.graph;

import java.util.*;

/*

Start at the source node.
Keep a distance table:
distance[node] = shortest known distance from source.
Initialize all distances as infinity (∞) except source = 0.
Use a priority queue (min-heap) to always expand the node with the smallest distance so far.
For each neighbor, check:
newDistance = currentDistance + edgeWeight.
If newDistance < distance[neighbor], update it.
Repeat until all nodes are processed or destination found.

 */
public class Dijkstra {

    public static void main(String[] args) {
        Dijkstra g = new Dijkstra();
        g.addEdge("A", "B", 5);
        g.addEdge("A", "C", 2);
        g.addEdge("B", "D", 1);
        g.addEdge("C", "D", 7);

        System.out.println("Shortest path A→D: " + g.shortestPath("A", "D"));
        // Expected: 6
    }

    static class Edge {
        String target;
        int weight;
        Edge(String target, int weight) {
            this.target = target;
            this.weight = weight;
        }
    }

    Map<String, List<Edge>> adj = new HashMap<>();
    public void addEdge(String src, String dest, int weight) {
        adj.computeIfAbsent(src, k -> new ArrayList<>()).add(new Edge(dest, weight));
    }

    public int shortestPath(String source, String dest) {
        Map<String,Integer> proceeseddistMap = new HashMap<>();
        for(String key:adj.keySet()){
         proceeseddistMap.put(key,Integer.MAX_VALUE);
        }
        proceeseddistMap.put(source,0);


        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        pq.add(new AbstractMap.SimpleEntry<>(source, 0));
        while (!pq.isEmpty()) {
            Map.Entry<String, Integer> curr = pq.poll();
            String node = curr.getKey();
            int curDis = curr.getValue();
            if(node.equals(dest)) return curDis; // stop early
            if(curDis > proceeseddistMap.get(node)) continue; //skip outdated
            if (!adj.containsKey(node)) continue; // no path If a node has no outgoing edges, it won’t appear as a key in adj.
            for(Edge edge :adj.get(node)){
               int newDistance = curDis + edge.weight;
               if(newDistance < proceeseddistMap.getOrDefault(edge.target,Integer.MAX_VALUE)){
                   proceeseddistMap.put(edge.target,newDistance);
                   pq.add(new AbstractMap.SimpleEntry<>(edge.target,newDistance));
               }
            }
        }
        return -1;
    }

}
