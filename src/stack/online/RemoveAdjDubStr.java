package stack.online;


import java.util.Stack;

/*
https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
 */
public class RemoveAdjDubStr {


    public static void main(String[] args) {
        System.out.println(removeDuplicates("abbaca"));
    }


    public static String removeDuplicates(String S) {
       if (null == S || S.length() < 2){
           return S;
       }
       StringBuilder sb = new StringBuilder();
       Stack<Character> stack = new Stack<>();
        for (char c :S.toCharArray()) {
           if(stack.isEmpty() ||stack.peek() != c ){
               stack.push(c);
           }else{
               stack.pop();
           }
        }
        //System.out.println(stack);
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
       return sb.reverse().toString();
    }


    /**
     * https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/
     * @param S
     * @return
     */
    public static String removeDuplicates2(String S,int k) {
        if (null == S || S.length() < 2){
            return S;
        }
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (char c :S.toCharArray()) {
            if(stack.isEmpty() ||stack.peek() != c ){
                stack.push(c);
            }else{
                stack.pop();
            }
        }
        //System.out.println(stack);
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
