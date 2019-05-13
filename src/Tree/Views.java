package Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.Vector;

public class Views {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s1="1 14 3 7 4 5 15 6 13 10 11 2 12 8 9";
		String[] words=s1.split("\\s");
		int [] arr = {2,1,3,6,5,7};
		Node root = null;
    	for (String number : words) {
    		root = BasicOperation.insertRec(root,Integer.parseInt(number));
		}
		//Node root = Tree.getSampleBinarySearchTree();
		//BasicOperation.insert(root, 8);
		// TreeUtility.printNice(node);
		// BTreePrinter.printNode(root);
		/* printLeftView(root);
		 System.out.println();
		 printRightView(root);
		 System.out.println();
		 printLeafNodes(root);
		 System.out.println("Bottom View");
		 bottomView(root);*/
		//printVerticalOrder(root);
		topView(root);
	}
	
	
	
	public static void topView(Node root){
		Map<Integer,TreeMap<Integer,Integer>> map = new TreeMap<Integer, TreeMap<Integer,Integer>>();
		topViewUtility(root, 0,0, map);
		for (int key : map.keySet()) {
			System.out.print(map.get(key).firstEntry().getValue()+" ");
		}
		
	}

	public static void topViewUtility(Node root,int hd, int vd ,Map<Integer,TreeMap<Integer,Integer>> map){
		if(root == null){
			return;
		}
		if(!map.containsKey(hd)){  //doesnt contain in map
			TreeMap<Integer, Integer> tm = new TreeMap<Integer,Integer>();
			tm.put(vd, root.data);
			map.put(hd, tm);
		}else {
			TreeMap<Integer, Integer> tm = map.get(hd);
			if (vd < tm.firstKey()) {
				tm.remove(tm.firstKey());
				tm.put(vd, root.data);
				map.put(hd, tm);
			}
		}
		topViewUtility(root.left,hd -1,vd+1,map);
		topViewUtility(root.right,hd +1,vd+1,map);
	}
	
	
	//https://www.geeksforgeeks.org/print-binary-tree-vertical-order-set-2/
	public static void printVerticalOrder(Node root) {
        TreeMap<Integer,Vector<Integer>> map = new TreeMap<>(); 
        int hd =0; 
        getVerticalOrder(root,hd,map);
        for (Entry<Integer, Vector<Integer>> entry : map.entrySet()) 
        { 
            System.out.println(entry.getValue()); 
        } 
	}
	
	private static void getVerticalOrder(Node root, int hd, TreeMap<Integer, Vector<Integer>> m) {
		if (root == null) return ;
		if( m.containsKey(hd)) {
			m.get(hd).add(root.data);
		}else {
			Vector<Integer> list = new Vector<Integer>();
			list.add(root.data);
			m.put(hd, list);
		}
		getVerticalOrder(root.left, hd-1, m);
		getVerticalOrder(root.right, hd+1, m);

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
