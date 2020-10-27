package data_structure.tree;

import java.util.*;

public class Test {

	public static void main(String[] args) {


	
	}

	public List<Integer> preorderTraversal(Node root) {
		List<Integer> list = new ArrayList<>();
		preorderTraversal(root,list);
		return list;
	}

	public static void preorderTraversal(Node root,List<Integer> list){
		if(root == null){
			return;
		}
		list.add(root.data);
		preorderTraversal(root.left,list);
		preorderTraversal(root.right,list);
	}


	 static void upsertElementToList(List<String> list1, String element){
		 System.out.println(list1);
		if(null == list1){
			list1 = new ArrayList<>();
		}
		 System.out.println(list1);
		Set<String> groupSet = new HashSet<String>(list1);
		groupSet.add(element);
		list1.clear();
		list1.addAll(groupSet);
	}
	
	
}
