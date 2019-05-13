package linklist;

public class ListUtility
{
	
	public static  <T> void display(NodeT<T> headNode){
		/*	int length= 0;
			Node currentNode = headNode;
			while(currentNode!=null){
				length++;
				System.out.print(currentNode.data + " " );
				currentNode=currentNode.next;
				
			}*/
			for (NodeT currentNode = headNode;  currentNode!=null;currentNode=currentNode.next ) {
				System.out.print(currentNode.getData() +" ");
			}
			System.out.println();
		
		}
	
	
	
	public static <T> int getListLength(NodeT<T> headNode){
		int length= 0;
		NodeT<T> currentNode = headNode;
		while(currentNode!=null){
			length++;
			currentNode=currentNode.next;
		}
		return length;
	}
	
	
	public static void display(Node headNode){
		
		for (Node currentNode = headNode;  currentNode!=null;currentNode=currentNode.next ) {
			System.out.print(currentNode.data +" " );
		}
		System.out.println();
	
	}
	
	public static  int getListLength(Node headNode){
		int length= 0;
		Node currentNode = headNode;
		while(currentNode!=null){
			length++;
			currentNode=currentNode.next;
		}
		return length;
	}


}
