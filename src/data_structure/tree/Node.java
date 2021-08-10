package data_structure.tree;

/*
  https://www.youtube.com/watch?v=oSWTXtMglKE&t=218s
  https://www.youtube.com/watch?v=qH6yxkw0u78

 */
public class Node {
    public Node left, right;
    public int data;

    public Node(int data) {
        this.data = data;
    }

    public Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

   public void insert(int value){
      if(value <= data){
          if(left == null){
              left = new Node(value);
          }else{
            left.insert(value);
          }
      }else{
          if(right == null){
              right = new Node(value);
          }else{
             right.insert(value);
          }
      }
   }

    public boolean contains(int value) {
        if (data == value) {
            return true;
        } else if (value < data) {
            if (left == null) {
                return false;
            } else {
                return left.contains(value);
            }
        } else {
            if (right == null) {
                return false;
            } else {
                return right.contains(value);
            }
        }
    }


    public void inorder() {
        if (left != null) {
            left.inorder();
        }
        System.out.println(data);
        if (right != null) {
            right.inorder();
        }
    }


    @Override
    public String toString() {
        return this.data + "";
    }

}
