package data_structure.tree.online;

import data_structure.tree.BTreePrinter;
import data_structure.tree.Node;
import utils.ArrayUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

    public static void main(String[] args) {

        Node right = new Node(5,new Node(5),null);
        Node left = new Node(2,new Node(1),new Node(3,new Node(3),null));
        Node root = new Node(4,left,right);
        BTreePrinter.printNode(root);
        int[] result = findMode(root);
        ArrayUtils.print(result);

    }


    public static int[] findMode(Node root) {
     Map<Integer,Integer> frequencyCount = new HashMap<>();
     inOrder(root,frequencyCount);
        System.out.println(frequencyCount);
        int freq = 0;
        List<Integer>  itemList = new ArrayList<>();
        for (int key:frequencyCount.keySet()) {
            int f = frequencyCount.get(key);
            if(f == freq){
                itemList.add(key);
            }else if (f > freq){
                itemList = new ArrayList<>();
                freq = f;
                itemList.add(key);
            }
        }
        int [] res = new int[itemList.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = itemList.get(i);
        }
        return res;
    }

    public static void inOrder(Node node, Map<Integer,Integer> frequencyCount){
        if(node == null){
           return;
        }
        inOrder(node.left,  frequencyCount);
        frequencyCount.put(node.data,frequencyCount.getOrDefault(node.data,0)+1);
        inOrder(node.right,  frequencyCount);
    }










}
