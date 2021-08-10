package data_structure.tree.traversal;

import data_structure.tree.BTreePrinter;
import data_structure.tree.Node;
import data_structure.tree.TreeUtility;

import java.util.*;

public class LevelOrder {


    public static void main(String[] args) {
        Node root = TreeUtility.getSampleBinarySearchTree();
        root.left.data = 8;
        root.left.right.data = 13;

        BTreePrinter.printNode(root);
        printLevelOrder(root);

    }


    //bfs
    public static void printLevelOrder(Node node) {
        if (node == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node tempNode = queue.poll();
            System.out.print(tempNode.data + " ");
            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }
            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }

        }
    }


    public static void printLevelOrderLineSingleQueue(Node node) {
        if (node == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        queue.add(null);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current == null) {
                if (queue.isEmpty()) {
                    break;
                }
                System.out.println();
                queue.add(null);
            } else {
                System.out.print(current.data + " ");
                /*Enqueue left child */
                if (current.left != null) {
                    queue.add(current.left);
                }
                /*Enqueue right child */
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
        }
    }


    /*
    https://leetcode.com/problems/find-bottom-left-tree-value/
     */
    public static int findBottomLeftValue(Node node) {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(node);
        queue.add(null);
        Node last = node;
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current == null) {
                if (queue.isEmpty()) {
                   return last.data;
                }
                last = null;
                queue.add(null);
            } else {
                if(last == null){
                    last = current;
                }

                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
        }
        return last.data;
    }


    /*
https://leetcode.com/problems/find-largest-value-in-each-tree-row/
 */
    public static List<Integer> largestValues(Node node) {
        List<Integer> result = new ArrayList<>();
        if(node == null){
            return result;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        queue.add(null);
        int max = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current == null) {
                result.add(max);
                if (queue.isEmpty()) {
                    return result;
                }
                max = Integer.MIN_VALUE;
                queue.add(null);
            } else {
                max = Math.max(max,current.data);
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
        }
        return result;
    }


    //easy
    public static void printLevelOrderLineTwoQueue(Node node) {
        if (node == null) {
            return;
        }
        Queue<Node> first = new LinkedList<Node>();
        Queue<Node> second = new LinkedList<Node>();
        first.add(node);

        while (!first.isEmpty() || !second.isEmpty()) {
            if (first.isEmpty()) {
                Queue<Node> tmp = first;
                first = second;
                second = tmp;
            }
            while (!first.isEmpty()) {
                Node current = first.poll();
                System.out.print(current.data + " ");
                /*Enqueue left child */
                if (current.left != null) {
                    second.add(current.left);
                }
                /*Enqueue right child */
                if (current.right != null) {
                    second.add(current.right);
                }
            }
            System.out.println();
        }

    }


    public static void levelOrderTraversalReverse(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<Node>();
        Stack<Node> stack = new Stack<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            stack.push(temp);
            if (temp.right != null) {
                queue.add(temp.right);
            }
            if (temp.left != null) {
                queue.add(temp.left);
            }
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop().data + " ");
        }
    }


    //https://www.geeksforgeeks.org/level-order-traversal-in-spiral-form/
    public static void levelOrderTraversalZigZag(Node root) {

    }


    /***************************************AVERAGE******************************************************************/

 /*
    https://leetcode.com/problems/average-of-levels-in-binary-tree/
     */
    public static List<Double> averageOfLevelDFS(Node root) {
        List<Double> result = new ArrayList<>();
        List<Integer> count = new ArrayList<>();
        averageOfLevelDFSHelper(root, 0, result, count);
        for (int i = 0; i < result.size(); i++) {
            result.set(i, result.get(i) / count.get(i));
        }
        return result;
    }

    public static void averageOfLevelDFSHelper(Node root, int h, List<Double> sum, List<Integer> count) {
        if (root == null) {
            return;
        }
        if (h < sum.size()) {
            sum.set(h, sum.get(h) + root.data);
            count.set(h, count.get(h) + 1);
        } else {
            sum.add(1.0 * root.data);
            count.add(1);

        }
        averageOfLevelDFSHelper(root.left, h + 1, sum, count);
        averageOfLevelDFSHelper(root.right, h + 1, sum, count);
    }


    public static List<Double> averageOfLevelDoubleQueue(Node root) {
        List<Double> result = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            double sum = 0, count = 0;
            Queue<Node> tmp = new LinkedList<>();
            while (!queue.isEmpty()) {
                Node node = queue.remove();
                sum += node.data;
                count++;
                if (null != node.left) {
                    tmp.add(node.left);
                }
                if (null != node.right) {
                    tmp.add(node.right);
                }
            }
            result.add(sum / count);
            queue = tmp;
        }
        return result;
    }


    public static List<Double> averageOfLevelSingQueue(Node root) {
        List<Double> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        boolean asc = false;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        Double sum = 0.0;
        Double count = 0.0;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (queue.isEmpty()) {
                result.add(sum / count);
                break;
            }
            if (node == null) {
                queue.add(null);
                result.add(sum / count);
                sum = 0.0;
                count = 0.0;
                continue;
            }
            sum += node.data;
            count++;

            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return result;
    }

/*
    public static Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        queue.add(null);
        Node prev = null;
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current == null) {
                if (queue.isEmpty()) {
                    break;
                }
                queue.add(null);
                prev = null;
            } else {
                if (null != prev) {
                    prev.next = current;
                }
                prev = current;
                *//*Enqueue left child *//*
                if (current.left != null) {
                    queue.add(current.left);
                }
                *//*Enqueue right child *//*
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
        }
        return root;
    }*/


}
