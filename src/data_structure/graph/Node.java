package data_structure.graph;

import java.util.LinkedList;
import java.util.List;

public class Node {
    public int id;
    public List<Node> adjacent = new LinkedList<>();
    public Node(int id){
        this.id = id;
    }

    public Node(int id, List<Node> adjacent){
        this.id = id;
        this.adjacent = adjacent;
    }

    public void addEdge(Node destination){
        this.adjacent.add(destination);
    }

    public int getId(){
        return id;
    }
}
