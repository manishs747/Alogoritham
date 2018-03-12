package Tree;

public class Node {
   public Node left,right;
   public int data;
   public Node(int data) {
	   this.data = data;
    }
   
   @Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.data+"";
	}
	
}
