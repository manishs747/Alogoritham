package Interview.atlas.wgraph;

import java.util.*;

public class WeightedGraph {

    static class Edge {
        String target;
        int weight;
        Edge(String target, int weight) {
            this.target = target;
            this.weight = weight;
        }
    }

    Map<String, List<Edge>> graph = new HashMap<>();

    // Add directed edge
    public void addEdge(String src, String dest, int weight) {
        graph.computeIfAbsent(src, k -> new ArrayList<>()).add(new Edge(dest, weight));
        graph.putIfAbsent(dest, new ArrayList<>()); // ensure dest node is also present
    }

        public boolean canTransmit(String source, String dest) {
            if (!graph.containsKey(source) || !graph.containsKey(dest)) return false;
            Set<String> visited = new HashSet<>();
            return dfs(source, dest, visited);
        }

    private boolean dfs(String source, String dest, Set<String> visited) {
        if(source.equals(dest)) return true;
        if(visited.contains(source)) return false;
        visited.add(source);
        for ( Edge child: graph.get(source)){
            if(dfs(child.target,dest,visited)) return true;
        }
        return false;
    }


    public int shortestTime(String source, String dest) {
        if(!graph.containsKey(source) || !graph.containsKey(dest)) return -1;
        Map<String,Integer>   distMap = new HashMap<>();
        for (String key : graph.keySet()){
            distMap.put(key,Integer.MAX_VALUE);
        }
        distMap.put(source,0);
        PriorityQueue<Map.Entry<String,Integer>>  minHeap = new PriorityQueue<>(Comparator.comparingInt(a-> a.getValue()));
        minHeap.add(new AbstractMap.SimpleEntry<>(source,0));
        while (!minHeap.isEmpty()){
            Map.Entry<String, Integer> current = minHeap.poll();
            String curNode = current.getKey();
            int curDistance = current.getValue();

            if(curNode.equals(dest)) return curDistance; //  return early if match
            if( curDistance > distMap.get(curNode)) continue; //  cur > old continue if old distance is already shortest

            for (Edge edge:graph.get(curNode)){
                int newDistance = edge.weight + curDistance;
                if(newDistance < distMap.get(edge.target)){
                    distMap.put(edge.target,newDistance);
                    minHeap.add(new AbstractMap.SimpleEntry<>(edge.target,newDistance));
                }
            }
        }
       return -1;
    }


    public static void main(String[] args) {
        WeightedGraph g = new WeightedGraph();
        g.addEdge("A", "B", 5);
        g.addEdge("A", "C", 2);
        g.addEdge("B", "D", 1);
        g.addEdge("C", "D", 7);

        System.out.println("Can transmit A→D? " + g.canTransmit("A", "D")); // true
        System.out.println("Shortest time A→D: " + g.shortestTime("A", "D")); // 6
        System.out.println("Can transmit C→B? " + g.canTransmit("C", "B")); // false
        System.out.println("Shortest time C→B: " + g.shortestTime("C", "B")); // -1
    }


}
