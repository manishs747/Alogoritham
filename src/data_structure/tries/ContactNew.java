package data_structure.tries;

import data_structure.strings.online.AllOne;

import java.util.HashMap;
import java.util.Map;

public class ContactNew {

    public static void main(String[] args) {
        ContactNew cn = new ContactNew();
        cn.add("hack");
        cn.add("hackrank");
        System.out.println(cn.count("hac"));//2
        System.out.println(cn.count("hak"));//0

    }

    private class  Node{
        Map<Character,Node> childrens = new HashMap<>();
        int count = 0 ;
    }



    private Node root = new Node();





    public void add(String s){
        Node cur = root;
        for (char c : s.toCharArray()){
            cur = cur.childrens.computeIfAbsent(c, _ -> new Node());
            cur.count = cur.count + 1;
        }
    }


    public int count(String prefix){
        Node cur = root;
        for (char c : prefix.toCharArray()){
            cur = cur.childrens.get(c);
            if(cur == null) return 0;
        }
        return cur.count;
    }


}
