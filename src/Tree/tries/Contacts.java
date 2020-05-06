package tree.tries;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 * 
 * https://www.hackerrank.com/challenges/ctci-contacts/problem
 * 
4
add hack
add hackerrank
find hac
find hak

2
0
 * 
 * 
 * 
 * 
 */
public class Contacts {
	
	private class Node{
		Map<Character,Node> childrens;
		int size = 0;
		boolean endOfWord;
		public Node() {
			childrens = new HashMap<>();
			endOfWord = false;
		}
		
		public void add(String s){
			System.out.println("add is called :"+s);
			int index = 0;
			
			Node current = root;
			while (index < s.length()) {
				size++;
				Node child = current.childrens.get(s.charAt(index));
				if (child == null) {
					child = new Node();
					current.childrens.put(s.charAt(index), child);
				}
				current = child;
				index++;
			}
			 //mark the current nodes endOfWord as true
			current.endOfWord = true;
			
		}
		
		public int findCount(String s, int index) {
			System.out.println("findCount :"+s);
			if (index == s.length()) {
				return size;
			}
			Node child = childrens.get(s.charAt(index));
			if (child == null) {
				return 0;
			}
			return findCount(s, index + 1);
		}
	}
	
	 private final Node root;
	 public Contacts() {
	        this.root = new Node();
	}
	 
	 
	 
	

		private  void process(String op, String contact) {
			System.out.println("Process:"+op);
			switch (op) {
			case "add":
				root.add(contact);
				return;
			
            case "find":
				System.out.println(root.findCount(contact, 0));
				break;
			default:
				break;
			}
			
		}
	
	public static void main(String[] args) {
		      Contacts  c = new Contacts();
		        Scanner in = new Scanner(System.in);
		        int n = in.nextInt();
		        for(int a0 = 0; a0 < n; a0++){
		            String op = in.next();
		            String contact = in.next();
		            c.process(op,contact);
		        }
		    
	}







}
