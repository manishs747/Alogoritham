package data_structure.tree.construction_convertion.construct;

import data_structure.tree.BTreePrinter;
import data_structure.tree.Node;

import java.util.HashMap;
import java.util.Map;

public class ConstPrePost {


    public static void main(String[] args) {
        int[] preorder = {3,4,1,2};
        int[] postOrder = {1,4,2,3};
        Node root = constructBTFromPrePost(preorder, postOrder);
        BTreePrinter.printNode(root);
    }


    /**************************************BST FROM Pre Post**********************************************************************************/

    //https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/
    static int preIndex = 0, posIndex = 0;

    public static Node constructBTFromPrePost(int[] pre, int[] post) {
        Node root = new Node(pre[preIndex++]);
        if (root.data != post[posIndex])
            root.left = constructBTFromPrePost(pre, post);
        if (root.data != post[posIndex])
            root.right = constructBTFromPrePost(pre, post);
        posIndex++;
        return root;
    }


    /**
     * good and easy to understand
     * @param pre
     * @param post
     * @return
     */

    public Node constructFromPrePost(int[] pre, int[] post) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < post.length; i++){
            map.put(post[i], i);
        }
        return dfs(pre, 0, pre.length - 1, post, 0, post.length - 1, map);
    }
    private Node dfs(int[] pre, int preStart, int preEnd, int[] post, int postStart, int postEnd, Map<Integer, Integer> map){
        if (preStart > preEnd || postStart > postEnd){
            return null;
        }
        Node root = new Node(pre[preStart]);
        if (preStart + 1 <= preEnd){
            int deltaIndex = map.get(pre[preStart+1]) - postStart;
            root.left = dfs(pre, preStart + 1, preStart + 1 + deltaIndex, post, postStart, postStart + deltaIndex, map);
            root.right = dfs(pre,  preStart + 1 + deltaIndex + 1, preEnd, post, postStart + deltaIndex + 1, postEnd - 1, map);
        }
        return root;
    }


}
