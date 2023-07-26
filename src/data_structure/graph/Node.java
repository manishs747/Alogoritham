package data_structure.graph;

import java.util.LinkedList;

public class Node {
    private int id;
    LinkedList<Node> adjacent = new LinkedList<>();
    private Node(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }
}
