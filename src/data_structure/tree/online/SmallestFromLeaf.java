package data_structure.tree.online;


/**
 * https://leetcode.com/problems/smallest-string-starting-from-leaf/?envType=daily-question&envId=2024-04-17
 */
public class SmallestFromLeaf {




    public static void main(String[] args) {

    /*  String cur = String.valueOf((char)(1+'a'));

        System.out.println(cur);*/

        int [] arr = {0,1,2,3,4,3,4};//"dba"

        //[25,1,3,1,3,0,2]

        TreeNode a = new TreeNode(25);
        TreeNode b = new TreeNode(1);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(1);
        TreeNode e = new TreeNode(3);
        TreeNode f = new TreeNode(0);
        TreeNode g = new TreeNode(2);
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;
        a.left = b;
        a.right = c;

        TreeNodePrinter.printNode(a);


        String str1 = "abd";
        String str2= "abc";

    /*    int result = str1.compareTo(str2);
        System.out.println(result);*/

      System.out.println(smallestFromLeaf(a));
    }

    public static String smallestFromLeaf(TreeNode root) {
        return smallestFromLeaf(root,"",new StringBuilder());
    }

    public static String smallestFromLeaf(TreeNode root ,String min ,StringBuilder sb ) {
      if (root == null) return min;
      String cur = String.valueOf((char)(root.val+'a'));
      sb.append(cur);
      if(root.left == null &&  root.right == null){
           if(min.equals("") || reverseString(sb.toString()).compareTo(min) < 0)
               min = reverseString(sb.toString());
      }
      min = smallestFromLeaf(root.left,min,sb);
      min = smallestFromLeaf(root.right,min,sb);
      sb.deleteCharAt(sb.length()-1);
      return min;
    }

    public static String reverseString(String str) {
        return new StringBuilder(str).reverse().toString();
    }


    public static String smallestFromLeaf2(TreeNode root, String min, StringBuilder sb) {
        if (root == null) return min;

        sb.append((char) (root.val + 'a'));

        if (root.left == null && root.right == null) {
            String current = sb.reverse().toString(); // Reverse only when necessary
            if (min.isEmpty() || current.compareTo(min) < 0) {
                min = current;
            }
            sb.reverse(); // Revert back to original string
        }

        min = smallestFromLeaf2(root.left, min, sb);
        min = smallestFromLeaf2(root.right, min, sb);

        sb.deleteCharAt(sb.length() - 1);

        return min;
    }








}
