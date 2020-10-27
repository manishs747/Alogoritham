package data_structure.tree.construction_convertion;


import data_structure.tree.Node;
import data_structure.tree.TreeUtility;

public class Convertion {

	static int MIN_VAL = Integer.MIN_VALUE;

	public static void main(String[] args) {
		Node root = TreeUtility.getSampleBinarySearchTree();
		//BTreePrinter.printNode(root);
		//System.out.println( minDiffInBST(root));
		/*List<Integer> a = new ArrayList<>();
		a.add(4 );
		a.add( 6);
		a.add(5 );
		a.add( 3 );
		a.add( 3 );
		a.add( 1);
		System.out.println(pickingNumbers(a));*/

		/*int [] a= {1, 2, 2, 3, 1 ,2};
		List<Integer> list = ArrayUtils.getListFromArr(a);*/


		filterNodeListByGroup(100);

	}


	static void filterNodeListByGroup(int val){
		if (val < 10){
			System.out.println("One Digit");
		}else if (val > 9 && val < 99){
			System.out.println("Two Digit");
		}else{
			System.out.println("Three Digit");
		}
	}






    /*
    https://leetcode.com/problems/minimum-distance-between-bst-nodes/
   */
	public static int minDiffInBST(Node root) {
		minDiffInBST(root,Integer.MIN_VALUE);
		return MIN_VAL;

	}

	public  static int minDiffInBST(Node root, int prev){
		if(root == null){
			return prev;
		}
		minDiffInBST(root.left, prev);
		MIN_VAL = Math.min(Math.abs(root.data - prev),MIN_VAL);
		prev = minDiffInBST(root.right,root.data);
	    return prev;
	}


	/*
	  https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
	 */
	public Node sortedArrayToBST(int[] nums) {

		return null;
	}
	
	
	
	
	//https://www.geeksforgeeks.org/in-place-convert-a-given-binary-tree-to-doubly-linked-list/
	
	
	Node bintree2list(Node root){
		return root;
		
	}
		

}
