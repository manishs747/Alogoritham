package data_structure.graph.HackerRank;

import data_structure.graph.Node;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;


//https://leetcode.com/problems/find-if-path-exists-in-graph/
public class Graph {
    private HashMap<Integer, Node> nodeLookUp = new HashMap<Integer, Node>();

    private Node getNode(int id){
        return nodeLookUp.get(id);
    }

    private boolean hasPathDFS(int source,int destination){
        Node s = getNode(source) , d = getNode(destination);
        HashSet<Integer> visited = new HashSet<>();
        return hasPathDFS(s,d,visited);
    }

    private boolean hasPathDFS(Node s, Node d, HashSet<Integer> visited) {
        if(visited.contains(s.getId())) return false;
        visited.add(s.getId());
        if (s ==  d) return true;
        for (Node child:s.adjacent)
          if( hasPathDFS(child,d,visited)) return true;
        return false;
    }

    public boolean hasPathBFS(Node source, Node destination){
        LinkedList<Node> nextToVisit = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        nextToVisit.add(source);
        while (!nextToVisit.isEmpty()){
            Node s = nextToVisit.poll();
            if(s == destination) return true;
            if(visited.contains(s.getId())) continue;
            visited.add(s.getId());
            for (Node child:s.adjacent){
                nextToVisit.add(child);
            }

        }
        return false;
    }

    public static void main(String[] args) {

    }
}
