package data_structure.tree.nary;

import java.util.*;

/**
 * https://leetcode.com/problems/n-ary-tree-level-order-traversal/
 */
public class LevelOrder {

    public static void main(String[] args) {
        System.out.println(levelOrder2Queue(getSampleNode()));
    }


    public static Node getSampleNode() {
        List<Node> child2 = Arrays.asList(new Node(5, null), new Node(6, null));
        List<Node> child1 = Arrays.asList(new Node(2, child2), new Node(3, null), new Node(4, null));
        Node root = new Node(1, child1);
        return root;
    }

    public static List<List<Integer>> levelOrder2Queue(Node root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        Queue<Node> first = new LinkedList<>();
        Queue<Node> second = new LinkedList<>();
        first.add(root);
        while (!first.isEmpty() || !second.isEmpty()) {
            List<Integer> currentList = new ArrayList<>();
            while (!first.isEmpty()) {
                Node node = first.poll();
                currentList.add(node.val);
                if (node.children != null) {
                    for (Node n : node.children) {
                        second.add(n);
                    }
                }
            }
            list.add(currentList);
            Queue<Node> tmp = first;
            first = second;
            second = tmp;
        }
        return list;
    }

    public static List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        List<Integer> levelList = new ArrayList<>();
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node == null) {
                if (!queue.isEmpty()) {
                    queue.add(null);
                }
                list.add(levelList);
                levelList = new ArrayList<>();
                continue;
            }
            levelList.add(node.val);
            if (node.children != null) {
                for (Node n : node.children) {
                    queue.add(n);
                }
            }
        }
        return list;
    }


    public List<List<Integer>> levelOrderSol2(Node root) {
        List<List<Integer>> ret = new LinkedList<>();
        if (root == null) return ret;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> curLevel = new LinkedList<>();
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Node curr = queue.poll();
                curLevel.add(curr.val);
                for (Node c : curr.children)
                    queue.offer(c);
            }
            ret.add(curLevel);
        }

        return ret;
    }

}
