package data_structure.tree.online;

import data_structure.tree.BTreePrinter;
import data_structure.tree.Node;
import data_structure.tree.TreeUtility;

import java.util.ArrayList;
import java.util.List;

public class AllElementsTwoTree {

    public static void main(String[] args) {
        Node root1 = TreeUtility.getSampleBinarySearchTree();
        root1.right = new Node(5);
        BTreePrinter.printNode(root1);
        Node root2 = TreeUtility.getSampleBinarySearchTree();
        root2.right = new Node(6);
        BTreePrinter.printNode(root2);
        System.out.println(getAllElements(root1,root2));

    }


    public static List<Integer> getAllElements(Node root1, Node root2) {
        List<Integer> list1 = new ArrayList<>();
        inorder(root1,list1);
        List<Integer> list2 = new ArrayList<>();
        inorder(root2,list2);
        List<Integer> list = mergeTwoLists(list1,list2);
        return list;
    }

    public static void inorder(Node root,List<Integer> list){
        if(null == root){
            return;
        }
        inorder(root.left,list);
        list.add(root.data);
        inorder(root.right,list);
    }

    public static List<Integer> mergeTwoLists(List<Integer> l1 , List<Integer> l2) {
        if (l1 == null) { return l2; }
        if (l2 == null) { return l1; }
        List<Integer> list = new ArrayList<>();
        int ls1 = 0 ,ls2 = 0;
        while (ls1 < l1.size() && ls2 < l2.size()) {
            if (l1.get(ls1) <= l2.get(ls2)) {
                list.add(l1.get(ls1));
                ls1++;
            } else {
                list.add(l2.get(ls2));
                ls2++;
            }
        }
        if (ls1 == l1.size()) {
            while (ls2 < l2.size()){
                list.add(l2.get(ls2));
                ls2++;
            }
        } else {
            while (ls1 < l1.size()){
                list.add(l1.get(ls1));
                ls1++;
            }
        }
        return list;
    }


}
