package data_structure.tree.online;

import data_structure.tree.BTreePrinter;
import data_structure.tree.Node;
import data_structure.tree.TreeUtility;
import java.util.LinkedList;
import java.util.Queue;
/*

 */
public class HeightBST {

    public static final class Pair {
        public final boolean first;
        public final int second;
        public Pair(boolean first, int second) {
            this.second = second;
            this.first = first;
        }
    }

    public static void main(String[] args) {
        Node root = TreeUtility.getSampleBinarySearchTree();
        //root.left = null;
        // root.right.left = null;
        root.right.right.right = new Node(8);
        root.right.right.right.left = new Node(9);
        BTreePrinter.printNode(root);
        // System.out.println(maxDepth(root));
        System.out.println(isBalanced(root));
    }


    /**
     * https://leetcode.com/problems/maximum-depth-of-binary-tree/
     * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
     *
     * @param root
     * @return
     */

    public static int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }


    /**
     * https://leetcode.com/problems/minimum-depth-of-binary-tree/
     * A binary tree's maximum depth is the number of nodes along the longest path from the root
     * node down to the farthest leaf node.
     *
     * @param root
     * @return
     */

    public static int minDepth(Node root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;
        if (root.left == null)
            return 1 + minDepth(root.right);
        if (root.right == null)
            return 1 + minDepth(root.left);
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }


    public static int minDepthLevelOrder(Node root) {
        if (root == null) return 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        int level = 1;
        while (!queue.isEmpty()) {
            Node tmp = queue.poll();
            if (queue.isEmpty()) {
                break;
            }
            if (null == tmp) {
                level++;
                queue.add(null);
                continue;
            }
            if (tmp.left == null && tmp.right == null) {
                break;
            }
            if (tmp.left != null) {
                queue.add(tmp.left);
            }
            if (tmp.right != null) {
                queue.add(tmp.right);
            }
        }
        return level;
    }


    /**
     * https://leetcode.com/problems/balanced-binary-tree/
     * <p>
     * a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
     **/
    public static boolean isBalanced(Node root) {
        return isBalancedHelper(root).first;
    }

    public static Pair isBalancedHelper(Node root) {
        if (null == root) {
            return new Pair(true, 0);
        }
        Pair left = isBalancedHelper(root.left);
        Pair right = isBalancedHelper(root.right);
        int height = Math.max(left.second, right.second) + 1;
        if (!left.first || !right.first || Math.abs(left.second - right.second) > 1) {
            return new Pair(false, height);
        }
        return new Pair(true,height);
    }


}
