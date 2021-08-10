package data_structure.tree.nary;

import java.util.*;

public class Traversal {


    public static void main(String[] args) {

        System.out.println(preorder(getSampleNode()));
    }


    public static Node getSampleNode() {
        List<Node> child2 = Arrays.asList(new Node(5, null), new Node(6, null));
        List<Node> child1 = Arrays.asList(new Node(2, child2), new Node(3, null), new Node(4, null));
        Node root = new Node(1, child1);
        return null;
    }


    public static List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        preorderHelper(root, list);
        return list;
    }

    public static List<Integer> preorderHelper(Node root, List<Integer> list) {

        if (root == null) {
            return list;
        }
        System.out.println(root.val);
        list.add(root.val);
        if (null == root.children) {
            return list;
        }
        for (Node children : root.children) {
            preorderHelper(children, list);
        }
        return list;
    }




}
