package data_structure.tries;


import java.util.*;

/**
 * https://leetcode.com/problems/search-suggestions-system/
 *
 */
public class SuggestedProducts {

    public static void main(String[] args) {

       String []  products = {"mobile","mouse","moneypot","monitor","mousepad"};
       String searchWord = "mouse";
        //Output: [["mobile","moneypot","monitor"],["mobile","moneypot","monitor"],["mouse","mousepad"],["mouse","mousepad"],["mouse","mousepad"]]
        SuggestedProducts  sp = new SuggestedProducts();
        System.out.println(sp.suggestedProducts(products,searchWord));
    }

    private class Node {
        Map<Character,Node> childrens = new TreeMap<>();
        boolean isEndOfWord;
    }

    private Node root = new Node();
    private  List<String> searchRes;


    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> result = new ArrayList<>();
        for(String product: products)
            insert(product);
        StringBuilder sb = new StringBuilder();
        for(char c: searchWord.toCharArray()){
            sb.append(c);
            search(sb.toString());
            result.add(searchRes);
        }
        return result;
    }


    public void search(String prefix){
        searchRes = new ArrayList<>();
        Node cur = root;
        for (char c : prefix.toCharArray()){
            cur = cur.childrens.get(c);
            if(cur == null) return;
        }
        dfs(cur,prefix);
    }

    private void dfs(Node cur, String word) {
        if(cur == null || searchRes.size() == 3) return;
        if(cur.isEndOfWord) searchRes.add(word);
        for(char c : cur.childrens.keySet()){
            dfs(cur.childrens.get(c),word+c);
        }
    }


    public void insert(String word){
        Node cur = root;
        for (char c : word.toCharArray()){
            cur = cur.childrens.computeIfAbsent(c,_-> new Node());
        }
        cur.isEndOfWord = true;
    }
}
