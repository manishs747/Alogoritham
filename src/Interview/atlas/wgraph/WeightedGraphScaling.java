package Interview.atlas.wgraph;

import java.util.*;

public class WeightedGraphScaling {

    static class Edge {
        String target;
        int weight;
        Edge(String target, int weight) {
            this.target = target;
            this.weight = weight;
        }
    }

    static class Graph {
        Map<String, List<Edge>> adj = new HashMap<>();

        public void addEdge(String src, String dest, int weight) {
            adj.computeIfAbsent(src, k -> new ArrayList<>()).add(new Edge(dest, weight));
            adj.putIfAbsent(dest, new ArrayList<>()); // ensure dest exists
        }

        // Run Dijkstra
        public Map<String, Integer> dijkstra(String source, boolean reverse) {
            Map<String, Integer> dist = new HashMap<>();
            for (String node : adj.keySet()) {
                dist.put(node, Integer.MAX_VALUE);
            }
            dist.put(source, 0);

            PriorityQueue<Map.Entry<String, Integer>> pq =
                    new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
            pq.add(new AbstractMap.SimpleEntry<>(source, 0));

            while (!pq.isEmpty()) {
                Map.Entry<String, Integer> curr = pq.poll();
                String node = curr.getKey();
                int d = curr.getValue();
                if (d > dist.get(node)) continue;

                for (String u : adj.keySet()) {
                    for (Edge edge : adj.get(u)) {
                        String from = reverse ? edge.target : u;
                        String to   = reverse ? u : edge.target;
                        int w = edge.weight;
                        if (from.equals(node)) {
                            int newDist = d + w;
                            if (newDist < dist.get(to)) {
                                dist.put(to, newDist);
                                pq.add(new AbstractMap.SimpleEntry<>(to, newDist));
                            }
                        }
                    }
                }
            }
            return dist;
        }

        // Main function: build one bridge if needed
        public void findPathWithBridge(String source, String dest, int bridgeCost) {
            Map<String, Integer> s = dijkstra(source, false);   // from source
            if (s.get(dest) != Integer.MAX_VALUE) {
                System.out.println("Shortest path without bridge: " + s.get(dest));
                return;
            }

            Map<String, Integer> d = dijkstra(dest, true);      // to dest
            int best = Integer.MAX_VALUE;
            String bestI = null, bestJ = null;

            for (String i : s.keySet()) {
                for (String j : d.keySet()) {
                    if (s.get(i) != Integer.MAX_VALUE && d.get(j) != Integer.MAX_VALUE) {
                        int candidate = s.get(i) + bridgeCost + d.get(j);
                        if (candidate < best) {
                            best = candidate;
                            bestI = i;
                            bestJ = j;
                        }
                    }
                }
            }

            if (bestI != null && bestJ != null) {
                System.out.println("Best path with bridge " + bestI + "→" + bestJ +
                        " cost=" + best);
            } else {
                System.out.println("Destination not reachable even with one bridge.");
            }
        }
    }

    // ---------------- Demo ----------------
    public static void main(String[] args) {
        Graph g = new Graph();
        g.addEdge("A", "B", 3);
        g.addEdge("C", "D", 2);

        g.findPathWithBridge("A", "D", 1);
        // Expected: Best path with bridge B→C cost=6
    }
}

