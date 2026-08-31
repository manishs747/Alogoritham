package Interview.atlas.wgraph;

import java.util.*;

public class Practice {

    static class Edge {
        String target;
        int weight;
        Edge(String target, int weight) {
            this.target = target;
            this.weight = weight;
        }
    }


    Map<String, List<Edge>> graph = new HashMap<>();

    public void addEdge(String src, String dest, int weight) {
        graph.computeIfAbsent(src, k -> new ArrayList<>()).add(new Edge(dest, weight));
        graph.putIfAbsent(dest, new ArrayList<>()); // ensure dest node is also present
    }


    public int shortestTime(String source, String dest) {
        Map<String,Integer> distanceMap = new HashMap<>();
        for (String key:graph.keySet()){
            distanceMap.put(key,Integer.MAX_VALUE);
        }
        distanceMap.put(source,0);

        PriorityQueue<Map.Entry<String,Integer>>  minHeap = new PriorityQueue<>(Comparator.comparingInt(a->a.getValue()));
        minHeap.add(new AbstractMap.SimpleEntry<>(source,0));
        while (!minHeap.isEmpty()){
           Map.Entry<String,Integer> current = minHeap.poll();
           String curNode = current.getKey();
           int curDistance = current.getValue();

           if(curNode.equals(dest)) //return early re
               return curDistance;
           if(curDistance > distanceMap.get(curNode)) continue;
           for (Edge edge:graph.get(curNode)){
               int newDistance = curDistance + edge.weight;
               if(newDistance < distanceMap.get(edge.target)){
                   minHeap.add(new AbstractMap.SimpleEntry<>(edge.target,newDistance));
                   distanceMap.put(edge.target, newDistance);
               }
           }
        }
        return -1;
    }
}
