package data_structure.linklist.online.lru;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheSenital {

    class Node {
        int key, value;
        Node prev, next;
        Node(int k, int v) { key = k; value = v; }
    }

    public static void main(String[] args) {
        LRUCacheSenital lrs = new LRUCacheSenital(2);
        //[[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]

        lrs.put(1,1);
        lrs.put(2,2);
        System.out.println(lrs.get(1));
    }

    private final int capacity;
    private final Map<Integer, Node> map = new HashMap<>();
    private final Node head; // dummy head
    private final Node tail;

    public LRUCacheSenital(int capacity) {
       this.capacity = capacity;
       head = new Node(-1,-1);
       tail = new Node(-1,-1);
       head.next = tail;
       tail.prev = head;
    }

    public int get(int key) {
       if(!map.containsKey(key)) return -1;
        Node node = map.get(key);
        moveToHead(node);
        return  node.value;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.value = value;
            moveToHead(node);
        } else {
            Node newNode = new Node(key,value);
            addAfterHead(newNode);
            map.put(key,newNode);
            if(map.size() > capacity){
                int lruKey =  removeBeforeTail();
                map.remove(lruKey);
            }
        }
    }

    public void addAfterHead(Node node){
        Node next = head.next;
        head.next = node;
        next.prev = node;
        node.next = next;
        node.prev = head;
    }


    public void removeNode(Node node){
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    public int removeBeforeTail(){
        Node lru = tail.prev;
        removeNode(lru);
        return lru.key;
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addAfterHead(node);
    }

}
