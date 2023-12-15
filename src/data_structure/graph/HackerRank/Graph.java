package data_structure.graph.HackerRank;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;


//https://leetcode.com/problems/find-if-path-exists-in-graph/
public class Graph {

    private HashMap<Integer,Node> nodeLookUp = new HashMap<Integer, Node>();

    public static class Node{
        private int id;
        LinkedList<Node> adjacent = new LinkedList<>();
        private Node(int id){
            this.id = id;
        }
    }


    private Node getNode(int id){
        return nodeLookUp.get(id);
    }

    public void addEdge(int source,int destination){
        Node s = getNode(source) , d = getNode(destination);
        s.adjacent.add(d);
    }

    private boolean hasPathDFS(int source,int destination){
        Node s = getNode(source) , d = getNode(destination);
        HashSet<Integer> visited = new HashSet<>();
        return hasPathDFS(s,d,visited);
    }

    private boolean hasPathDFS(Node s, Node d, HashSet<Integer> visited) {
        if(visited.contains(s.id)) return false;
        visited.add(s.id);
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
            if(visited.contains(s.id)) continue;
            visited.add(s.id);
            for (Node child:s.adjacent){
                nextToVisit.add(child);
            }

        }
        return false;
    }

    public static void main(String[] args) {

    }
}
