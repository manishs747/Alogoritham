package Tree.tires;

import java.util.HashMap;
import java.util.Map;

public class Trie {
	
	private class TrieNode{
		Map<Character,TrieNode> childrens;
		boolean endOfWord;
		public TrieNode() {
			childrens = new HashMap<>();
			endOfWord = false;
		}
	}
	
	 private final TrieNode root;
	    
	 public Trie() {
	        this.root = new TrieNode();
	}
	 
	 /**
	     * Iterative implementation of insert into trie
	     * complexity  O(n*l)   n is number of word and l is average lenght
	     */
	 public void insertIterative(String word) {
		 TrieNode current = root;
		 char c = 0;
		 for ( int i = 0; i < word.length(); i++) {
			 c = word.charAt(i);
			 TrieNode node = current.childrens.get(c);
			 if(node == null){
				 node = new TrieNode();
				 current.childrens.put(c, node);
			 }
			 current = node;
		 }
		 //mark the current nodes endOfWord as true
		 current.endOfWord = true;
	 }
	 
	 /**
	     * Recursive implementation of insert into trie
	     */
	public void insertRecursive(String word) {
	        insertRecursive(root, word, 0);
	}
	    
	    
	

	private void insertRecursive(TrieNode current, String word, int i) {
		
		
	}

	public static void main(String[] args) {
		Trie root = new Trie();
		
	
		
		
		
		
		
	}

}
