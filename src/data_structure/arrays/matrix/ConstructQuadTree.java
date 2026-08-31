package data_structure.arrays.matrix;

/**
 * https://leetcode.com/problems/construct-quad-tree/?envType=company&envId=uber&favoriteSlug=uber-six-months
 */
public class ConstructQuadTree {

    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }

    public static void main(String[] args) {

    }


    public Node construct(int[][] grid) {
        return construct(grid,0,0,grid.length);
    }


    public Node construct(int[][] grid, int sr ,int sc, int size) {
        int val = grid[sr][sc];
        boolean isleaf =  isLeaf(grid,sr,sc,size,val);
        boolean rootVal = isleaf && val == 1 ? true: false;
        Node root = new Node(rootVal,isleaf);
        if(isleaf) return root;
        size = size/2;
        root.topLeft = construct(grid,sr,sc,size);
        root.topRight = construct(grid,sr,sc+size,size);
        root.bottomLeft = construct(grid,sr+size,sc,size);
        root.bottomRight = construct(grid,sr+size,sc+size,size);
        return root;
    }

    public boolean isLeaf(int[][] grid, int sr ,int sc, int size, int val){
        for(int i = sr ; i < sr + size ;i++ ){
            for (int j = sc; j < sc + size ; j++) {
                if(grid[i][j] != val) return false;
            }
        }
        return true;
    }

}
