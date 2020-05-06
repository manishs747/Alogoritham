package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Views {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node root = TreeUtility.getSampleBinarySearchTree();
		TreeOperation.insert(root, 8);
		// TreeUtility.printNice(node);
		 BTreePrinter.printNode(root);
		 printLeftView(root);
		 System.out.println();
		 printRightView(root);
		 System.out.println();
		 printLeafNodes(root);
		 System.out.println("Bottom View");
		 bottomView(root);
	}
	
	
	
	public static void topView(Node root){
		
		Map<Integer,Integer> map = new TreeMap<Integer, Integer>();
		topViewUtility(root, 0, map);
		printHashMap(map);
	}
	
	public static void topViewUtility(Node root,int hd ,Map<Integer,Integer> map){
		if(root == null){
			return;
		}
		if(!map.containsKey(hd)){
			map.put(hd, root.data);
		}
		topViewUtility(root.left,hd -1,map);
		topViewUtility(root.right,hd +1,map);

	}
	
	
	
	//https://www.geeksforgeeks.org/print-left-view-binary-tree/
	// 1 2 4 8
	
	static void printLeftView(Node root){
		if(root == null){
			return;
		}
		Map<Integer,Integer> map = new TreeMap<Integer,Integer>();
		printLeftViewUtility(root, 0, map);
		printHashMap(map);

	}
	
	static void printLeftViewUtility(Node root , int hd,Map<Integer,Integer> map){
		if(root == null){
			return ;
		}
		if(!map.containsKey(hd)){
			map.put(hd, root.data);
		}
		printLeftViewUtility(root.left,hd +1,map);
		printLeftViewUtility(root.right,hd +1,map);
	}
	
	
	static void printRightView(Node root){
		if(root == null){
			return;
		}
		Map<Integer,Integer> map = new HashMap<Integer, Integer>();
		printRightViewUtility(root, 0, map);
		printHashMap(map);
	}
	
	static void printRightViewUtility(Node root , int hd,Map<Integer,Integer> map){
		if(root == null){
			return;
		}
		if(!map.containsKey(hd)){
			map.put(hd, root.data);
		}
		printRightViewUtility(root.right,hd +1,map);
		printRightViewUtility(root.left,hd +1,map);	
	}



	private static void printHashMap(Map<Integer, Integer> map) {
		Set<Integer> set = map.keySet();
		for (Integer key : set) {
			System.out.print(map.get(key)+" ");
		}
	}
	
	//https://www.geeksforgeeks.org/print-leaf-nodes-left-right-binary-tree/
	//Print all leaf nodes of a Binary Tree from left to right
	static void printLeafNodes(Node root){
		if(root == null){
			return;
		}
		List<Integer> list = new ArrayList<>();
		printLeafNodesUtility(root, list);
	}
	
	static void printLeafNodesUtility(Node root ,List<Integer> list){
		if(root == null){
			return;
		}
		if(root.left == null && root.right == null){
			System.out.print(root.data+" ");
		}
		printLeafNodesUtility(root.left,list);
		printLeafNodesUtility(root.right,list);
	}
	
	
	/*
	 *                20                             
                    /    \
                  8       22
                /   \      \
              5      3      25
                    / \      
                  10    14
                  
                  
                  5, 10, 3, 14, 25.
                  
                  
                      20
                    /    \
                  8       22
                /   \    /   \
              5      3 4     25
                    / \      
                  10    14 
                  
                  5, 10, 4, 14, 25      leaf at column
                  
	 */
	//https://www.geeksforgeeks.org/bottom-view-binary-tree/
	static void bottomView(Node root){
		if(root == null){
			return;
		}
		Map<Integer,Integer> map = new TreeMap<>();
		bottomViewUtils(root,0,map);
		for (int key : map.keySet()) {
			System.out.print(map.get(key)+" ");
		}
	}

	private static void bottomViewUtils(Node root,int hd, Map<Integer, Integer> map) {
		if(root == null){
			return;
		}
		map.put(hd, root.data);
		bottomViewUtils(root.left, hd-1, map);
		bottomViewUtils(root.right, hd+1, map);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	

}
