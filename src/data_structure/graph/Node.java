package data_structure.graph;

import java.util.LinkedList;

public class Node {
    private int id;
    public LinkedList<Node> adjacent = new LinkedList<>();
    public Node(int id){
        this.id = id;
    }

    public void addEdge(Node destination){
        this.adjacent.add(destination);
    }

    public int getId(){
        return id;
    }
}
