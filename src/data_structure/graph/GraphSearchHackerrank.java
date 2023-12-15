package data_structure.graph;

import java.util.HashSet;
import java.util.LinkedList;




//Hacker rank
public class GraphSearchHackerrank {

    private Node getNode(int id){
        return null;
    }

    public void addEdge(int source,int destination){
        Node s = getNode(source);
        Node d = getNode(destination);
        s.adjacent.add(d);
    }

    public boolean hasPathDFS(int source,int destination){
        return hasPathDFS(getNode(source),getNode(destination),new HashSet<>());
    }

    private boolean hasPathDFS(Node s, Node d, HashSet<Integer> visited) {
        if(visited.contains(s.getId())) return false;
        visited.add(s.getId());
        if (s == d) return true;
        for (Node child:s.adjacent) {
            if(hasPathDFS(child,d,visited)) return true;
        }
        return false;
    }

    private boolean hasPathBFS(Node s, Node d) {
        LinkedList<Node> nextNodeToVisit = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        nextNodeToVisit.add(s);
        while (!nextNodeToVisit.isEmpty()){
            Node node = nextNodeToVisit.remove();
            if(node == d) return true;
            if (visited.contains(node.getId())) continue;
            visited.add(node.getId());
            for (Node child:s.adjacent) {
                nextNodeToVisit.add(child);
            }
        }
        return false;
    }
}
