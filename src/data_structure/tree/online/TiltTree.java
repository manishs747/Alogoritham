package data_structure.tree.online;

import data_structure.tree.BTreePrinter;
import data_structure.tree.Node;
import data_structure.tree.TreeUtility;

/**
 * https://leetcode.com/problems/binary-tree-tilt/
 */
public class TiltTree {

    public static void main(String[] args) {
        Node root = TreeUtility.getSampleBinarySearchTree();
        BTreePrinter.printNode(root);
        TiltTree t = new TiltTree();
        t.updateNodeTilt(root);
        BTreePrinter.printNode(root);
    }


    /*****    update node with tilt tilt              ***/

    public void updateNodeTilt(Node root) {
        updateTiltHelper(root);
    }

    private int updateTiltHelper(Node root) {
        if (root == null)
            return 0;
        int ls = updateTiltHelper(root.left);
        int rs = updateTiltHelper(root.right);
        int returnVal = root.data + ls + rs;
        root.data = Math.abs(ls - rs);
        return returnVal;
    }


    /*****    sum tilt              ***/
    private int sum = 0;

    public int findTilt(Node root) {
        fintTiltHelper(root);
        return sum;
    }

    private int fintTiltHelper(Node root) {
        if (root == null)
            return 0;
        int ls = fintTiltHelper(root.left);
        int rs = fintTiltHelper(root.right);
        sum += Math.abs(ls - rs);
        return root.data + ls + rs;
    }
}
