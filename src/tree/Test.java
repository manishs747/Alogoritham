package tree;

import java.util.*;

public class Test {

	public static void main(String[] args) {

		List<String> list = null;
		/*list = new ArrayList<>();
		list.add("manish");*/
		upsertElementToList(list,"akhilesh");
		System.out.println(list);

	
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
