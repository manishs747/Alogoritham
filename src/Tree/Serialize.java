package Tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
//https://www.youtube.com/watch?v=jwzo6IsMAFQ
//https://www.geeksforgeeks.org/serialize-deserialize-binary-tree/
public class Serialize {




	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.right.left = new Node(4);
		root.right.right = new Node(5);
		BTreePrinter.printNode(root);
		String s = serialize(root);
		System.out.println(s);
		Node node = deSerialize(s);
		BTreePrinter.printNode(node);
	}



	public static String serialize(Node root) {
		if (root == null) {
			return "X";
		}
		return root.data+","+serialize(root.left)+","+serialize(root.right);
	}


	public static Node deSerialize(String serialize){
		Queue<String> list = new LinkedList<>();
		list.addAll(Arrays.asList(serialize.split(",")));
		return deSerializehelper(list);

	}
	public static Node deSerializehelper(Queue<String> list){
		if (list.isEmpty() ) {
			return null;
		}
		String ce = list.poll();
		if (ce.equals("X")) {
			return null;
		}
		Node node = new Node(Integer.parseInt(ce));
		node.left = deSerializehelper(list);
		node.right = deSerializehelper(list);		
		return node;
	}







}
