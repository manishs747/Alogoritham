package data_structure.tries;

public class TrieOld {
    private TrieNode root;
    public TrieOld() {
        root = new TrieNode();
    }

    public TrieNode getRoot(){
        return root;
    }


    public void insertIterative(String word) {
        TrieNode curNode = root;
        for ( char ch:word.toCharArray()) {
            curNode.children.putIfAbsent(ch,new TrieNode());
            curNode = curNode.children.get(ch);
        }
        curNode.isEndOfWord = true;
    }


    public void insert(String word) {
        insert(word,0, root);
    }
    public void insert(String word ,int index , TrieNode node) {
        if(index == word.length()) {
            node.isEndOfWord = true;
            return ;
        }
        node.children.putIfAbsent(word.charAt(index),new TrieNode());
        insert(word,index+1,node.children.get(word.charAt(index)));
    }

    public boolean search(String word) {
        TrieNode current = root;
        for (char ch:word.toCharArray()) {
          if(!current.children.containsKey(ch))
              return false;
            current = current.children.get(ch);
        }
        return current.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for (char ch:prefix.toCharArray()) {
            if(!current.children.containsKey(ch))
                return false;
            current = current.children.get(ch);
        }
        return true;
    }


}
