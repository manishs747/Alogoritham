package data_structure.tree;

import java.util.*;

public class LevelOrder {


    public static void main(String[] args) {
        Node root = TreeUtility.getSampleBinarySearchTree();
        BTreePrinter.printNode(root);
       System.out.println( averageOfLevelDoubleQueue(root));
    }



    //bfs
    public static void printLevelOrder(Node node) {
        if(node==null){return;}
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(node);
        while(!queue.isEmpty()){
            Node tempNode = queue.poll();
            System.out.print(tempNode.data + " ");
            /*Enqueue left child */
            if(tempNode.left != null){
                queue.add(tempNode.left);
            }
            /*Enqueue right child */
            if(tempNode.right!=null){
                queue.add(tempNode.right);
            }

        }
    }


    public static void printLevelOrderLineSingleQueue(Node node){
        if(node==null){return;}
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(node);
        queue.add(null);
        while(!queue.isEmpty()){
            Node current  = queue.poll();
            if(current == null){
                if(queue.isEmpty()){
                    break;
                }
                System.out.println();
                queue.add(null);
            }else{
                System.out.print(current.data + " ");
                /*Enqueue left child */
                if(current.left != null){
                    queue.add(current.left);
                }
                /*Enqueue right child */
                if(current.right!=null){
                    queue.add(current.right);
                }
            }
        }
    }


    //easy
    public static void printLevelOrderLineTwoQueue(Node node){
        if(node == null){
            return;
        }
        Queue<Node> first = new LinkedList<Node>();
        Queue<Node> second = new LinkedList<Node>();
        first.add(node);

        while(!first.isEmpty() || !second.isEmpty()){
            if(first.isEmpty()){
                Queue<Node> tmp = first;
                first = second;
                second = tmp;
            }
            while(!first.isEmpty()){
                Node current = first.poll();
                System.out.print(current.data + " ");
                /*Enqueue left child */
                if(current.left != null){
                    second.add(current.left);
                }
                /*Enqueue right child */
                if(current.right!=null){
                    second.add(current.right);
                }
            }
            System.out.println();
        }

    }


    public static void levelOrderTraversalReverse(Node root){
        if(root==null){return;}
        Queue<Node> queue = new LinkedList<Node>();
        Stack<Node> stack = new Stack<Node>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node temp = queue.poll();
            stack.push(temp);
            if(temp.right != null){
                queue.add(temp.right);
            }
            if(temp.left != null){
                queue.add(temp.left);
            }
        }

        while(!stack.isEmpty()){
            System.out.print(stack.pop().data+" ");
        }
    }


    //https://www.geeksforgeeks.org/level-order-traversal-in-spiral-form/
    public static void levelOrderTraversalZigZag(Node root){

    }



/***************************************AVERAGE******************************************************************/

 /*
    https://leetcode.com/problems/average-of-levels-in-binary-tree/
     */

public static List<Double> averageOfLevelDFS(Node root) {
    List<Double> result = new ArrayList<>();
    List<Integer> count = new ArrayList<>();
    averageOfLevelDFSHelper(root,0,result,count);
    for (int i =0 ;i < result.size();i++){
        result.set(i,result.get(i)/count.get(i));
    }
    return result ;
}

    public static void averageOfLevelDFSHelper(Node root, int h, List<Double> sum, List<Integer> count){
        if(root == null){
            return;
        }
        if (h < sum.size()){
            sum.set(h,sum.get(h)+ root.data);
            count.set(h,count.get(h)+1);
        }else{
            sum.add(1.0 * root.data);
            count.add(1);

        }
        averageOfLevelDFSHelper(root.left,h+1,sum,count);
        averageOfLevelDFSHelper(root.right,h+1,sum,count);
    }


    public static List<Double> averageOfLevelDoubleQueue(Node root) {
        List<Double> result = new ArrayList<>();
        Queue <Node> queue = new LinkedList < > ();
        queue.add(root);
        while (!queue.isEmpty()){
            double sum = 0,count = 0;
            Queue <Node> tmp = new LinkedList < > ();
            while (!queue.isEmpty()){
               Node node  =  queue.remove();
               sum += node.data;
               count ++;
               if(null != node.left){
                   tmp.add(node.left);
               }
                if(null != node.right){
                    tmp.add(node.right);
                }
            }
            result.add(sum/count);
            queue = tmp;
        }
        return result ;
    }





    public static List<Double> averageOfLevelSingQueue(Node root) {
        List<Double> result = new ArrayList<>();
        if(root == null) {
            return result;
        }
        boolean asc = false;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        Double sum = 0.0;
        Double count = 0.0 ;
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            if(queue.isEmpty()){
                result.add(sum/count);
                break;
            }
            if(node == null) {
                queue.add(null);
                result.add(sum/count);
                sum = 0.0;
                count = 0.0 ;
                continue;
            }
            sum += node.data;
            count++;

            if(node.left != null){
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }
        }
        return result;
    }

}
