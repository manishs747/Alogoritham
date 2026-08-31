package data_structure.tree.online;

import java.util.*;

public class AllPossibleBinaryTree {


    public class TreeNode {
        int val;
    TreeNode left;
    TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
        this.left = left;
         this.right = right;
     }
    }



    public Map<Integer,List<TreeNode>> memo = new HashMap<>();


    public List<TreeNode> allPossibleFBT(int n) {
       if (n%2 == 0) return null;
       if(n == 1) return Arrays.asList(new TreeNode());
       if(memo.containsKey(n)) return memo.get(n);
       List<TreeNode> result = new ArrayList<>();
       int leftCount = 1 ,rightCount = n - 2;
        while (rightCount > 0){
            List<TreeNode> leftList = allPossibleFBT(leftCount);
            List<TreeNode> rightList = allPossibleFBT(rightCount);
            for (TreeNode leftChild : leftList){
                for (TreeNode rightChild : rightList){
                    TreeNode newRoot = new TreeNode(0,cloneTree(leftChild),cloneTree(rightChild));
                    result.add(newRoot);
                }
            }
            leftCount = leftCount + 2;
            rightCount = rightCount - 2;

        }
        memo.put(n,result);
       return result;
    }

    public  TreeNode cloneTree(TreeNode root) {
        if (root == null) return null;
        TreeNode newNode = new TreeNode();
        newNode.left = cloneTree(root.left);
        newNode.right = cloneTree(root.right);
        return newNode;
    }



}
