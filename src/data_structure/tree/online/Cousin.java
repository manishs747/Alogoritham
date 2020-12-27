package data_structure.tree.online;

import data_structure.tree.BTreePrinter;
import data_structure.tree.Node;
import data_structure.tree.TreeUtility;

public class Cousin {


    public static void main(String[] args) {
        Node root = TreeUtility.getSampleBinarySearchTree();
        BTreePrinter.printNode(root);
        System.out.println(new Cousin().isCousins(root,1,7));
    }


     Node xParent = null ;
     int xH = -1;
     Node yParent = null ;
     int yH = -1;

    public  boolean isCousins(Node root, int x, int y) {
        isCousins(root,x,y,0);
        if(xParent != yParent && xH == yH){
            return true;
        }
        return false;
    }

    public  void isCousins(Node root, int x, int y, int h) {
        if(root == null){
            return;
        }
        if(xH != -1 && yH != -1){
            return;
        }
        if(root.left != null){
            if(root.left.data == x) {
                xParent = root;
                xH = h+1;
            }
            if(root.left.data == y) {
                yParent = root;
                yH = h+1;
            }

        }
        if(root.right != null){
            if(root.right.data == x) {
                xParent = root;
                xH = h+1;
            }
            if(root.right.data == y) {
                yParent = root;
                yH = h+1;
            }

        }
        isCousins(root.left,x,y,h+1);
        isCousins(root.right,x,y,h+1);
    }



    public int[] findMode(Node root) {


        return null;
    }







}
