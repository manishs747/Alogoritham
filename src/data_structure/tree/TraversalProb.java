package data_structure.tree;


public class TraversalProb {

    public static void main(String[] args) {
        /*Node root = TreeUtility.getSampleBinarySearchTree();
        BTreePrinter.printNode(root);
        System.out.print("[");
        minDiffInBST(root,Integer.MIN_VALUE);
        System.out.print("]");*/
    }

    public boolean isSameTree(Node p, Node q) {
        if(p == null && q == null){
           return true;
        }
        if((p == null || q == null)||(p.data != q.data)){
            return false;
        }
       if(!isSameTree(p.left,q.left)){
           return false;
       }
        if(!isSameTree(p.right,q.right)){
            return false;
        }
        return true;
    }


    public static int minDiffInBST(Node root, int prev) {
        if(null == root){
            return Integer.MIN_VALUE;
        }
        prev = minDiffInBST(root.left,prev);
        System.out.println("Current:"+root.data);
        System.out.println("Prev:"+prev);
        return minDiffInBST(root.right,root.data);
    }





}
