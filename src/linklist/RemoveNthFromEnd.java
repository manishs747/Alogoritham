package linklist;

/*https://leetcode.com/problems/remove-nth-node-from-end-of-list/*/

public class RemoveNthFromEnd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr = {1};
		Node list =  Operation.createLinkList(arr);
		Utility.Print(list);
		System.out.println("After Reverse");
		list = removeNthFromEnd(list,1);
		Utility.Print(list);

	}




}
