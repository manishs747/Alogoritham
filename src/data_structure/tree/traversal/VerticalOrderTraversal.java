package data_structure.tree.traversal;

import java.util.*;

public class VerticalOrderTraversal {

    public class TreeNode {
        public TreeNode left, right;
        public int val;

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private Map<Integer,List<int []>> sortedListMap = new TreeMap<>();


    public List<List<Integer>> verticalTraversal(TreeNode root) {
        dfs(root,0,0);
        List<List<Integer>> result = new ArrayList<>();
        for(List<int []> list : sortedListMap.values()){
            Collections.sort(list,(a,b)->a[0] == b[0] ? a[1]-b[1]:a[0]-b[0]);
            List<Integer> colList = new ArrayList<>();
            for (int [] arr: list){
                colList.add(arr[1]);
            }
            result.add(colList);
        }
        return result;
    }


    public void dfs(TreeNode root,int row, int col){
        if(root == null) return;
        sortedListMap.computeIfAbsent(col,_->new ArrayList<>()).add(new int[]{row,root.val});
        dfs(root.left,row+1,col-1);
        dfs(root.right,row+1,col+1);
    }


    /********************************SOL 2***************************/
    private Map<Integer, TreeMap<Integer, List<Integer>>> sortedListMap2 = new TreeMap<>();

    public void dfs2(TreeNode root, int row, int col) {
        if (root == null) return;
        sortedListMap2
                .computeIfAbsent(col, c -> new TreeMap<>())
                .computeIfAbsent(row, r -> new ArrayList<>())
                .add(root.val);
        dfs(root.left, row + 1, col - 1);
        dfs(root.right, row + 1, col + 1);
    }

    public List<List<Integer>> verticalTraversal2(TreeNode root) {
        dfs(root, 0, 0);
        List<List<Integer>> result = new ArrayList<>();
        for (TreeMap<Integer, List<Integer>> colMap : sortedListMap2.values()) {
            List<Integer> colList = new ArrayList<>();
            for (List<Integer> values : colMap.values()) {
                Collections.sort(values); // sort same-position values
                colList.addAll(values);
            }
            result.add(colList);
        }
        return result;
    }


}
