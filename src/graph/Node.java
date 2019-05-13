package graph;

import java.util.LinkedList;

public class Node {
	public int id;
	LinkedList<Node> adjacent = new LinkedList<Node>();
	public Node(int id) {
		this.id = id;
	}
}
