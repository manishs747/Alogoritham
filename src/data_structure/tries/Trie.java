package data_structure.tries;

import java.util.HashMap;
import java.util.Map;

public class Trie {



    public static void main(String[] args) {
      /*  Input
                ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
        Output
                [null, null, true, false, true, null, true]*/

        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));//true
        System.out.println(trie.search("app"));//false
        trie.insert("app");
        System.out.println(trie.search("app"));//true
    }

    private class Node{
        Map<Character,Node> childrens = new HashMap<>();
        boolean isEndOfWord ;
    }


    private Node root;

    public Trie() {
        this.root = new Node();
    }

    public void insert(String word) {
        Node cur = root;
        for(char c : word.toCharArray()){
           cur = cur.childrens.computeIfAbsent(c, k -> new Node());
        }
        cur.isEndOfWord = true;
    }


    public boolean search(String word) {
        Node cur = root;
        for (char c : word.toCharArray()){
            cur = cur.childrens.get(c);
            if(cur == null) return false;
        }
        return cur.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        Node cur = root;
        for (char c : prefix.toCharArray()){
            cur = cur.childrens.get(c);
            if(cur == null) return false;
        }
        return true;
    }
}
