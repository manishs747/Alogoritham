package data_structure.graph.strcuty;




import data_structure.graph.Utility;


import java.util.*;

public  class ShortestPath {



    public static void main(String[] args) {
        List<List<String>> edges = List.of(
                List.of("a", "c"),
                List.of("a", "b"),
                List.of("c", "b"),
                List.of("c", "d"),
                List.of("b", "d"),
                List.of("e", "d"),
                List.of("g", "f")
        );
        System.out.println(shortestPath2(edges, "b", "g"));
    }

    public static int shortestPath1(List<List<String>> edges, String nodeA, String nodeB) {
        Map<String, List<String>> graph  = Utility.getGraph(edges);
        Queue<String> queue = new LinkedList<>();
        queue.add(nodeA);
        Set<String> visitedSet = new HashSet<>();
        Map<String,Integer> countMap = new HashMap<>();
        countMap.put(nodeA,0);
        while (!queue.isEmpty()){
            String currentNode = queue.poll();
            int pathcount = countMap.get(currentNode);
            if(currentNode.equals(nodeB)) return pathcount;
            if(visitedSet.contains(currentNode)) continue;
            visitedSet.add(currentNode);
            for (String neigbours:graph.get(currentNode)) {
                queue.add(neigbours);
                countMap.putIfAbsent(neigbours,pathcount+1);
            }
        }
        return -1;
    }

    public static int shortestPath2(List<List<String>> edges, String nodeA, String nodeB) {
        Map<String, List<String>> graph  = Utility.getGraph(edges);
        Queue<String []> queue = new LinkedList<>();
        queue.add(new String []{nodeA,"0"});
        Set<String> visitedSet = new HashSet<>(Collections.singletonList(nodeA));
        while (!queue.isEmpty()){
          String []  current = queue.poll();
          int currentLevel  = Integer.parseInt(current[1]);
          if(current[0].equals(nodeB)) return currentLevel;
            for (String neigbour:graph.get(current[0])) {
                if(visitedSet.add(neigbour))
                 queue.add(new String []{neigbour,String.valueOf(currentLevel+1)});
            }
        }
        return -1;
    }

    public static int shortestPath3(List<List<String>> edges, String nodeA, String nodeB) {
        Map<String, List<String>> graph  = Utility.getGraph(edges);
        Queue<String> queue = new LinkedList<>();
        queue.add(nodeA);
        queue.add(null);
        Set<String> visitedSet = new HashSet<>();
        int level = 0;
        while (!queue.isEmpty()){
            String currentNode = queue.poll();
            if (currentNode == null) {
                if(queue.isEmpty()) break;
                level++;
                queue.add(null);
                continue;
            }
            if(currentNode.equals(nodeB)) return level;
            if(visitedSet.contains(currentNode)) continue;
            visitedSet.add(currentNode);
            for (String neigbours:graph.get(currentNode)) {
                queue.add(neigbours);
            }
        }
        return -1;
    }




    public static int shortestPath(List<List<String>> edges, String nodeA, String nodeB) {
        Map<String, List<String>> graph = Utility.getGraph(edges);
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


   }
