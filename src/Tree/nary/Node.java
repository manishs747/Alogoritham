package Tree.nary;

import java.util.List;

public class Node {
	public List<Node> children;
	public int val;
	  public Node(int _val,List<Node> _children) {
	        val = _val;
	        children = _children;
	    }

	@Override
	public String toString() {
		return this.val+"";
	}

}
