package data_structure.tree;

import java.util.ArrayList;
import java.util.List;

public class SubTree {

    public static void main(String[] args) {
        Node s = TreeUtility.getSampleBinarySearchTree();
        BTreePrinter.printNode(s);
        Node t = new Node(1,new Node(1),null);
        BTreePrinter.printNode(t);
        System.out.println(isSubtree(t,new Node(1)));
    }



    public static boolean isSubtree(Node s, Node t) {
        if(s == null && t == null){
          return true;
        }
        if(t == null ){
            return false;
        }
        List<Node> list = new ArrayList<>();
        searchNode(s,t.data,list);
        for (Node node:list) {
           if(isSubtreehelper(node,t)){
               return true;
           }
        }
        return false;
    }

    public static boolean isSubtreehelper(Node s, Node t) {
        if(s == null ^ t == null ){
           return false;
        }
        if(s == null){
           return true;
        }
        if( s.data != t.data){
            return false;
        }
        boolean left = isSubtreehelper(s.left, t.left);
        if(!left){
            return false;
        }
        return isSubtreehelper(s.right, t.right);
    }

    public static void searchNode(Node node, int data , List<Node> list) {
       if(null == node){
           return ;
       }
       if(node.data == data){
           list.add(node);
       }
      searchNode(node.left,data,list);
      searchNode(node.right,data,list);
    }

/***********************Other Solution better***********************************/
public boolean equals(Node x,Node y)
{
    if(x==null && y==null)
        return true;
    if(x==null || y==null)
        return false;
    return x.data==y.data && equals(x.left,y.left) && equals(x.right,y.right);
}
    public boolean traverse(Node s,Node t)
    {
        return  s!=null && ( equals(s,t) || traverse(s.left,t) || traverse(s.right,t));
    }
}
