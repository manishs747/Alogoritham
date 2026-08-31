package data_structure.linklist.online.lru;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/lru-cache/description/
 */
public class LRUCache {


    public static void main(String[] args) {

        LRUCache lc = new LRUCache(1);

        //[1,1],[2,2],[1],[3,3],[2]
       // lc.put(1,1);
        lc.put(2,1);
        System.out.println(lc.get(2));
        //lc.put(3,3);
        //System.out.println(lc.get(2));

    }

    class ListNode {
        int key;
        int val;
        ListNode next;
        ListNode prev;

        public ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    ListNode head,tail;

    private  final Map<Integer,ListNode> nodeMap = new HashMap<>();
    private  final int capacity ;


    public LRUCache(int capacity) {
       this.capacity = capacity;
    }

    public int get(int key) {
        if(!nodeMap.containsKey(key)) return -1;
        ListNode node = nodeMap.get(key);
        remove(node); //remove node
        add(node);//add node
        return node.val;
    }

    public void put(int key, int value) {
        if(nodeMap.containsKey(key)){
            remove(nodeMap.get(key));
        }
        ListNode node = new ListNode(key,value);
        nodeMap.put(key,node);
        add(node);
        //remove if size greater than k
        if(nodeMap.size() > capacity){
           int oldkey = remove();
           nodeMap.remove(oldkey);
        }
    }

    public  void remove(ListNode node){
        if(node.prev != null){
            node.prev.next = node.next;
        }else{
            head = node.next;
        }
        if(node.next != null){
            node.next.prev = node.prev;
        }else{
            tail = node.prev;
        }
        node.next = null;
        node.prev = null;
    }


    public  int remove(){
        if (tail == null) return -1;
        int key = tail.key;
        remove(tail);
        return key;
    }


    public void add(ListNode node){
        node.prev = null;// since old node is passed not new created
        node.next = null;
        if(head == null){
            head = node;
            tail = node;
        }else{
            head.prev = node;
            node.next = head;
            head = node;
        }
        if(tail == null) tail = head;
    }




}
